/**
 * Created by praveenkumaralam on 11/7/15.
 */
public class LongestIncreasingSubseq {
    public static void main(String[] args){
        int[] a = {5,7,1,3,6,8,4,9,10,2,11,14,12,13};
        //[5,7,8,9,10,11,14] || [5,7,8,9,10,11,12,13]
        //[7,8,9,10,11,14] || [5,7,8,9,10,11,12,13]
        //[1,3,6,8,9,10,11,14] || [1,3,6,8,9,10,11,12,13] || [1,3,4,9,10,11,14| 13,12]
        //find longest increasing subsequence
        int len = a.length;
        int i;
        for(i=0;i<len;i++){
            //System.out.println(Integer.toString(a[i]));

        }
    }
}
