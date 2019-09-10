package codewars;

public class AreSame {
    public static boolean comp(int[] a, int[] b){
        if (a == null || b == null || a.length == 0 || b.length == 0){
            return false;
        }
        boolean elementEquality = false;
        for (int first : a) {
            for (int second : b) {
                if (first*first == second){
                    elementEquality = true;
                    break;
                }else {
                    elementEquality = false;
                }
            }
            if (!elementEquality){
                break;
            }
        }

        return elementEquality;
    }

}
