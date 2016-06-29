import java.util.ArrayList;

/**
 * Created by praveenkumaralam on 10/30/15.
 */
public class NumberToString {
    public static void main(String[] args){
        int n = 12224;
        //recursion is bad solution.
        int digits = numberOfDigits(n);
        int[]  a = new int[digits];
        int[] scount = new int[digits];
        for(int i=(digits-1);i>=0;i--){
            a[i] = n%10;
            n = n/10;
        }
        for(int i=(digits-1);i>=0;i--){
            if(i == (digits -1)){
                //last digit
                scount[i] =1;
            }
            else{
                int curNumber= a[i];
                int nextNum = curNumber*10+a[i+1];
                int inc = 0;
                System.out.println( " next number "+Integer.toString(nextNum));
                scount[i] =inc+scount[i+1];
                if(nextNum <26){
                    if(i<digits-2){
                        scount[i] = 2+scount[i+2];
                    }
                    else
                        scount[i] = 1+scount[i+1];
                }

            }
        }
        for(int i=0;i<digits;i++){
            System.out.println(Integer.toString(scount[i]));
        }
    }
    private static int numberOfDigits(int n){
        int i=0;
        while(n !=0){
            i++;
            n = n/10;
        }
        return i;
    }
}
