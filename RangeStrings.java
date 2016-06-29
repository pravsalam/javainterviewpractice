import java.util.ArrayList;
import java.util.List;

/**
 * Created by praveenkumaralam on 8/11/15.
 */
public class RangeStrings {
    public static void main(String[] args){
        int[] nums = new int[]{0,1,2,4,5,7};
        List<String> resultList = new ArrayList<>();
        if(nums.length == 0) return;

        StringBuilder rangeStrBldr = new StringBuilder();
        int lowVal = nums[0];
        int expectedVal = lowVal;
        for(int val: nums){
            if( val == expectedVal){
                expectedVal ++;
            }
            else{
                // we got something new  add lowVal and expectedVal -1 to String Builder
                rangeStrBldr.append((new Integer(lowVal)).toString());
                if( expectedVal -1 != lowVal){
                    rangeStrBldr.append("->");
                    rangeStrBldr.append((new Integer(expectedVal - 1)).toString());
                }
                resultList.add(rangeStrBldr.toString());
                rangeStrBldr.delete(0, rangeStrBldr.length());
                lowVal = val;
                expectedVal = lowVal +1;
            }
        }
        rangeStrBldr.append((new Integer(lowVal)).toString());
        if( expectedVal -1 != lowVal){
            rangeStrBldr.append("->");
            rangeStrBldr.append((new Integer(expectedVal - 1)).toString());
        }
        resultList.add(rangeStrBldr.toString());
        System.out.print("[");
        for(String range:resultList){
            System.out.print(range+",");
        }
        System.out.println("]");
    }
}
