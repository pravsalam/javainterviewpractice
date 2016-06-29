/**
 * Created by praveenkumaralam on 12/20/15.
 */
public class Monotonic {
    public static void main(String[] args){
        Integer[] a = {1,2,3,4,4,6,7,8,9};
        int i=1;
        int prev = a[0];
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        while(i<a.length){
            if(isIncreasing && a[i]<prev) isIncreasing= false;
            if(isDecreasing && a[i]>prev) isDecreasing = false;
            if(!isDecreasing && !isIncreasing) break;
            prev = a[i];
            i++;
        }
        if(isIncreasing)
            System.out.println("It is monotonically increasing");
        else if(isDecreasing)
            System.out.println("It is monotonically decreasing");
        else System.out.println("it is none");
    }
}
