import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liz on 13/03/2016.
 */

public class KarateChopTest {

    @Test
    public void testEmptyArray() {
        int testArray[] = {};
        assertEquals(-1, KarateChop.chop(2, testArray));
    }

    @Test
    public void testArrayWith1Item() {
        int testArray[] = {1};
        assertEquals(0, KarateChop.chop(1, testArray));
        assertEquals(-1, KarateChop.chop(2, testArray));
    }

    @Test
    public void testArrayWith2Items() {
        int testArray[] = {1,2};
        int testArray2[] = {3,5};
        assertEquals("test1", 0, KarateChop.chop(1, testArray));
        assertEquals("test2", 1, KarateChop.chop(2, testArray));
        assertEquals("test3", 0, KarateChop.chop(3, testArray2));
        assertEquals("test4", 1, KarateChop.chop(5, testArray2));
        assertEquals("test5", -1, KarateChop.chop(0, testArray));
        assertEquals("test6", -1, KarateChop.chop(4, testArray));
    }

    @Test
    public void testArrayWith3Items() {
        int testArray[] = {1, 3, 5};
        assertEquals("test1", 0, KarateChop.chop(1, testArray));
        assertEquals("test2", 1, KarateChop.chop(3, testArray));
        assertEquals("test3", 2, KarateChop.chop(5, testArray));
    }

    @Test
    public void testArrayWith4Items() {
        int testArray[] = {4, 6, 8, 10};
        assertEquals("test1", 1, KarateChop.chop(6, testArray));
    }
}