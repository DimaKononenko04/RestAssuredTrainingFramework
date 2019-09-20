package codewars;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

private static final String SEPARATE_ATOMS_REGEX = "([A-Z][a-z]?)\\d?";
private static final String INSIDE_BRACES_REGEX = "[\\(\\[\\{].+[\\)\\]\\}]\\d?";
private static final String NUMBERS_AFTER_BRACES_REGEX = "[\\]})](\\d)";
private static final String ELEMENTS_BEFORE_BRACES_REGEX = "^([A-Z][a-z]?)\\d?(?=[\\[({])";
private static final String REMOVE_CHARS_AND_BRACKETS_REGEX = "^\\w+\\d?[\\[({]|[\\])}]\\d$";
private static final String BRACKETS_PRESENT_IN_STRING_REGEX = ".*?[\\[({].*";


    public static Map<String,Integer> getAtoms(String formula){
        // if there is no brackets in formula
        Map<String,Integer> atoms = new LinkedHashMap<>();
        if (!formula.matches(BRACKETS_PRESENT_IN_STRING_REGEX)) {
            Pattern pattern = Pattern.compile(SEPARATE_ATOMS_REGEX);
            Matcher match = pattern.matcher(formula);
            while (match.find()){
                atoms.put(match.group().replaceAll("\\d",""),
                        Integer.parseInt(match.group().replaceAll("\\D","").equals("") ? "1" :match.group().replaceAll("\\D","")));
            }
            return atoms;
        }
        else {

        }

//        List<Map<String,Integer>> separatedAtoms = new ArrayList<>();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher match = pattern.matcher(formula);
//        while (match.find()){
//            Map<String,Integer> map = new HashMap<>();
//            map.put(match.group().replaceAll("\\d",""),
//                    Integer.parseInt(match.group().replaceAll("\\D","").equals("") ? "1" :match.group().replaceAll("\\D","")));
//            separatedAtoms.add(map);
//            stringBuilder.append(match.group()).append("---");
//        }

        return atoms;
    }


    public static void main(String[] args) {
        String formula = "Mg4{ON(SO3)2}2";
//        String formula = "H2O";
//        String formula = "Mg(OH)2";
//        String formula = "K4[ON(SO3)2]2";
//        String formula = "pie";
        System.out.println(ParseMolecule.getAtoms(formula));
//        System.out.println(ParseMolecule.getAtoms(formula, INSIDE_BRACES_REGEX));
//        System.out.println(ParseMolecule.getAtoms(formula, NUMBERS_AFTER_BRACES_REGEX));
//        System.out.println(ParseMolecule.getAtoms(formula, ELEMENTS_BEFORE_BRACES_REGEX));
    }
}
