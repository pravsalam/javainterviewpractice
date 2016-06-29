import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by praveenkumaralam on 12/23/15.
 */
public class Mnenomonic {
    //2     3    4       5     6     7      8     9
    static String[] arr ={"abc","def","ghi", "jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String args[]){

        int n = 234;
        mnemonic(Integer.toString(n),"");
        System.out.println("----------------------------------------");
        LinkedList<String> result = new LinkedList<String>();
        int d = n%10;
        n = n/10;
        for(char c: arr[d-2].toCharArray()){
            result.add((new Character(c)).toString());
        }
        while(n !=0){
            d  = n%10;
            n = n/10;
            if(d == 0 || d== 1) continue;
            LinkedList<String> secondary = new LinkedList<>();
            while(!result.isEmpty()){
                //take a string and
                String s = result.remove();
                String fromphone = arr[d-2];
                for(char c:fromphone.toCharArray()){
                    String newString = c+s;
                    secondary.add(newString);
                }
            }
            result = secondary;
        }
        Iterator<String> iter = result.iterator();
        while(iter.hasNext()){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void mnemonic(String number, String answer) {
        if (number.length() == 0) {
            System.out.println(answer);
        } else {
            int index = number.charAt(0)-48;
            for (char c:arr[index-2].toCharArray()) {
                mnemonic(number.substring(1), answer+c);
            }
        }
    }
}
