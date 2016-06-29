/**
 * Created by praveenkumaralam on 12/27/15.
 */
public class DynamicProgramming {
    public static void main(String[] args){
        int length = 8;
        int[] piecesizes =  {0,1,2,3,4,5, 6, 7, 8};
        int[] pieceprices = {0,3,5,8,9,10,17,17,20};
        int profit = profitableCutting(length, piecesizes, pieceprices);
        System.out.println(profit);

    }
    private static int profitableCutting(int length, int[] pieces, int[] prices){
        int[] b = new int[length+1];
        b[0] =0;
        for(int i=1;i<=length;i++){
            if(i<prices.length){
                b[i] = prices[i];
            }
            else{
                b[i] = 0;
            }
            System.out.println("before price "+i+" "+b[i]);
            for(int j=i;j>0;j--){
                b[i] = max(b[i],b[j]+b[i-j]);
            }
            System.out.println("after price "+b[i]);
        }
        return b[length];
    }
    private static int max(int a, int b){
        return a>b?a:b;
    }
}
