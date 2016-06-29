/**
 * Created by praveenkumaralam on 10/6/15.
 */
public class LongestSumPalindrome {
    public static void  main(String[] args){
        String input= "3452";
        int length = input.length();
        int maxSize = 0;
        int i=0;
        for(i=0;i<length;i++){
            int maxlen = min(i, length-i);
            System.out.println(" Pos ="+Integer.toString(i)+ " maxlen = "+Integer.toString(maxlen));
            while(maxlen >0){
                if(isSumPalindrome(input,i, maxlen)){
                    if(maxlen > maxSize)    maxSize= maxlen;
                }
                maxlen--;
            }
        }
        System.out.println("Maxsize "+ Integer.toString(maxSize));
    }
    private static int min(int a, int b){
        if(a<b) return a;
        else return b;
    }
    private static boolean isSumPalindrome(String s, int pos, int len){
        System.out.println("iSSum Palindrom Entered");
        int i;
        int sumLeft = 0;
        int sumRight = 0;
        int leftind = len;
        int rightInd = len-1;
        while(leftind>0){
            sumLeft += Character.getNumericValue(s.charAt(pos-leftind));
            leftind--;
        }
        while(rightInd >=0){
            sumRight += Character.getNumericValue(s.charAt(pos+rightInd));
            rightInd--;
        }
        System.out.println("IsSumPalindrome Leaving leftSum "+Integer.toString(sumLeft)+" rightSum ="+Integer.toString(sumRight));
        if(sumLeft == sumRight) return true;
        return false;
    }
}
