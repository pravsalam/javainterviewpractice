/**
 * Created by praveenkumaralam on 1/17/16.
 */
public class AlibabaEscape {
    public static void main(String[] args){
        int[] strategy = {2,3,4,2,3,4,5};
        boolean[] fn = new boolean[strategy.length];
        for(int i=0;i<fn.length;i++)fn[i] = false;
        for(int i=1;i<strategy.length;i++){
            if(strategy[0] == i) fn[i] = true;
            else fn[i] =fn[i-1] || checkifcought(strategy, 1, i+1);
            System.out.println(i+" "+fn[i]);
        }
        for(int i=1;i<fn.length;i++){
            if(fn[i] == false) {System.out.println("strategy fails");return;}
        }
        System.out.println("strategy succeed");

    }
    private static boolean checkifcought(int[] strategy, int index, int pos){
        if(index < 0) return false;
        if(index >=strategy.length) return false;
        if(strategy[index] == pos) {
            //System.out.println(index);
            return true;
        }
        else return checkifcought(strategy, index+1, pos-1) ||
                checkifcought(strategy, index+1, pos+1);

    }
}
