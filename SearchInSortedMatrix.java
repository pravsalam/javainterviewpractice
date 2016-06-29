/**
 * Created by praveenkumaralam on 12/24/15.
 */
public class SearchInSortedMatrix {
    public static void main(String[] args){
        int[][] a = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        findElement(a, 7);
        divideAndConquer(a, 0,a.length, 0,a[0].length, 7);
    }
    public static void findElement(int[][] a,int num){
        int rows = a.length;
        int cols = a[0].length;
        for(int i=0;i<rows-1;i++){
            if(a[i][0] <=num && a[i+1][0] >num){
                //System.out.println(a[i][0]+" "+a[i+1][0]);
                //it is in row i
                int low = 0;
                int high = cols-1;
                while(low<high){
                    int mid = (low+high)/2;
                    //System.out.println(low+" "+high+" "+" "+mid+" mid = "+a[i][mid]);
                    if(a[i][mid] == num){
                        System.out.println("Found the number"+a[i][mid]);
                        break;
                    }else if(a[i][mid]> num){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }
                break;
            }
        }
    }
    private static boolean divideAndConquer(int[][] a,int lrow, int hrow, int lcol, int hcol, int num){
        //divide the matrix into 4 quadrants
        // find the mean and check its value
        System.out.println(lrow+" "+hrow+" "+lcol+" "+hcol);
        if(lrow > hrow ) return false;
        if(lcol > hcol) return false;
        int x_med = (lrow+hrow)/2;
        int y_med = (lcol+hcol)/2;
        if(a[x_med][y_med] == num){
            System.out.println("found the value in recursion");
            return true;
        }else if( a[x_med][y_med] < num){
            //search in 3
            if(divideAndConquer(a, lrow, x_med, y_med, hcol,num)) return true;
            if(divideAndConquer(a, x_med, hrow, lcol, y_med,num)) return true;
            if(divideAndConquer(a, x_med, hrow, y_med, hcol,num)) return true;

        }
        else{
            if(divideAndConquer(a, lrow, x_med, lcol, y_med,num)) return true;
            if(divideAndConquer(a, lrow, x_med, y_med, hcol,num))return true;
            if(divideAndConquer(a, x_med, hrow, lcol, y_med,num))return true;
        }
        return false;

    }
}
