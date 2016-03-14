import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Lizzie on 14.03.2016.
 */
public class WordChainsTest {

    @Test
    public void chainInvalidWord() {
        assertArrayEquals("test1", null, WordChains.chain("abc", "def"));
    }

    @Test
    public void chainLengthOne() {
        assertArrayEquals("test1", new String[]{"dog", "hog"}, WordChains.chain("dog", "hog"));
        assertArrayEquals("test2", new String[]{"bear", "beer"}, WordChains.chain("bear", "beer"));
    }
}