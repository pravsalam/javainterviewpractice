/**
 * Created by praveenkumaralam on 1/8/16.
 */
public class MatrixPaintBrush {
    public static void main(String[] args){
        int[][] matrix = {  {1,0,0,0,1,1,0},
                            {1,1,1,0,0,0,0},
                            {0,0,0,1,1,1,1},
                            {1,1,1,1,0,0,0},
                            {0,1,0,1,0,1,0},
                            {1,0,1,0,1,0,1},
                            {1,1,0,0,1,1,0}};
        int color = 5;
        //solveSimple(matrix,color );
        //printmatrix(matrix);
        solvesmarter(matrix,color,3);

    }
    static void solveSimple(int[][] matrix, int color ){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i =0;i<rows;i++){
            for(int j= 0;j<cols;j++){
                if(matrix[i][j] ==0) matrix[i][j] = color;
            }
        }
    }
    static void printmatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void solvesmarter(int[][] matrix, int color, int n){
        //divide the matrix into n portions and solve.
        Thread thread1 = new Thread(new MyRunnable(matrix,1));
        Thread thread2 = new Thread(new MyRunnable(matrix, 2));
        thread1.start();
        thread2.start();
    }
}
class MyRunnable implements Runnable{
    int[][] matrix;
    int id;
    public MyRunnable(int[][] paramMatrix,int paramid){
        matrix = paramMatrix;
        id = paramid;
    }
    @Override
    public void run() {
        int k=0;
        int rows = matrix.length;
        int colomns = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<colomns;j++){
                System.out.print(matrix[i][j]+" ");
            }
            k++;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("    "+id);
        }
        System.out.println(" Hello Hello");
    }
}

class MyThread extends Thread{

}
