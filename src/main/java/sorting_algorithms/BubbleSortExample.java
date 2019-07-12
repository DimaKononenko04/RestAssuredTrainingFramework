package sorting_algorithms;

import java.util.Arrays;

public class BubbleSortExample {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{15,12,13,24,10,3,6,90,70};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(Integer[] array){
        for (int i = 0; i <array.length ; i++) {
            boolean isSorted = true;
            for (int j = 0; j <array.length-1; j++) {
                if(array[j] > array[j+1]){
                    isSorted = false;
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
