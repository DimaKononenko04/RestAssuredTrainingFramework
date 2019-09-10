package codewars;

public class Snail {

    public static int[] snail2(int[][] array) {
        if (array[0].length == 0) return new int[0];
        int n = array.length;
        int[] answer = new int[n*n];
        int index=0;
        for (int i = 0; i<n/2; i++){
            for (int j = i; j < n-i; j++) answer[index++] = array[i][j];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[j][n-i-1];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[n-i-1][n-j-1];
            for (int j = i+1; j < n-i-1; j++) answer[index++] = array[n-j-1][i];
        }
        if (n%2 != 0) answer[index++] = array[n/2][n/2];
        return answer;
    }

    public static int[] snail(int[][] array){

        if (array.length ==0 ){
            return new int[]{};
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i].length ==0){
                return new int[]{};
            }

        }
        int numberOfElementsInArray = array.length *array.length;
        int [] resultArray = new int[numberOfElementsInArray];

        int counter =0;
        int reverseCounter = 0;
        int start = 0;
        int end = array.length;

        while (counter<numberOfElementsInArray){
            for (int i = start; i < end; i++) {
                if (i==start){
                    for (int j = start; j <end ; j++) {
                        resultArray[counter] = array[i][j];
                        counter++;
                    }
                }
                if (i!=start && i<end-1){
                    resultArray[counter] = array[i][end-1];
                    counter++;
                }
                if (i == end-1 && i!=start){
                    for (int j = end-1; j >=start; j--) {
                        resultArray[counter] = array[i][j];
                        counter++;
                    }
                }
            }

            start++;
            end--;
            for (int i = end-1; i >= start ; i--) {
                resultArray[counter] = array[i][reverseCounter];
                counter++;
            }
            reverseCounter++;
        }
        return resultArray;

    }

}
