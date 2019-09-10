package codewars_tests;

import codewars.DuplicateEncoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoderTest {
    @Test
    public void test(){
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))", DuplicateEncoder.encode2("   ()(   "));
        assertEquals("(", DuplicateEncoder.encode("^"));
    }
}
