import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by praveenkumaralam on 8/6/15.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,1,2,0,5};
        int k = 3;
        Deque<Integer> someQue = new ArrayDeque<Integer>();
        int slidingWindowSize = 0;
        Integer currentMax=0;
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0;i< nums.length;i++){

            if(slidingWindowSize < k){
                if(nums[i] > currentMax){
                    currentMax = nums[i];
                    someQue.offerLast(currentMax);
                }
                slidingWindowSize ++;
                if(slidingWindowSize == k){
                    resultList.add(currentMax);
                }

            }
            else{
                int low = i -k;
                Integer temp = someQue.peekFirst();
                //one element added, one element removed
                if(temp !=null){
                    if(temp == nums[low]){
                        someQue.removeFirst();
                    }
                }
                if((currentMax = someQue.peekLast()) != null){
                    if(currentMax < nums[i]){
                        currentMax = nums[i];
                        someQue.offerLast(nums[i]);
                    }
                }else{
                    currentMax = nums[i];
                    someQue.offerLast(currentMax);
                }
                resultList.add(currentMax);
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for(Integer value: resultList){
            result[i] = value;
            i++;
        }
        for( int value: result){
            System.out.print(Integer.toString(value)+"  ");
        }
    }
}
