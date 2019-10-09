package codewars;

import java.util.LinkedList;
import java.util.List;

public class CaesarCipher {

    public static List<String> movingShift(String s, int shift){
        return stringToList(createStringWithShiftedChars(s,shift,false));
    }

    public static String demovingShift(List<String> s, int shift){
        return createStringWithShiftedChars(listToString(s),shift,true);
    }

    public static String listToString(List<String> s){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : s) {
            stringBuilder.append(s1);
        }
        return stringBuilder.toString();
    }

    private static List<String> stringToList(String string){
        List<String> result = new LinkedList<>();
        int beginIndex = 0;
        int endIndex = string.length() % 5 == 0 ? string.length()/5 : (string.length()/5) + 1;
        int lastIndex = endIndex;
        for (int i = 0; i < 5; i++) {
            result.add(beginIndex > string.length() ? "" : lastIndex > string.length() ? string.substring(beginIndex) : string.substring(beginIndex,lastIndex));
            beginIndex = lastIndex;
            lastIndex += endIndex;
        }
        return result;
    }

    public static String createStringWithShiftedChars(String s, int shift, boolean reverse){
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            stringBuilder.append(charCanBeShifted(c) ? getShiftedCharacter(c,shift,reverse) : c);
            shift++;
        }
        return stringBuilder.toString();
    }

    private static boolean charCanBeShifted(char c){
        return String.valueOf(c).matches("[^!?\\s-.,';0-9]");
    }

    private static char getShiftedCharacter(char c, int shift , boolean reverse){
        int probableCharAsciiValue = reverse ?(int)c - shift : (int)c + shift;
        int shiftedCharAsciiValue;
        // get shifted char for Capital
        if (isCapitalCharacter(c)){
            if (probableCharAsciiValue < 65){
                shiftedCharAsciiValue = 91 - (Math.abs(probableCharAsciiValue -91) % 26 == 0 ? 26 : Math.abs(probableCharAsciiValue -91) % 26);
                return (char) shiftedCharAsciiValue;
            }else{
                shiftedCharAsciiValue = 64 + (Math.abs(probableCharAsciiValue -90) % 26 == 0 ? 26 : Math.abs(probableCharAsciiValue -90) % 26);
            }
            return (char) (probableCharAsciiValue > 90 ? shiftedCharAsciiValue : probableCharAsciiValue);
        }
        // get shifted char for lowercase
        if (probableCharAsciiValue < 97){
            shiftedCharAsciiValue = 123 - (Math.abs(probableCharAsciiValue -123) % 26 == 0 ? 26 : Math.abs(probableCharAsciiValue -123) % 26);
            return (char) shiftedCharAsciiValue;
        }else {
            shiftedCharAsciiValue = 96 + (Math.abs(probableCharAsciiValue -122) % 26 == 0 ? 26 : Math.abs(probableCharAsciiValue -122) % 26);
        }
        return (char) (probableCharAsciiValue > 122 ? shiftedCharAsciiValue : probableCharAsciiValue);
    }

    private static boolean isCapitalCharacter(char c){
        return (int)c >= 65 && (int)c <=90;
    }

}
