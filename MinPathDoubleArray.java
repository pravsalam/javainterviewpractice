import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by praveenkumaralam on 8/11/15.
 */
public class MinPathDoubleArray {
    public static void main(String[] args){
        int[][] grid = new int[][]{{3,-20,30},{-3, 4, 0}};
        int width = grid[0].length;
        int height = grid.length;
        int[][] minSumGrid = new int[height][width];
        int i = 0;
        int j = 0;
        int currentSum = 0;
        for(i =0;i< height;i++ ){
            for(j = 0; j< width;j++){
                if(i == 0 && j ==0 ){
                    minSumGrid[i][j] = grid[i][j];
                }
                else if( i == 0 && j > 0){
                    minSumGrid[i][j]= minSumGrid[i][j-1] + grid[i][j];
                }
                else if( j == 0 && i  > 0){
                    minSumGrid[i][j] = minSumGrid[i-1][j] +grid[i][j];
                }
                else{
                    if(minSumGrid[i][j-1] < minSumGrid[i-1][j]){
                        minSumGrid[i][j] = minSumGrid[i][j-1] + grid[i][j];
                    }
                    else{
                        minSumGrid[i][j] = minSumGrid[i-1][j] + grid[i][j];
                    }
                }
            }
        }
        //return minSumGrid[height -1][width -1];
    }
}
