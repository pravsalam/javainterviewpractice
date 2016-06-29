import com.sun.tools.javac.util.Pair;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by praveenkumaralam on 1/3/16.
 *     2  3 4
 *        1
 *        0
 *        5
 *
 *       0 1 2 3 4 5
 *    0  0 1 0 0 0 1
 *    1  1 0 1 1 1 0
 *    2  0 1 0 0 0 0
 *    3  0 1 0 0 0 0
 *    4  0 1 0 0 0 0
 *    5  1 0 0 0 0 1
 *
 */
public class MaxTree {

    public static void main(String[] args){
        int n = 6;
        int[][] a = {{0,1,0,0,0,1},
                     {1,0,1,1,1,0},
                     {0,1,0,0,0,0},
                     {0,1,0,0,0,0},
                     {0,1,0,0,0,0},
                     {1,0,0,0,0,0}};

        List<Integer> result = new ArrayList<Integer>();
        int shortestDist = n;
        for(int i =0;i<n;i++){

            int maxDist = n;
            maxDist = n;
            LinkedList<Cpair> pq = new LinkedList<Cpair>();
            HashSet<Integer> visited = new HashSet<Integer>(n);
            pq.add(new Cpair(i, 0));
            //visited.add(i);
            while(!pq.isEmpty()){
               //take out element and
                Cpair tuple = pq.removeFirst();
                int node = tuple.fst;
                if(!visited.contains(node)){
                    visited.add(node);
                    for(int j =0;j<n;j++){
                        if(a[node][j] == 1){

                            int curDist = tuple.snd;
                            System.out.println(i+" "+j+" "+curDist);
                            pq.add(new Cpair(j, curDist+1));
                            maxDist = curDist;
                        }
                    }
                }
            }
            System.out.println(" node "+i+" distance "+maxDist+ " "+shortestDist);
            if(shortestDist > maxDist){
                shortestDist = maxDist;
                result = new ArrayList<Integer>();
                result.add(i);
            }
            else if(shortestDist == maxDist)
                result.add(i);
        }
        System.out.println(" result");
        Iterator iter = result.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
    }

}
class Cpair{
    int fst;
    int snd;
    public Cpair(int a, int b){
        fst = a;
        snd = b;
    }
}
