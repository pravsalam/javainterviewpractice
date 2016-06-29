/**
 * Created by praveenkumaralam on 12/22/15.
 */
public class DutchNationalSecondTime {
    public static void main(String[] args){
        int[] a ={0,0,0,0,0,2,2,2,2,1,1,1};
        // 0,1,2,0.........,0,1,2
        //0,1,1,0,1................,0,2,2
        //0,0,1,1,1,.........,0,2,2
        //0,0,1,1,1,0,..........2,2,2
        int low = 0;
        int mid = 0;
        int high = a.length-1;
        while(mid<=high){
            System.out.println("before " +low+" "+mid+" "+high+" "+a[mid]);
            if(a[mid] ==0){
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                mid++;
                low++;
            }
            else if(a[mid] == 1){
                mid++;
            }
            else if(a[mid] == 2){
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high --;
            }
            System.out.println("after " + low+" "+mid+" "+high);
        }
        for(int x:a){
            System.out.print(" "+x);
        }
    }
}
