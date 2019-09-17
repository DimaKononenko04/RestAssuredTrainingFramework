package codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

private static final String REGEX = "([A-Z][a-z]?)\\d?";
private static final String INSIDE_BRACES_REGEX = "[\\(\\[\\{].+[\\)\\]\\}]\\d?";
private static final String NUMBERS_AFTER_BRACES_REGEX = "[\\]})](\\d)";
private static final String ELEMENTS_BEFORE_BRACES_REGEX = "^([A-Z][a-z]?)\\d?(?=[\\[({])";


    public static String getAtoms(String formula,String regex){
        Map<String,Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(formula);
        while (match.find()){
//            map.put(match.group().replaceAll("\\d",""),Integer.parseInt(match.group().replaceAll("\\D","").equals("") ? "1" :match.group().replaceAll("\\D","")));
            stringBuilder.append(match.group()).append("---");
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String formula = "Mg4{ON(SO3)2}2";
        System.out.println(ParseMolecule.getAtoms(formula, REGEX));
        System.out.println(ParseMolecule.getAtoms(formula, INSIDE_BRACES_REGEX));
        System.out.println(ParseMolecule.getAtoms(formula, NUMBERS_AFTER_BRACES_REGEX));
        System.out.println(ParseMolecule.getAtoms(formula, ELEMENTS_BEFORE_BRACES_REGEX));
    }
}
