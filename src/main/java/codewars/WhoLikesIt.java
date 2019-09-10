package codewars;

public class WhoLikesIt {

    public static String whoLikesIt(String... names){
        String noOneTemplate = "no one likes this";
        String onePersonTemplate = "%s likes this";
        String twoPersonsTemplate = "%s and %s like this";
        String threePersonsTemplate = "%s, %s and %s like this";
        String multiplePersonsTemplate = "%s, %s and %d others like this";
        int arrayLength = names.length;
        switch (arrayLength){
            case 0: return noOneTemplate;
            case 1: return String.format(onePersonTemplate,names[0]);
            case 2: return String.format(twoPersonsTemplate,names[0],names[1]);
            case 3: return String.format(threePersonsTemplate,names[0],names[1],names[2]);
            default:return String.format(multiplePersonsTemplate,names[0],names[1],arrayLength-2);
        }
    }

}
