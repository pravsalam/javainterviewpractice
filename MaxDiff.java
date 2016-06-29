/**
 * Created by praveenkumaralam on 12/17/15.
 */
public class MaxDiff {
    public static void main(String[] args){
        Integer[] a = {19,18,17,16,15,14,13,12,11,10};
        Integer min=a[0];
        Integer max = a[0];
        for(Integer e:a){
            if(e > max) max = e;
            if(e <min) min = e;
        }
        System.out.println(" Max = "+max.toString()+" min = "+min.toString());
    }
}
