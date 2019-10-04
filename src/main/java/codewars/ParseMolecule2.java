package codewars;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule2 {
    private static Iterator<String> tokenIter;
    private static Stack<Integer> bracketStk;

    private static final String  AT_NUM    = "[A-Z][a-z]?\\d*";
    private static final String  OPEN_BRA  = "[{(\\[]";
    private static final String  CLOSE_BRA = "[)}\\]]\\d*";
    private static final Pattern TOKENIZER = Pattern.compile(String.format("%s|%s|%s", AT_NUM, OPEN_BRA, CLOSE_BRA));
    // <at>  <num>  are named capturing groups
    private static final Pattern P_AT_NUM  = Pattern.compile("(?<at>[A-Z][a-z]*)(?<num>\\d*)");


    public static Map<String,Integer> getAtoms(String formula) {

        List<String> tokens = new ArrayList<>();
        Matcher m = TOKENIZER.matcher(formula);
        while (m.find()) tokens.add(m.group());

        if (!String.join("", tokens).equals(formula)) throw new IllegalArgumentException("Invalid formula");

        bracketStk = new Stack<Integer>();
        tokenIter  = tokens.iterator();

        RawForm ans = getRawFormula();
        if (!bracketStk.empty()) throw new IllegalArgumentException("Invalid formula");

        return ans;
    }


    private static RawForm getRawFormula() {

        RawForm raw = new RawForm();

        while (tokenIter.hasNext()) {
            String tok = tokenIter.next();

            if (tok.matches(OPEN_BRA)) {
                bracketStk.push((int) tok.charAt(0));
                raw.concatWith(getRawFormula());

            } else if (tok.matches(AT_NUM)) {
                Matcher m = P_AT_NUM.matcher(tok);
                m.find();
                raw.addAtom(m.group("at"), m.group("num").isEmpty() ? 1 : Integer.parseInt(m.group("num")));

            } else if (tok.matches(CLOSE_BRA)) {
                if (bracketStk.empty() || (bracketStk.peek()+1 != (int) tok.charAt(0) && bracketStk.peek()+2 != (int) tok.charAt(0)))
                    throw new IllegalArgumentException("Invalid formula");
                bracketStk.pop();

                if (tok.length() > 1) raw.mulBy(Integer.parseInt(tok.substring(1)));
                break;
            }
        }
        return raw;
    }

    static class RawForm extends HashMap<String,Integer> {
        public RawForm() { super(); }

        public void addAtom(final String atom, final int n) { this.put(atom, n + this.getOrDefault(atom, 0)); }
        public RawForm mulBy(final int n)                   { this.forEach(  (at,v) -> this.put(at, v*n) ); return this; }
        public RawForm concatWith(RawForm other)            { other.forEach( (at,v) -> this.put(at, v + this.getOrDefault(at, 0))  ); return this; }
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
//        System.out.println(ParseMolecule.getAtoms(formula1));
//        System.out.println(ParseMolecule.getAtoms(formula2));
//        System.out.println(ParseMolecule.getAtoms(formula3));
//        System.out.println(ParseMolecule.getAtoms(formula4));
//        System.out.println(ParseMolecule2.getAtoms(formula5));
//        System.out.println(ParseMolecule.getAtoms(formula6));
        System.out.println(ParseMolecule2.getAtoms(formula7));
    }
}
