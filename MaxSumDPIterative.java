/**
 * Created by praveenkumaralam on 12/16/15.
 */
public class MaxSumDPIterative {
    public static void main(String[] args){
        Integer[] a = {-4,-5,-3,4,-6,7,-6,-5};
        Integer i = a.length-1;
        Integer prev = a[i];
        Integer max = 0;
        while(i-->0){
            prev = max(prev+a[i],a[i]);
            max = max(prev,max);
        }
        System.out.println(max.toString());
    }
    private static int max(Integer a, Integer b){
        if(a>b)return a;
        else return b;
    }
}
