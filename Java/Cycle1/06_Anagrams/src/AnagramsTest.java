import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Liz on 13/03/2016.
 */
public class AnagramsTest {

    @Test
    public void testCreateMutations_oneLetterWords() {
        assertArrayEquals("test1", new String[] {"a"}, Anagrams.getMutations("a"));
    }

    @Test
    public void testCreateMutations_twoLetterWords() {
        assertArrayEquals("test1", new String[] {"ab", "ba"}, Anagrams.getMutations("ab"));
        assertArrayEquals("test2", new String[] {"cd", "dc"}, Anagrams.getMutations("cd"));
    }
}