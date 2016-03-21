import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Liz on 14.03.2016.
 */
public class WordChains {

    private String[] dictionary;

    public WordChains(String filepath) {
        dictionary = loadDictionary(filepath);
    }

    public String[] chain(String word1, String word2) {
        word1 = clean(word1);
        word2 = clean(word2);
        if(validateInput(word1, word2)) {
            return getChain(word1, word2);
        }
        return null;
    }

    private String[] getChain(String word1, String word2) {

        if(word1.equals(word2)) {
            return new String[]{word1};
        }

        String[] subChain = getSubChain(word1, word2);
        if(subChain == null) {
            return null;
        }

        return join(word1, subChain);
    }

    private String[] getSubChain(String word1, String word2) {
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                String newWord = createNewWord(word1, word2, i);
                String[] subChain = chain(newWord, word2);
                if(subChain != null) {
                    return subChain;
                }
            }
        }
        String[] words = getAlternativeWords(word1, word2);
        if(words != null) {
            for (int i = 0; i < words.length; i++) {
                String[] chain = chain(words[i], word2);
                if (chain != null) {
                    return chain;
                }
            }
        }
        return null;
    }

    private String createNewWord(String word1, String word2, int pos) {
        return word1.substring(0,pos) + word2.charAt(pos) + word1.substring(pos+1);
    }

    private String createNewWord(String word1, char character, int pos) {
        return word1.substring(0, pos) + character + word1.substring(pos + 1);
    }

    private String[] getAlternativeWords(String word1, String word2) {
        ArrayList<String> alternatives = new ArrayList<String>();
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 'a'; j <='z'; j++) {
                String newWord = createNewWord(word1, (char)j, i);
                if(searchDictionary(newWord) != -1) {
                    alternatives.add(newWord);
                };
            }
        }
        return toArray(alternatives);
    }

    private boolean validateInput(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }
        return true;
    }

    private String[] join(String firstWord, String[] rest) {
        String[] result = new String[rest.length + 1];
        result[0] = firstWord;
        for(int j = 0; j < rest.length; j++) {
            result[j+1] = rest[j];
        }
        return result;
    }

    protected String clean (String word) {
        word = word.toLowerCase();

        if(searchDictionary(word) == -1) {
            return null;
        }
        return word;
    }

    protected int searchDictionary(String word) {
        for (int i = 0; i < dictionary.length; i++) {
            if(dictionary[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private String[] loadDictionary(String filepath) {
        String[] lines = null;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            lines = readLines(br);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

    private String[] readLines(BufferedReader br) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        String line = br.readLine();

        while (line != null) {
            lines.add(line);
            line = br.readLine();
        }

        return toArray(lines);
    }

    private String[] toArray(ArrayList<String> list) {
        String[] array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }

    public String[] getDictionary() {
        return dictionary;
    }
}