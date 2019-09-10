package codewars;

import java.util.ArrayList;
import java.util.List;

public class DRoot {

    public static int digitalRoot(int n){
        List<Integer> integers = new ArrayList<>();
        while (n > 0){
            integers.add(n % 10);
            n = n/10;
        }
        int sum = integers.stream().mapToInt(integer -> integer).sum();
        if(sum < 10){
            return sum;
        }
        sum = digitalRoot(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digitalRoot(456));
    }
}
