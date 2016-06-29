import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by praveenkumaralam on 12/13/15.
 */
public class SortbyMSB {
    public static void main(String[] args){
        Integer[] a = {0,01};
        Arrays.sort(a, new myComparator());
        for(Integer i:a){
            System.out.print(i.toString());
        }
    }
}

class myComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String string1 = o1.toString()+o2.toString();
        String string2 = o2.toString()+o1.toString();
        return string2.compareTo(string1);
    }
}