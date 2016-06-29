/**
 * Created by praveenkumaralam on 12/28/15.
 */
public class RotatedArray {
    public static void main(String[] args){
        int[] a={6,7,8,9,10,1,2,3,4};
        int n = 2;
        int low = 0;
        int lastindex = a.length-1;
        int high = a.length-1;
        int first = a[0];
        while(low < high) {
            int mid = (low + high) / 2;
            System.out.println("Before " + low + " " + mid + " " + high);
            if (a[mid] == n) {
                System.out.println("Hello "+mid);
                return;
            }
            int emid = a[mid];
            if(n > first && emid > first && n< emid){
                high = mid-1;
            }
            if(n> first && emid > first && n>emid){
                low = mid+1;
            }
            if(n>first && emid < first && n<emid){
                high = mid-1;
            }
            if(n>first && emid < first && n > emid){
                //meh
            }
            if(n<first && emid> first && n<emid){
                low = mid+1;
            }
            if(n<first && emid >first && n>emid){
                //meh
            }
            if(n<first && emid <first && n<emid){
                high = mid-1;
            }
            if(n<first && emid <first && n>emid){
                low = mid+1;
            }
        }
    }
}
