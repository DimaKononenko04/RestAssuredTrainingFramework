package codewars_tests;

import codewars.PaginationHelper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PaginationHelperTest {
    @Test
    public void testSomething() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a','b','c','d','e','f','g','h'),4);
        assertEquals(8,helper.itemCount());
        assertEquals(2,helper.pageCount());
        assertEquals(-1,helper.pageItemCount(4));
        assertEquals(1,helper.pageIndex(8));
    }
}
