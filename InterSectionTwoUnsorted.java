import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by praveenkumaralam on 12/28/15.
 */
public class InterSectionTwoUnsorted {
    public static void main(String[] args){
        int[] arr1 = {5,9,8,3,1,6,7,2};
        int[] arr2 = {10,7,3,1,5,4,11,12};
        ArrayList<Integer> arrayList  = new ArrayList<Integer>();
        HashSet<Integer> hashSet = new HashSet<>(arr1.length);
        for(int i =0;i<arr1.length;i++){
            hashSet.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(hashSet.contains(arr2[i])){
                arrayList.add(arr2[i]);
            }
        }
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
    }
}
