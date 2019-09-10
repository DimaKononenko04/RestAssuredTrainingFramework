package codewars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringToCamelCase {
    public static String toCamelCase(String s){
        String[] split = s.split("[_-]");
//        for (String s1 : split) {
//            stringBuilder.append(s1.substring(0, 1).toUpperCase()).append(s1.substring(1));
//        }
        return  IntStream.range(1, split.length).mapToObj(i -> split[i].substring(0, 1).toUpperCase() + split[i].substring(1).toLowerCase()).collect(Collectors.joining("", split[0], ""));
    }

}
