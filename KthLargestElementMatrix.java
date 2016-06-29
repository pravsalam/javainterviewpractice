import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by praveenkumaralam on 12/26/15.
 */
public class KthLargestElementMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                    { 5, 7,  8,  9 },
                    { 6, 9,  10, 13 },
                    { 7, 11, 12, 15 },
                    { 8, 13, 16, 17 } };
        //find 10
        int n = 10;
        findNumber(matrix,n);
        int k =10;
        findKthLargest(matrix, k);
    }
    static void findNumber(int[][] matrix, int n){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int i=0,j= cols-1;

        while(i<rows && j>=0){
            if(matrix[i][j] == n){
                System.out.println("Found the item at "+i+" "+j);
                return;
            }
            if(matrix[i][j] <n){
                i++;
            }
            if(matrix[i][j] > n){
                j--;
            }
        }
    }
    static void findKthLargest(int[][] matrix,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2 ) return 1;
                else if(o1 >o2 ) return -1;
                else return 0;
            }
        });
        int count=0;
        int j;
        for(j=matrix[0].length-1;j>=0;j--){
            for(int i= matrix.length-1;i>=0;i--){
                pq.add(matrix[i][j]);
                if(pq.size() ==k){
                    int kthelem = pq.remove();
                    System.out.println(count +" "+ kthelem );
                }
            }
        }

    }
}
