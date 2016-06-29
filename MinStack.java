import java.util.ArrayList;

/**
 * Created by praveenkumaralam on 8/9/15.
 */
public class MinStack {

    final int MAX_CAP = 10;
    private int[] internalMemory = new int[MAX_CAP];
    private int top = -1;
    private int[] internalStackMem = new int[MAX_CAP];
    private int internalStackTop = -1;
    int currentMin = 0;
    boolean firstPush = true;
    public static void main(String[] args){
        MinStack obj = new MinStack();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        resultList.add(obj.top());
        //obj.push(2147483647);
        obj.pop();
        resultList.add(obj.getMin());
        obj.pop();
        resultList.add(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        resultList.add(obj.top());
        resultList.add(obj.getMin());
        obj.push(-2147483648);
        resultList.add(obj.top());
        //obj.pop();
        resultList.add(obj.getMin());
        obj.pop();
        resultList.add(obj.getMin());
        System.out.print("[");
        for(Integer value: resultList){
            System.out.print(value.toString()+",");
        }
        System.out.print("]");
        //System.out.print("on top "+ (new Integer(obj.top())).toString()+ " min "+(new Integer(obj.getMin()).toString()));
    }
    public void push(int x){
        top++;
        internalMemory[top] = x;
        if(firstPush){
            currentMin = x;
            internalStackTop++;
            internalStackMem[internalStackTop] = currentMin;
            firstPush = false;
        }
        else if(currentMin >= x){
            currentMin = x;
            internalStackTop++;
            internalStackMem[internalStackTop] = currentMin;
        }
        return;
    }
    public int pop(){
        if(internalMemory[top] == internalStackMem[internalStackTop]){
            internalStackTop --;
            if(internalStackTop < 0){
                firstPush = true;
            }
        }
        int returnValue = internalMemory[top];
        top --;
        return returnValue;
    }
    public int top(){
        return internalMemory[top];
    }
    public int getMin(){
        if(internalStackTop >= 0) {
            return internalStackMem[internalStackTop];
        }
        else{
            return 0;
        }
    }
}
