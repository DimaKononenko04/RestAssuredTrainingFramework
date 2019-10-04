package codewars;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

private static final String SEPARATE_ATOMS_REGEX = "([A-Z][a-z]?)(\\d+)?";
private static final String INSIDE_BRACES_REGEX = "[\\(\\[\\{].+[\\)\\]\\}]\\d?";
private static final String ELEMENTS_BEFORE_AND_AFTER_BRACES_REGEX = "^(([A-Z][a-z]?)(\\d+)?)+(?=[\\[({])|(([A-Z][a-z]?)(\\d+)?)+$";
private static final String REMOVE_CHARS_AND_BRACKETS_REGEX = "^[\\[({]([A-Z][a-z]?\\d?)+|[])}]\\d?$";
private static final String BRACKETS_PRESENT_IN_STRING_REGEX = ".*?[\\[({].*";
private static final String CHARS_IN_FIRST_BRACKETS_REGEX = "^[\\[({]([A-Z][a-z]?\\d?)+[\\[({]";
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

    public static void putSplittedElementsIntoList(Matcher matcher, List<Map<String,Integer>> list){
        while (matcher.find()){
            Matcher separatedAtoms = getMatching(matcher.group(),SEPARATE_ATOMS_REGEX);
            while (separatedAtoms.find()){
                Map<String,Integer> mapWithValues = new HashMap<>();
                mapWithValues.put(separatedAtoms.group().replaceAll("\\d",""),
                        Integer.parseInt(separatedAtoms.group().replaceAll("\\D","").equals("") ? "1" : separatedAtoms.group().replaceAll("\\D",""))*atomMultiplier);
                list.add(mapWithValues);
            }
        }
    }


    public static void separateAtomsInsideBrackets(String formula, List<Map<String,Integer>> list){
        if (formula.equals("") | formula.matches("\\w+\\d?")){
            return;
        }

        // get elements before and after brackets
        // problem is here
        Matcher elementsBeforeBrackets = getMatching(formula, ELEMENTS_BEFORE_AND_AFTER_BRACES_REGEX);
        putSplittedElementsIntoList(elementsBeforeBrackets,list);

        // get String containing only elements inside brackets and their multiplier
        String partOfFormula = "";
        Matcher insideBraces = getMatching(formula, INSIDE_BRACES_REGEX);
        while (insideBraces.find()){
            partOfFormula = insideBraces.group();
            atomMultiplier *= Integer.parseInt(partOfFormula.substring(partOfFormula.length() - 1));
        }

        String secondPartOfFormula = "";
        Matcher matching = getMatching(partOfFormula, CHARS_IN_FIRST_BRACKETS_REGEX);
        while (matching.find()){
            secondPartOfFormula = matching.group();
        }

        Matcher matching1 = getMatching(!secondPartOfFormula.equals("") ? secondPartOfFormula : partOfFormula, SEPARATE_ATOMS_REGEX);
        putSplittedElementsIntoList(matching1,list);

        partOfFormula = partOfFormula.replaceAll(REMOVE_CHARS_AND_BRACKETS_REGEX,"");

        separateAtomsInsideBrackets(partOfFormula,list);
    }

    public static void countAtomsAndPutThemIntoMap(List<Map<String,Integer>> list, Map<String,Integer> atoms){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 0) {
                continue;
            }
            String key = new ArrayList<>(list.get(i).keySet()).get(0);
            Integer value = new ArrayList<>(list.get(i).values()).get(0);
            for (int j = i+1; j <list.size() ; j++) {
                if (list.get(j).containsKey(key)){
                    value += new ArrayList<>(list.get(j).values()).get(0);
                }
            }
            atoms.put(key,value);
            removeMatchedAtoms(list,key);
        }
    }

    public static void removeMatchedAtoms(List<Map<String,Integer>> list, String key){
        for (Map<String, Integer> stringIntegerMap : list) {
            stringIntegerMap.remove(key);
        }
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
            separateAtomsInsideBrackets(formula,list);
            countAtomsAndPutThemIntoMap(list,atoms);
        }
        atomMultiplier = 1;
        return atoms;
    }

    public static void main(String[] args) {
//        String formula = "Mg4{ON(SO3)3}2";
//        String formula = "H2SO4";
        String formula1 = "H2O";
        String formula2 = "Mg(OH)2";
        String formula3 = "K4[ON(SO3)2]2";
        String formula4 = "C6H12O6";
        String formula5 = "(C5H5)Fe(CO)2CH3";
        String formula6 = "C2H2(COOH)2";
        String formula7 = "As2{Be4C5[BCo3(CO2)3]2}4Cu5";
//        String formula = "pie";
        System.out.println(ParseMolecule.getAtoms(formula1));
        System.out.println(ParseMolecule.getAtoms(formula2));
        System.out.println(ParseMolecule.getAtoms(formula3));
        System.out.println(ParseMolecule.getAtoms(formula4));
        System.out.println(ParseMolecule.getAtoms(formula5));
        System.out.println(ParseMolecule.getAtoms(formula6));
        System.out.println(ParseMolecule.getAtoms(formula7));
    }
}
