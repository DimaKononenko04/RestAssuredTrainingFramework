package codewars;

import java.util.stream.Collectors;

public class TwoToOne {

    public static String longest(String s1, String s2){
//        List<Character> list = new ArrayList<>();
//        for (char c : s1.concat(s2).toCharArray()) {
//            list.add(c);
//        }
//        StringBuilder builder = new StringBuilder();
//        list.stream().sorted().distinct().forEach(builder::append);
//        return builder.toString();
        return s1.concat(s2).chars().distinct().mapToObj(c->String.valueOf((char)c)).sorted().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(longest("abccc", "ddddef"));
    }
}
