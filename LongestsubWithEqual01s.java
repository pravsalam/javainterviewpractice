import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by praveenkumaralam on 12/25/15.
 */
public class LongestsubWithEqual01s {

    public static void main(String[] args){
                // 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21
        int[] a = {1,0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1};
        //         1,0,-1,-2,-3,-2, -1,0,-1,-2,-1, -2,-1
        int count =0;
        int max = 0;
        HashMap<Integer,CustomTuple> hash = new HashMap<Integer, CustomTuple>();
        for(int i=0;i<a.length;i++){
            if(a[i] == 0) count--;
            else if(a[i] == 1) count++;
            if(hash.containsKey(count)){
                CustomTuple ctp = hash.get(count);
                ctp.max = i;
            }
            else{
                CustomTuple ctp = new CustomTuple(i,i);
                hash.put(count, ctp);
            }
        }
        for(int key:hash.keySet()){
            CustomTuple ctp = hash.get(key);
            if( max < (ctp.max - ctp.min)) max = ctp.max - ctp.min;
        }
        System.out.println(max);
    }

}
class CustomTuple{
    public int min=0;
    public int max=0;
    public CustomTuple(int a, int b){
        min = a;
        max = b;
    }
}
