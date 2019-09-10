package codewars_tests;

import codewars.StringToCamelCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToCamelCaseTest {
    @Test
    public void test(){
        String input = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        System.out.println("input: "+input);
        assertEquals("YouHaveChosenToTranslateThisKataForYourConvenienceWeHaveProvidedTheExistingTestCasesUsedForTheLanguageThatYouHaveAlreadyCompletedAsWellAsAllOfTheOtherRelatedFields", StringToCamelCase.toCamelCase(input));
    }
}
