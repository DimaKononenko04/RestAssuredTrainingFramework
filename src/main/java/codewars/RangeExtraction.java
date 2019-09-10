package codewars;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];
            int elementToPrint = arr[i];
            int spanCounter = 0;
            for (int j = i + 1; j <arr.length ; j++) {
                if (currentElement + 1 == arr[j]){
                    currentElement = arr[j];
                    i = j;
                    spanCounter++;
                }else{
                    break;
                }
            }
            if (elementToPrint != currentElement && spanCounter >= 2) {
                stringBuilder.append(elementToPrint).append("-").append(currentElement).append(currentElement!=arr[arr.length-1] ? "," : "");
            } else if (elementToPrint != currentElement){
                stringBuilder.append(elementToPrint).append(",").append(currentElement).append(currentElement!=arr[arr.length-1] ? "," : "");
            }else{
                stringBuilder.append(elementToPrint).append(elementToPrint!=arr[arr.length-1] ? "," : "");
            }
        }
        return stringBuilder.toString();
    }

}
