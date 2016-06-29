/**
 * Created by praveenkumaralam on 12/20/15.
 */
public class DutchNational {
    public static void main(String[] args){
        Integer[] a  = {0,0,0,0,1,0,0,2,2,2,2,2};
        //0,0,0,0,0,0,1
//        hashSolution(a);
//        for(int i=0;i<a.length;i++){
//            System.out.print(a[i].toString()+" ");
//        }
        System.out.println();

        sweepingSolution(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i].toString()+" ");
        }
    }
    static void hashSolution(Integer[] a){
        int i=0;
        int[] hash= new int[3];
        for(i=0;i<a.length;i++){
            hash[a[i]]++;
        }
        i=0;
        int count =hash[i];
        int value = i;
        for(Integer j=0;j<a.length;j++){
            a[j] = value;
            count--;
            if(count == 0&&i<hash.length-1){
                i++;
                //System.out.println(Integer.toString(i));
                count = hash[i];
                value = i;
            }
        }
    }
    private static void sweepingSolution(Integer[] a){
        int zeropointer=0,low=0, end=a.length-1;
        while(low<end){
            if(a[low] ==0) {swap(a,zeropointer,low);zeropointer++;low++;}
            if(a[low] == 1){low++;}
            if(a[low] == 2){ swap(a,low,end);end--;}
        }
    }
    private  static void swap(Integer[] arr, int i, int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
