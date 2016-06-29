package DynamicProgramming;

/**
 * Created by praveenkumaralam on 11/12/15.
 */
public class LongestIncreasingSubSeq {
    public static void main(String[] args){
        int[] a = {4,9,10,15,3,1,2,5,7,6,11,13,12};
        //1,2,5,7,11,12
        //find longest increasing subsequence
        //go from left to right and find ask the right for liss
        //4,9,10,15| 4,5,7,11,12
        int i=0,j=0;
        int len = a.length;
        int endpos=0;
        int[] liss = new int[len];
        int max = 0;
        //for(i=0;i<len;i++){
            liss[i] = 1+calculateliss(1,a[0], a,liss);//0, 4, a
        //}
        for(i=0;i<a.length;i++){
            System.out.print(Integer.toString(liss[i])+" ");
        }
    }
    private static int calculateliss(int i, int base, int[] a,int[] liss){
        if(i>a.length-1) return 0;
        int notincluded = calculateliss(i+1, base, a,liss);
        int included = 0;
        if( liss[i] ==0) {
            System.out.println(" calculating for i = "+Integer.toString(i));
            liss[i] =included = 1+ calculateliss(i+1, a[i],a,liss);
        }
        else  included = liss[i];
        if(a[i] > base){
            if(notincluded > included) return notincluded;
            else return included;
        }
        else return notincluded;
    }

}
