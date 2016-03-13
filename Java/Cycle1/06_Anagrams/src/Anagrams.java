/**
 * Created by Liz on 13/03/2016.
 */

public class Anagrams {

    public static String[] getMutations(String word) {
        String mutations[] = new String[getNumberMutations(word)];

        for(int i = 0; i < word.length(); i++) {
            if (i == 0) {
                mutations[i] = word;
            } else {
                mutations[i] = "" + word.charAt(1) + word.charAt(0);
            }
        }

        return mutations;
    }

    private static int getNumberMutations(String word) {
        // number mutations equals word-length factorial
        int result = 1;
        for (int i = word.length(); i > 1; i--) {
            result *= i;
        }
        return result;
    }
}
