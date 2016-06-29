/**
 * Created by praveenkumaralam on 10/21/15.
 */
public class NoCharRepeats {
    public static void main(String[] args){
        String s = "aaaabcdddd";
        //adadadadbc
        //aaabbccdd
        //aababccdd
        //ababcdcd
        //result should be abcdabcd
        StringBuffer sbuff = new StringBuffer(s);
        int len = sbuff.length();
        int i;
        int j;
        i=0;j=0;
        while(i<len-1&& j<len){
            while(j<len-1 && sbuff.charAt(j) == sbuff.charAt(i)) j++;
            //if(j == len )return;
            if(sbuff.charAt(i) ==sbuff.charAt(i+1)){
                char temp = sbuff.charAt(i+1);
                sbuff.setCharAt(i+1,sbuff.charAt(j));
                sbuff.setCharAt(j, temp);
            }
            System.out.println("i = "+Integer.toString(i)+" j ="+Integer.toString(j));
            i++;
        }
        System.out.println(sbuff.toString());
    }
}
