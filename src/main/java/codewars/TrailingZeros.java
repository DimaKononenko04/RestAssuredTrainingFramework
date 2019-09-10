package codewars;

public class TrailingZeros {
    public static int zeros(int n){
        int trailingZeros = 0;
        if (n==0){
            return trailingZeros;
        }

        int kMax = (int) (Math.log(n) / Math.log(5));
        for (int k = 1; k <=kMax ; k++) {
            trailingZeros+=(n/(Math.pow(5,k)));
        }

        return trailingZeros;
    }

}
