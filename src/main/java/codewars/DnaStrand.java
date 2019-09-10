package codewars;

public class DnaStrand {
    public static String makeComplement(String dna){
        StringBuilder builder = new StringBuilder();
        for (char c : dna.toCharArray()) {
            builder.append(getComplement(c));
        }
        return builder.toString();
    }

    private static char getComplement(char c){
        switch (c){
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
        }
        return c;
    }
}
