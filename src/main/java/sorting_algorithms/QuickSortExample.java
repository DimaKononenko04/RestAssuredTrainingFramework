package sorting_algorithms;

import java.util.Arrays;

public class QuickSortExample {
    public static void main(String[] args) {
        Integer [] array = new Integer[]{12,13,24,10,3,6,90,70};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(Integer[] arr,int low,int high){
        //check for empty or null array
        if (arr ==null || arr.length == 0){
            return;
        }

        if (low >= high){
            return;
        }
        //Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        System.out.println(middle);
        int pivot = arr[middle];

        //make left < pivot and right > pivot
        int i =low, j =high;
        while(i <=j){
            //check until all values on left side array are lower than pivot
            while (arr[i] < pivot){
                i++;
            }
            //check until all values on right side a greater than pivot
            while (arr[j] > pivot){
                j--;
            }
            //now compare values from both side of lists to see if they need swapping
            //after swapping move the iterator on both lists
            if(i <= j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        //do same operation as above recusively to sort two sub arrays
        if(low < j){
            quickSort(arr,low,j);
        }
        if(high > i){
            quickSort(arr,i,high);
        }
    }

    public static void swap(Integer array[], int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
