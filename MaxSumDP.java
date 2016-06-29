import javax.sound.midi.SysexMessage;

/**
 * Created by praveenkumaralam on 12/15/15.
 */
public class MaxSumDP {
    public static void main(String[] args){
        Integer[] a = {-4,-5,-3,-4,-6,-7,-6,-5};
        Integer[] b = new Integer[a.length];
        for(Integer i=0;i<a.length;i++) b[i] = 0;
        b[b.length-1] = a[a.length-1];
        Integer max = getMax(a,a.length-2,b,0);
        System.out.println("Max "+max.toString());
    }
    static int getMax(Integer[] a,Integer index, Integer[] dp,Integer maximum ){
        if(a == null)return 0;
        if(a.length == 0) return 0;
        if(index <0) return 0;
        if(dp == null) {
            System.out.println(" dp is null");
            return 0;
        }
        //Integer max = dp[index+1];
        Integer prev = dp[index+1];
        Integer curSum = max(prev+a[index], a[index]);
        System.out.println("i "+ index.toString()+" curSum "+curSum.toString());
        dp[index] = curSum;
        maximum = max(curSum, maximum);
        System.out.println(" Maximum "+maximum.toString());
        if(index == 0) return maximum;
        return getMax(a,index-1, dp,maximum);
    }
    static Integer max(Integer a, Integer b){
        if(a>b) return a;
        else return b;
    }
}
