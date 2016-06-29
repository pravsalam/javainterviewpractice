/**
 * Created by praveenkumaralam on 10/27/15.
 */
public class RotatedSortedArray {
    public static void main(String[] args){
        int[] a= {5,6,7,8,9,10,1,2,3,4};
        int k = 1;
        int index = binarySearch(a,k,a[0], 0,a.length-1);
        System.out.println(Integer.toString(index));
    }
    private static int binarySearch(int[] a, int k, int first, int low, int high) {
        if(low > high) return -1;
        int mid = (low + high)/2;
        int emid = a[mid];
        if(k == emid ) return mid;
        if( k > first && emid > first && k>emid){
            return binarySearch(a,k,first,mid+1,high);
        }
        else if(k>first && emid >first && k <emid){
            return binarySearch(a,k,first, low, mid-1);
        }
        else if(k>first && emid <first && k >emid){
            return binarySearch(a,k,first, low, mid-1);
        }
        else if(k>first && emid <first && k <emid){
            //is this possible?
        }
        else if(k<first && emid >first &&  k>emid){
            //not possible
        }
        else if(k<first && emid >first && k<emid){
            return binarySearch(a,k,first, mid+1, high);
        }
        else if(k<first && emid <first && k>emid){
            return binarySearch(a,k,first, mid+1, high);
        }
        else if(k<first && emid <first && k<emid){
            return binarySearch(a,k,first, low, mid-1);
        }
        return -1;
    }
}
