/**
 * Created by praveenkumaralam on 10/16/15.
 */
public class Kthelement {
    public static void main(String[] args){
        int[] a = {6,7,11,3,1,9,12,8,2};
        int k=0;
        int len = a.length;
        int kth = select(a,0,len-1, k);
        System.out.println(Integer.toString(kth));
    }
    static int select(int[] a, int low, int high, int pos){
        if(low > high) return -1;
        // [6,2,1,3,11,9,12,8,7]
        System.out.println(" low = "+Integer.toString(low)+" high = " + Integer.toString(high));
        int i = low;
        int j = high;
        int pivot = a[low];
        while(i < j ){
            while(a[i] <= pivot) {if(i < high) i++; else break;}

            while(a[j] >= pivot) {if(j> low) j--; else break;}
            if(i<j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //now i, j
        //a[i] = pivot;
        a[low] = a[j];
        a[j] = pivot;
        if(j == pos) return pivot;
        else if(j< pos) return select(a, j+1, high, pos);
        else if(j> pos) return select(a, low, j-1, pos);
        return 0;
    }
}
