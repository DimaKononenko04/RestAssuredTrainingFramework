package codewars_tests;

import codewars.AreSame;
import org.junit.Assert;
import org.junit.Test;

public class AreSameTest {
    @Test
    public void test(){
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        Assert.assertTrue(AreSame.comp(a, b));
    }
}
