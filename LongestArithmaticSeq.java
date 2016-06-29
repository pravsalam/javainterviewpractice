import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by praveenkumaralam on 10/31/15.
 */
public class LongestArithmaticSeq {
    public static void main(String[] args){
        int[] a = {1,6,3,5,9,7};
        int i= 0;
        int j =0;
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<Integer, ArrayList<Integer>>();
        for(i=0;i<a.length-1;i++)
        {
            for(j=i+1;j<a.length;j++){
                int key = a[j]-a[i];
                if(key <0) continue;
                if(hash.containsKey(key)) {hash.get(key).add(a[i]); hash.get(key).add(a[j]);}
                else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(a[i]);
                    list.add(a[j]);
                    hash.put(key, list);
                }
            }
        }
        for(int key:hash.keySet()){
            System.out.println("Key "+ Integer.toString(key));
            ArrayList<Integer> list = hash.get(key);
            Iterator<Integer> iter = list.iterator();
            while(iter.hasNext()){
                int val= iter.next();
                System.out.print(Integer.toString(val)+" ");
            }
            System.out.println(" ");
        }
    }
}
