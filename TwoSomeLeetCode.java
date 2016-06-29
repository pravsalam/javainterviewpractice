import java.net.Inet4Address;
import java.util.HashMap;

/**
 * Created by praveenkumaralam on 8/1/15.
 */
public class TwoSomeLeetCode {
    static int[] sortedArray;

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        HashMap hash = new HashMap();
        int i, j;
        int[] output = new int[2];
        int arrayLength = nums.length;
        for (i = 0; i < arrayLength; i++) {
            hash.put(new Integer(nums[i]), new Integer(i));
        }
        for (i = 0; i < arrayLength; i++) {
            int reminder = target - nums[i];
            System.out.println(Integer.toString(reminder));
            if (hash.containsKey(new Integer(reminder))) {
                j =  (Integer)hash.get(new Integer(reminder));
                if(i !=j){
                    output[0] = i + 1;
                    output[1] = j + 1;
                    System.out.println("[ "+Integer.toString(output[0])+","+Integer.toString(output[1])+" ]");
                    return;
                }
            }
        }
        return;
    }
}
