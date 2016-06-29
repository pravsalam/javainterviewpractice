/**
 * Created by praveenkumaralam on 10/21/15.
 */
import java.io.*;
import java.util.*;

public class ShortestPathInGraphWithTwist {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
/*        3 3
        1 2 3 a
        2 3 4 b
        1 3 5 c
        aabb*/
        int m=3;int n = 3;
        edgeInfo[][] adj = new edgeInfo[m][m];
        int i,j;
        for(i=0;i<m;i++){
            for(j=0;j<m;j++){
                //adj[i][j] = new edgeInfo(-1,'');
            }
        }
        adj[0][1].edgeWeight =3;
        adj[0][1].edgeLabel = 'a';
        adj[1][2].edgeWeight =4;
        adj[1][2].edgeLabel = 'b';
        adj[0][2].edgeWeight =5;
        adj[0][2].edgeLabel = 'c';


        //shortest path, try the normal.
        //start with 1 i.e 0 index 0 1,3
        PriorityQueue pqueue = new PriorityQueue(10,new distComparator());
        HashMap<Integer, Integer> visited =new HashMap<Integer,Integer>();
        //for all nodes initialize the distances from 0.
        DistInfo[] distInfos = new DistInfo[m];
        for(i=0;i<m;i++){
           // if(i==0) distInfos[i] = new DistInfo(i,0);
        }


    }
    private class edgeInfo{
        public int edgeWeight;
        public char edgeLabel;
        public edgeInfo(int ew, char el){
            edgeWeight = ew;
            edgeLabel = el;
        }
        public void setEdgeWeight(int ew){
            edgeWeight = ew;
        }
        public void setEdgeLabel(char c){
            edgeLabel = c;
        }
    }
    private class DistInfo{
        public int node;
        public int distance;
        public DistInfo(int m, int dist){
            node = m;
            distance = dist;
        }
    }
    private static class distComparator implements Comparator<DistInfo> {

        @Override
        public int compare(DistInfo o1, DistInfo o2) {
            if(o1.distance < o2.distance) return 1;
            if(o1.distance > o2.distance) return -1;
            return 0;
        }
    }
}
