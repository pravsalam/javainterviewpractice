import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by praveenkumaralam on 10/21/15.
 */
public class OnetoManyStrings {
    public static void main(String[] args){
        String s= "0101???1011?11?0";
        StringBuffer sbuff = new StringBuffer(s);
        //generate all combinations of s
        List<StringBuffer> res = solveString(sbuff, 0);
        Iterator<StringBuffer> iter = res.iterator();
        while(iter.hasNext()){
            System.out.println("String is" +iter.next().toString());
        }

    }
    private static List<StringBuffer> solveString(StringBuffer input, int pos){
        System.out.println(" Entered solveString "+ input.toString()+" pos "+Integer.toString(pos));
        int i=pos;
        List<StringBuffer> result = new ArrayList<StringBuffer>();
        while(i < input.length() && input.charAt(i) != '?') i++;
        System.out.println("i ="+ Integer.toString(i));
        if(i == input.length()) {
            result.add(input);
            return result;

        }
        //we found ?

        if(input.charAt(i) == '?'){
            StringBuffer firstBuff = new StringBuffer(input);
            StringBuffer secondBuff = new StringBuffer(input);
            firstBuff.setCharAt(i,'1');
            result.addAll(solveString(firstBuff, i+1));
            secondBuff.setCharAt(i, '0');
            result.addAll(solveString(secondBuff, i+1));
        }
        System.out.println(" Inside solve string");
        Iterator<StringBuffer> iter = result.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        System.out.println("Leaving solve String");
        return result;
    }

}
