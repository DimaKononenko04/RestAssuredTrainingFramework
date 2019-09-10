package codewars_tests;

import codewars.TrailingZeros;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrailingZerosTest {
    @Test
    public void test(){
        assertThat(TrailingZeros.zeros(0), is(0));
        assertThat(TrailingZeros.zeros(6), is(1));
        assertThat(TrailingZeros.zeros(14), is(2));
    }
}
