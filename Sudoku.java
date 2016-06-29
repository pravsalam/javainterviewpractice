/**
 * Created by praveenkumaralam on 12/22/15.
 */
public class Sudoku {
    public static void main(String[] args){
        int[][] a={ {0,0,9,7,4,8,0,0,0},
                    {7,0,0,0,0,0,0,0,0},
                    {0,2,0,1,0,9,0,0,0},
                    {0,0,7,0,0,0,2,4,0},
                    {0,6,4,0,1,0,5,9,0},
                    {0,9,8,0,0,0,3,0,0},
                    {0,0,0,8,0,3,0,2,0},
                    {0,0,0,0,0,0,0,0,6},
                    {0,0,0,2,7,5,9,0,0}};
        sudokuSolver(a);
        int rows = a.length;
        int cols = a[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void sudokuSolver(int[][] a){

        int rows = a.length;
        int cols = a[0].length;
        int i,j;
        for(i=0;i<rows;i++){
            for(j=0;j<cols;j++){
                if(a[i][j] == 0){
                    //it is unassigned. try with 1,2,3,4,5,6,7,8,9
                    for(int k=1;k<10;k++){
                        if(solvesudokuati(a,i,j,k)) break;
                    }
                }
            }
        }
    }
    private static boolean solvesudokuati(int[][] a, int row, int col, int value){
        a[row][col] = value;
        int rows =a.length;
        int cols = a[0].length;
        if(hasValidFilling(a,row,col)){
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(a[i][j] ==0){
                        for(int k=1;k<10;k++){
                            if(solvesudokuati(a,i,j,k)) break;
                        }
                    }
                }
            }
        }
        else return false;
        return true;
    }
    public static boolean hasValidFilling(int[][] a,int row,int col){
        int rows = a.length;
        int cols = a[0].length;
//        System.out.println("row = "+rows);
//        System.out.println("cols = "+cols);
        for(int i=0;i<rows;i++){
            if(i != row && a[i][col] == a[row][col]) {return false;}
        }
        for(int i=0;i<cols;i++){
            if(i != col && a[row][i] == a[row][col]) return false;
        }
        System.out.println("what?");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(" "+a[i][j]);
                if(i%3 ==0 && j%3 ==0){
                    if(!checkSmallerGrid(a,i,j,i+3,j+3)) { System.out.println("blooper");return false;}
                    else{
                        System.out.println(" worked?");
                    }
                }
                System.out.println();
            }

        }
        //System.out.println("got the grid");
        return true;
    }
    private static boolean checkSmallerGrid(int[][] a, int rlow,int clow,int rhigh, int chigh){
        //System.out.println(rlow+" "+clow+" "+rhigh+" "+chigh);
        //it should be a 3x3 matrix.
        int[] b = new int[9];
        int k=0;

        for(int i= rlow;i<rhigh;i++){
            for(int j=clow;j<clow;j++){
                //System.out.print(a[i][j]);
                if(a[i][j] !=0) {
                    b[k] = a[i][j];
                    k++;
                }
                //System.out.println();
            }
        }
//        for(int x: b){
//            System.out.print(" "+x);
//        }
        //System.out.println();
        int[] hash = new int[9];
        int max = k;
        for(k=0;k<9;k++) hash[k] =0;
        for(k=0;k<max;k++){
            if(hash[b[k]] >0) { System.out.println("returning false");return false;}
            else {System.out.println(" cool");hash[b[k]] =1;}
        }
        return true;
    }
}
