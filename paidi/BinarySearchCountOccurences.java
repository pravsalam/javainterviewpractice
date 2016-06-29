package paidi;

import java.net.Inet4Address;

/**
 * Created by praveenkumaralam on 12/20/15.
 */
public class BinarySearchCountOccurences {
    public static void main(String[] args){
        Integer[] a = {0,0,0,1,1,1,2,3,3,4,4, 4, 5, 6, 6 };
                    // 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14
        int num =6;
        int low = 0;
        int high = a.length-1;
        int occurences = 0;
        while(low<=high){
            System.out.println(Integer.toString(low)+" "+ Integer.toString(high));
            int mid = (low+high)/2;
            if(a[mid] == num){
                //we found
                //go left and find
                int leftcount = 0;
                int rightcount = 0;
                int i = mid-1;
                while(i>=0 && a[i] == num) {leftcount++;i--;}
                i=mid+1;
                while(i<=high && a[i] == num){rightcount++;i++;}
                occurences = leftcount+rightcount+1;
                break;
            }
            else{
                if(a[mid] >num){
                    //it is on the left;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        System.out.println("found count "+ Integer.toString(occurences));

    }
}
