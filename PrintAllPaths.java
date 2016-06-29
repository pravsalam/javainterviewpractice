import org.apache.commons.collections.iterators.ArrayListIterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by praveenkumaralam on 10/6/15.
 */
public class PrintAllPaths {
    public static void main(String[] args){
        int startx = 0, starty = 0;
        int endx = 4, endy = 5;
        //print string HV to reach endx, endy
        List<String> stringList = giveAllPaths(startx,starty,endx,endy);
        Iterator<String> iter = stringList.iterator();
        while(iter.hasNext()){
            String path = iter.next();
            System.out.println(path);
        }
    }
    private static ArrayList<String> giveAllPaths(int startx, int starty, int endx, int endy){
        if(startx == endx && starty == endy){
            ArrayList<String> emptyList = new ArrayList<String>();
            return emptyList;
        }
        ArrayList<String> currentSteps = new ArrayList<String>();
        if((startx+1 )<= endx){
            //take a horizontal step
            ArrayList<String> furtherSteps = giveAllPaths(startx+1, starty, endx,endy);
            Iterator<String> iterator = furtherSteps.iterator();
            while(iterator.hasNext()){
                String path = iterator.next();
                path +="H";
                currentSteps.add(path);
            }
            if(furtherSteps.size() == 0){
                currentSteps.add("H");
            }
        }
        if((starty+1) <= endy){
            ArrayList<String> furtherSteps = giveAllPaths(startx, starty+1, endx,endy);
            Iterator<String> iterator = furtherSteps.iterator();
            while(iterator.hasNext()){
                String path = iterator.next();
                path +="V";
                currentSteps.add(path);
            }
            if(furtherSteps.size() == 0){
                currentSteps.add("V");
            }
        }
        return currentSteps;
    }
}
