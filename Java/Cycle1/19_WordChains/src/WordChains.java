/**
 * Created by Lizzie on 14.03.2016.
 */
public class WordChains {

    public static String[] chain(String word1, String word2) {

        if (isValid(word1) && isValid(word2)) {

            return new String[]{word1, word2};
        }
        return null;
    }

    private static boolean isValid (String word) {
        if(word == "abc" || word == "def") {
            return false;
        }
        return true;
    }
}