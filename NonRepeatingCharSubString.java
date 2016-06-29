import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by praveenkumaralam on 8/5/15.
 */
public class NonRepeatingCharSubString {
    public static void main(String[] args){
        String s = "vqblqcb";
        int curLowIndex=0;
        int curHighIndex = 0;
        int currentSubStringLength=0;
        int maxLowIndex =0;
        int maxHighIndex = 0;
        int maxSubStringLength =0;
        Set<Character> charHash = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!charHash.contains(s.charAt(i))){
                charHash.add(s.charAt(i));
                curHighIndex = i;

//                Iterator<Character> iterator = charHash.iterator();
//                while(iterator.hasNext()){
//                    System.out.print(iterator.next());
//                }
//                System.out.println(" ");
            }
            else{
                //System.out.println(" cur low "+Integer.toString(curLowIndex)+ " cur high "+Integer.toString(curHighIndex));

                for(int j=curLowIndex;j<i;j++ ){
                    //System.out.println(" i "+Integer.toString(i)+ " j "+Integer.toString(j));
                    //System.out.println("i "+s.charAt(i)+" j "+s.charAt(j));
                    if(s.charAt(i) == s.charAt(j)){
                        //System.out.println("inside check  i " + Integer.toString(i) + " j " + Integer.toString(j));
                        curLowIndex = j+1;
                        curHighIndex =i;
                        charHash.remove(s.charAt(j));
                        charHash.add(s.charAt(i));
//                        Iterator<Character> iterator = charHash.iterator();
//                        while(iterator.hasNext()) {
//                            System.out.print(iterator.next());
//                        }
                        break;
                    }
                    else{
                        charHash.remove(s.charAt(j));
                    }
                }
            }
            currentSubStringLength  = curHighIndex - curLowIndex +1;
            if(maxSubStringLength < currentSubStringLength){
                maxLowIndex = curLowIndex;
                maxHighIndex = curHighIndex;
                maxSubStringLength = maxHighIndex - maxLowIndex+1;
            }
        }
        System.out.println("min "+Integer.toString(maxLowIndex)+ " max "+Integer.toString(maxHighIndex)+ " "+Integer.toString(maxSubStringLength));
    }
}
