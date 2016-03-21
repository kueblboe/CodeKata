import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Liz on 14.03.2016.
 */
public class WordChainsTest {

    String[] testDictionary = {"bear", "beer", "cat", "cot", "dog", "dot", "hog", "lead", "log", "rat", "read", "reed", "ruby"};
    String filepath = "miniwordlist.txt";
    
    WordChains wordChainer1 = new WordChains(filepath);

    @Test
    public void loadDictionary() {
        String[] dictionary = wordChainer1.getDictionary();
        assertEquals("length of dictionary should be 13", 13, dictionary.length);
        assertEquals("word at pos 7 should be 'lead'", "lead", dictionary[7]);
        assertEquals("word at pos 12 should be 'ruby'", "ruby", dictionary[12]);
    }

    @Test
    public void searchDictionary() {
        assertEquals(-1, wordChainer1.searchDictionary("beelzebub"));
        assertEquals(2, wordChainer1.searchDictionary("cat"));
        assertEquals(4, wordChainer1.searchDictionary("dog"));
    }

    @Test
    public void chainInvalidWords() {
        assertNull("words not in dictionary are invalid", wordChainer1.chain("asdfaf", "wookie"));
        assertNull("words not the same length are invalid", wordChainer1.chain("lead", "log"));
    }

    @Test
    public void chainLengthOne() {
        assertArrayEquals("test identical words", new String[]{"ruby"}, wordChainer1.chain("ruby", "ruby"));
        assertArrayEquals("test uppercase words", new String[]{"cat"}, wordChainer1.chain("cat", "CAT"));
    }

    @Test
    public void chainLengthTwo() {
        assertArrayEquals("test1", new String[]{"dog", "hog"}, wordChainer1.chain("dog", "hog"));
        assertArrayEquals("test2", new String[]{"bear", "beer"}, wordChainer1.chain("bear", "beer"));
        assertArrayEquals("test2", new String[]{"dot", "cot"}, wordChainer1.chain("dot", "cot"));
    }

    @Test
    public void chainLengthThree() {
        assertArrayEquals("test1", new String[] {"dog", "dot", "cot"}, wordChainer1.chain("dog", "cot"));
        assertArrayEquals("test2", new String[] {"lead", "read", "reed"}, wordChainer1.chain("lead", "reed"));
    }

    @Test
    public void chainLengthFive() {
       assertArrayEquals("test longer chain", new String[] {"dog", "dot", "cot", "cat", "rat"}, wordChainer1.chain("dog", "rat"));
    }
}