package codewars_tests;

import codewars.CaesarCipher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void test() {
        String u = "I should have known that you would have a perfect answer for me!!";
        List<String> v = Arrays.asList("J vltasl rlhr", " zdfog odxr y", "pw atasl rlhr", " p gwkzzyq zn", "tyhv lvz wp!!");
        assertEquals(v, CaesarCipher.movingShift(u, 1));
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
    }
}
