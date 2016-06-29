/**
 * Created by praveenkumaralam on 10/4/15.
 */
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class SukoduTest
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int rowC = 9;
        int colC = 9;
        int i=0,j=0;
        int[][] matrix = new int[9][9];
        for(i = 0;i<rowC;i++)
            for(j=0;j<colC;j++)
                matrix[i][j] = -1;
        matrix[0][0] = 5;
        matrix[0][1] = 3;
        matrix[0][4] = 7;
        matrix[1][0] = 6;
        matrix[1][3] = 1;
        matrix[1][4] = 9;
        matrix[1][5] = 5;
        matrix[2][1] = 9;
        matrix[2][2] = 8;
        matrix[2][7] = 6;
        matrix[3][0] = 8;
        matrix[3][4] = 6;
        matrix[3][8] = 3;
        matrix[4][0] = 4;
        matrix[4][3] = 8;
        matrix[4][5] = 3;
        matrix[4][8] = 1;
        matrix[5][0] = 7;
        matrix[5][4] = 2;
        matrix[5][8] = 6;
        matrix[6][1] = 6;
        matrix[6][6] = 2;
        matrix[6][7] = 8;
        matrix[7][3] = 4;
        matrix[7][4] = 1;
        matrix[7][5] = 9;
        matrix[7][8] = 5;
        matrix[8][4] = 8;
        matrix[8][7] = 7;
        matrix[8][8] = 9;
        //simple row check and column check
        for(i=0;i<rowC;i++){
            //no numer should repeat;
            int[] mic = new int[10];
            for(j=0;j<colC;j++){
                if(matrix[i][j] != -1)	{
                    if(mic[matrix[i][j]] !=1) mic[matrix[i][j]] = 1;
                    else{
                        System.out.println("It is not sudoku\n");
                        return;
                    }
                }
            }
        }
        for(j=0;j<colC;j++){
            int[] mic = new int[10];
            for(i=0;i<rowC;i++){
                if(matrix[i][j] != -1){
                    if(mic[matrix[i][j]] !=1) mic[matrix[i][j]] =1;
                    else{
                        System.out.println("it is not sudoku\n");
                        return;
                    }
                }
            }
        }
        for(i=0;i<rowC;i++){
            for(j = 0;j<colC;j++){
                if(i%3 ==0 && j%3 == 0){
                    if(!isValidSudoku(matrix, i, i+3, j, j+3)){
                        System.out.println("It is not sudoku\n");
                        return;
                    }
                }
            }
        }
    }
    private static boolean isValidSudoku(int[][] matrix, int llow, int lhigh, int rlow, int rhigh ){
        int i,j;
        int[] mic = new int[10];
        for(i=llow;i <lhigh;i++){
            for(j=rlow;j<rhigh;j++){
                if(matrix[i][j] >0) {
                    if (mic[matrix[i][j]] != 1) mic[matrix[i][j]] = 1;
                    else return false;
                }
            }
        }
        return true;
    }
}
