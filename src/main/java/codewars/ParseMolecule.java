package codewars;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

private static final String SEPARATE_ATOMS_REGEX = "([A-Z][a-z]?)\\d?";
private static final String INSIDE_BRACES_REGEX = "[\\(\\[\\{].+[\\)\\]\\}]\\d?";
private static final String ELEMENTS_BEFORE_BRACES_REGEX = "^([A-Z][a-z]?)\\d?(?=[\\[({])";
private static final String REMOVE_CHARS_AND_BRACKETS_REGEX = "^[\\[({]([A-Z][a-z]?\\d?)+|[\\])}]\\d?$";
private static final String BRACKETS_PRESENT_IN_STRING_REGEX = ".*?[\\[({].*";
private static final String CHARS_IN_FIRST_BRACKETS = "^[\\[({]([A-Z][a-z]?\\d?)+[\\[({]";
private static int atomMultiplier = 1;

    public static void splitFormula(String formula, Map<String,Integer> atoms, String regex){
        Matcher matching = getMatching(formula, regex);
        while (matching.find()){
            atoms.put(matching.group().replaceAll("\\d",""),
                    Integer.parseInt(matching.group().replaceAll("\\D","").equals("") ? "1" :matching.group().replaceAll("\\D","")));
        }
    }

    public static Matcher getMatching(String formula,String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(formula);
    }

    public static void separateAtomsInsideBrackets(String formula, List<Map<String,Integer>> list){
        if (formula.equals("") | formula.matches("\\w+\\d?")){
            return;
        }

        String partOfFormula = "";
        Matcher insideBraces = getMatching(formula, INSIDE_BRACES_REGEX);
        while (insideBraces.find()){
            partOfFormula = insideBraces.group();
            atomMultiplier *= Integer.parseInt(partOfFormula.substring(partOfFormula.length() - 1));
        }

        String secondPartOfFormula = "";
        Matcher matching = getMatching(partOfFormula,CHARS_IN_FIRST_BRACKETS);
        while (matching.find()){
            secondPartOfFormula = matching.group();
        }

        Matcher matching1 = getMatching(!secondPartOfFormula.equals("") ?secondPartOfFormula:partOfFormula, SEPARATE_ATOMS_REGEX);
        while (matching1.find()){
            Map<String,Integer> mapWithValues = new LinkedHashMap<>();
            mapWithValues.put(matching1.group().replaceAll("\\d",""),
                    Integer.parseInt(matching1.group().replaceAll("\\D","").equals("") ? "1" :matching1.group().replaceAll("\\D","")) * atomMultiplier);
            list.add(mapWithValues);
        }
        partOfFormula = partOfFormula.replaceAll(REMOVE_CHARS_AND_BRACKETS_REGEX,"");

        separateAtomsInsideBrackets(partOfFormula,list);
    }





    public static Map<String,Integer> getAtoms(String formula){
        Map<String,Integer> atoms = new LinkedHashMap<>();
        List<Map<String,Integer>> list = new LinkedList<>();
        // if there is no brackets in formula
        if (!formula.matches(BRACKETS_PRESENT_IN_STRING_REGEX)) {
            splitFormula(formula,atoms,SEPARATE_ATOMS_REGEX);
            return atoms;
        }
        // if brackets are present in formula
        else {
            splitFormula(formula,atoms,ELEMENTS_BEFORE_BRACES_REGEX);
            separateAtomsInsideBrackets(formula,list);
        }
        return atoms;
    }

    public static void main(String[] args) {
//        String formula = "Mg4{ON(SO3)3}2";
//        String formula = "H2SO4";
//        String formula = "H2O";
        String formula = "Mg(OH)2";
//        String formula = "K4[ON(SO3)2]2";
//        String formula = "pie";
        System.out.println(ParseMolecule.getAtoms(formula));
    }
}
