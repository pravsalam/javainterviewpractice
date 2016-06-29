/**
 * Created by praveenkumaralam on 10/16/15.
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] a ={3,4,5,6,7,8,9,10,11,12,13,14};
        int find = 21;
        if(binarySearch(a,0,a.length-1, find)){
            System.out.println("Present");
        }
        else System.out.println("Not Present");

    }
    private static boolean binarySearch(int[] a, int low, int high, int find){
        //if(a == null) return false;
        System.out.println("low = "+Integer.toString(low)+" high "+Integer.toString(high));
        if(low > high) return false;
        if(find < a[low] && find > a[high]) return false;
        int middle = (low+high)/2;
        if(a[middle] == find) return true;
        else if(a[middle] < find ) return binarySearch(a, middle+1, high, find);
        else if(a[middle] > find) return binarySearch(a, low, middle-1, find);
        return false;
     }
}
