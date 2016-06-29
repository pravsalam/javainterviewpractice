package DynamicProgramming;

/**
 * Created by praveenkumaralam on 11/11/15.
 */
public class LongestIncreasingMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,9},
                          {5,3,8},
                          {4,6,7}};
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dpmat= new int[height][width];
        int i=0;
        int j=0;
        for(i=0;i<height;i++){
            for(j=0;j<width;j++){
                    getLongestIncreasing(i,j, matrix,dpmat);
            }
        }
        for(i=0;i<height;i++){
            for(j=0;j<width;j++){
                System.out.print(Integer.toString(dpmat[i][j]));
            }
            System.out.println("");
        }
    }
    static int getLongestIncreasing(int i, int j, int[][] matrix,int[][] dpmat){
        int height = matrix.length;
        int width  = matrix[0].length;
        if(i<0 || i >= height || j <0 || j>= width){
            return 0;
        }
        int maxlongest = 0;
        int temp =0;
        if(i >0 &&matrix[i][j] == matrix[i-1][j]+1){
            temp  = 1+getLongestIncreasing(i-1, j, matrix,dpmat);
            if(temp >maxlongest) maxlongest = temp;
        }
        if(i<height-1 &&matrix[i][j] == matrix[i+1][j]+1){
            temp = 1+getLongestIncreasing(i+1, j, matrix, dpmat);
            if(temp > maxlongest) maxlongest = temp;
        }
        if(j>0 &&matrix[i][j] == matrix[i][j-1]+1){
            temp = 1+getLongestIncreasing(i,j-1, matrix,dpmat);
            if(temp> maxlongest) maxlongest = temp;
        }
        if(j< width-1 &&matrix[i][j] == matrix[i][j+1]+1){
            temp = 1+getLongestIncreasing(1,j+1, matrix, dpmat);
        }
        if(maxlongest >0)
            dpmat[i][j] = maxlongest;
        else
            dpmat[i][j] =1;
        return dpmat[i][j];
    }
}
