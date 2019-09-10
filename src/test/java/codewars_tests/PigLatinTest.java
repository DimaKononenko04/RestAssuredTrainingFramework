package codewars_tests;

import codewars.PigLatin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTest {
    @Test
    public void test(){
        assertEquals("igPay atinlay siay oolcay !", PigLatin.pigIt("Pig latin is cool !"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    }
}
