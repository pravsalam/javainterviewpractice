import com.sun.javafx.geom.AreaOp;

import java.net.Inet4Address;

/**
 * Created by praveenkumaralam on 10/20/15.
 */
public class MultiplyStrings {
    public static void main(String[] args){
        String num1= "91";
        String num2 = "91";
        int len1 = num1.length();
        int len2 = num2.length();
        String multiplied = num1;
        String multiplier = num2;
        int minlen=0;
        if(len1 <len2){
            minlen = len1;
             multiplied = num2;
             multiplier = num1;
        }
        else{
            minlen = len2;
             multiplied = num1;
             multiplier = num2;
        }
        int i;
        String prev="";
        String zeroes = "";
        for(i=minlen-1;i>=0;i--){
            //122*12
            System.out.println("multipleid = "+multiplied+" number = "+multiplier.charAt(i));
            String cur = multiplyNumbers(multiplied,Character.digit(multiplier.charAt(i),10));
            System.out.println(" cur "+Integer.toString(i)+" "+cur);
            cur+=zeroes;
            zeroes +="0";
            prev =addStrings(cur, prev);
        }
        if(!isAllZeros(prev))
            System.out.println(prev);
        else
            System.out.println("0");
        //System.out.println(prev);



    }
    private static String multiplyNumbers(String num1, int n){
        int len = num1.length();
        String result="";
        int carryon=0;
        int prod=0;
        int i=len-1;
        for(i=len-1;i>=0;i--){
            int intval = Character.digit(num1.charAt(i),10);
            //251*2 403     152 *2  = 304
            prod = (intval*n+carryon)%10;
            result +=Integer.toString(prod);
            carryon = (intval*n+carryon)/10;
        }
        if(carryon !=0){
            result +=Integer.toString(carryon);
        }
        return reverseString(result);
    }
    private static String reverseString(String input){
        char[] a = input.toCharArray();
        int i=0;
        int j = input.length()-1;
        while(i<j){
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return new String(a);
    }
    private static String addStrings(String s1, String s2){
        if(s1 == "") return s2;
        if(s2 =="") return s1;
        System.out.println(" S1 "+s1+" s2 "+s2);
        int len1 = s1.length();
        int len2 = s2.length();
        int maxlen = len1;
        if(maxlen <len2)maxlen = len2;
        int i=len1-1,j=len2-1;
        int carryon=0;
        String res="";
        while(i >=0 && j >=0){
            int n1 = Character.digit(s1.charAt(i),10);
            int n2 = Character.digit(s2.charAt(j),10);
            int sum = (n1+n2+carryon)%10;
            carryon = (n1+n2+carryon)/10;
            res +=Integer.toString(sum);
            i--;
            j--;
        }
        while(i>=0){
            int n1 = Character.digit(s1.charAt(i),10);
            int sum = (n1+carryon)%10;
            carryon  = (n1+carryon)/10;
            res += Integer.toString(sum);
            i--;
        }
        while(j>=0){
            int n2 = Character.digit(s2.charAt(j),10);
            int sum = (n2+carryon)%10;
            carryon  = (n2+carryon)/10;
            res += Integer.toString(sum);
            j--;
        }
//        if(carryon !=0){
//            res +=Integer.toString(carryon);
//        }
        System.out.println("Fake sum "+res);
        return reverseString(res);
    }
    private static boolean isAllZeros(String input){
        for(Character c: input.toCharArray()){
            if(c != '0')return false;
        }
        return true;
    }
}
