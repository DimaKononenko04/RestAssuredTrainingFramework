package codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateEncoder {
    public static String encode(String word){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = word.toLowerCase().toCharArray();
        int occurrencesCounter = 0;
        String exceptionChar = "";
        for (char aChar : chars) {
            if (aChar =='^'){
                 exceptionChar = "\\^";
            }
            Pattern pattern = Pattern.compile("[" + exceptionChar + aChar +"]");
            Matcher matcher = pattern.matcher(word.toLowerCase());
            while (matcher.find()) {
                occurrencesCounter++;
            }
            if (occurrencesCounter > 1){
                stringBuilder.append(")");
            }else{
                stringBuilder.append("(");
            }
            occurrencesCounter = 0;
        }
        return stringBuilder.toString();
    }

    public static String encode2(String word){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = word.toLowerCase().toCharArray();
        int occurrencesCounter = 0;
        for (char aChar : chars) {
            for (char c : chars) {
                if (aChar == c){
                    occurrencesCounter++;
                }
            }
            stringBuilder.append(occurrencesCounter > 1 ?")":"(");
            occurrencesCounter = 0;
        }
        return stringBuilder.toString();
    }

    public static String encode3(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }
}
