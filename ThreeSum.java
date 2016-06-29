import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by praveenkumaralam on 12/23/15.
 */
public class ThreeSum {
    public static void main(String[] args) {
        //three sum where  d = a+b+c
        int[] a = {4, 8, 9, 1, 3, 2, 6, 7, 5};
        //           2,-2,-3, 5, 3, 4, 0,-1, 1
        //
        int d = 6;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == d) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
        Arrays.sort(a);//nlogn
        for(int i=0;i<a.length;i++){ //n
            int low = i+1,high = a.length-1;
            while(low<high){//n
                if((a[i]+a[low]+a[high] )< d) low++;
                if((a[i]+a[low]+a[high])>d) high--;
                else{
                    System.out.println(a[i]+ " "+a[low]+" "+a[high]);
                    break;
                }
             }
        }//n^2
    }
    // quicksort type of solution
}
