/**
 * Created by praveenkumaralam on 1/17/16.
 */
public class alibabaEscape2nd {
    public static void main(String[] args){
        int n=5;
        int[] strategy = {2,3,4,2,3,4,5};
        for(int i=1;i<=n;i++){
            if(!checkifaliwins(strategy,0,i,n)){
                System.out.println(" strategy fails "+i);
                return;
            }
        }
        System.out.println(" strategy succeed");
    }
    private static boolean checkifaliwins(int[] strategy,int index, int pos,int caves){

        if(pos <1) return false;
        if(pos > caves) return false;
        System.out.println(pos+" "+index);
        if(strategy[index] == pos) return true;
        else return checkifaliwins(strategy, index+1, pos-1, caves) || checkifaliwins(strategy, index+1, pos+1, caves);
    }
}
