package codewars;

public class PigLatin {
    public static String pigIt(String str){
        StringBuilder stringBuilder = new StringBuilder();
        String suffix = "ay";
        for (String token : str.split("\\s")) {
            stringBuilder.append(token.equals("!") || token.equals(",") || token.equals(".") || token.equals("?")
                    ? token
                    : token.substring(1) + token.substring(0,1) + suffix + " ");
        }
        return stringBuilder.toString().trim();
    }

    public static String pigIt2(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
