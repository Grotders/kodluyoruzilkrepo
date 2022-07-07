package Arrayler;

import java.util.Arrays;

public class MatrixTranspose {

    public static void main(String[] args) {

        int matrix[][] = {{2,3,4}, {5,6,4}};
        printMatrix(matrix);

        transpose(matrix);
    }


    static void transpose(int matrix[][]) {
        int temp[][] = new int[matrix[0].length][matrix.length];

        for (int i=0; i<matrix[0].length; i++){
            for(int j=0; j< matrix.length; j++){
                temp[i][j] = matrix[j][i];
            }
        }
        printMatrix(temp);
    }

    static void printMatrix(int arr[][]) {
        for (var nums : arr) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
    }
}
