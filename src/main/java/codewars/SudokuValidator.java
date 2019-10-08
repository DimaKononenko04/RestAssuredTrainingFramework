package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SudokuValidator {

    private static final List<Integer> SEQUENCE = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public static boolean check(int[][] sudoku){
        // iterate through rows
        //iterate through columns
        int startingIndexOfColumn = 0;
        //iterate by grids
        int columnIndex = 0;
        int startingIndexOfGrid = 0;
        int lastIndexOfGrid = 3;
        return compareByRow(sudoku) && compareByColumn(sudoku, startingIndexOfColumn)
                && compareByGrid(sudoku, columnIndex, lastIndexOfGrid, startingIndexOfGrid);
    }

    public static boolean compareByRow(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++) {
            List<Integer> arrayToCompare = new ArrayList<>();
            for (int j = 0; j < sudoku.length; j++) {
                arrayToCompare.add(sudoku[i][j]);
            }

            if (!compareArrays(arrayToCompare)) {
                return compareArrays(arrayToCompare);
            }
        }
        return true;
    }

    public static boolean compareByColumn(int[][] sudoku,int startingIndexOfColumn){
        if (startingIndexOfColumn > sudoku.length-1){
            return true;
        }
        List<Integer> arrayToCompare = new ArrayList<>();
        for (int i = 0; i < sudoku.length; i++) {
            arrayToCompare.add(sudoku[i][startingIndexOfColumn]);
        }
        if (!compareArrays(arrayToCompare)) {
            return false;
        }
        startingIndexOfColumn++;
        compareByColumn(sudoku,startingIndexOfColumn);
        return true;
    }

    public static boolean compareByGrid(int[][] sudoku,int startingIndexOfGrid, int lastIndexOfGrid, int startingIndexOfGrid2){
        if (startingIndexOfGrid == sudoku.length){
            startingIndexOfGrid = 0;
            lastIndexOfGrid+=3;
        }else if (lastIndexOfGrid > 8){
            return true;
        }
        List<Integer> arrayToCompare = new ArrayList<>();
        for (int i = startingIndexOfGrid; i < lastIndexOfGrid; i++) {
            for (int j = startingIndexOfGrid2; j < lastIndexOfGrid; j++) {
                arrayToCompare.add(sudoku[i][j]);
            }
        }
        if (!compareArrays(arrayToCompare)) {
            return false;
        }

        startingIndexOfGrid+=3;
        compareByGrid(sudoku,startingIndexOfGrid,lastIndexOfGrid,startingIndexOfGrid2);
        return true;
    }

    public static boolean compareArrays(List<Integer> arrayToCompare){
        Collections.sort(arrayToCompare);
        return SEQUENCE.equals(arrayToCompare);
    }
}
