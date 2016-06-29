import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int[][] matrix = new int[rows][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                matrix[i][j]  = sc.nextInt();
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int forwarddiag =0;
        int backwarddiag = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                System.out.print(matrix[i][j]+" ");
                if(i == j){
                    System.out.println("forward "+i+" "+j+" "+matrix[i][j]);
                    forwarddiag += matrix[i][j];
                }
                if( rows -i-1 == j){
                    System.out.println("backward "+i+" "+j+" "+matrix[i][j]);
                    //System.out.println(matrix[i][j]);
                    backwarddiag += matrix[i][j];
                }
            }
            System.out.println();
        }
        int diff = forwarddiag -backwarddiag;
        diff = diff<0?-1*diff:diff;
        System.out.println(diff);
    }
}