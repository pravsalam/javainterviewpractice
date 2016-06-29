package Graphs;

import java.util.*;

/**
 * Created by praveenkumaralam on 10/29/15.
 */
public class TestGraph {
    public static void main(String[] args){
        Graph<String> G = new Graph<String>();
        ArrayList<String> dictionary = new ArrayList<String>(10);
        dictionary.add("cat");
        dictionary.add("cot");
        dictionary.add("cog");
        dictionary.add("dog");
        String begin = "cat";
        String end = "dog";
//        G.add("cat","cot");
//        G.add("cat","cog");
//        G.add("cog","dog");

        Iterator<String> iter = dictionary.iterator();
        while(iter.hasNext()){
            String str1 = iter.next();
            Iterator<String> iter2 = dictionary.iterator();
            while(iter2.hasNext()){
                String str2 = iter2.next();
                if(diffByOneChar(str1,str2)){
                    //System.out.println(" Source = "+str1+ " Dest = "+str2);
                    G.add(str1, str2);
                }
            }
        }
        G.printGraph();
        //check if path exist from begin to end
        if(pathExists(G, begin, end)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
    private static boolean diffByOneChar(String s1, String s2){
        int charDiff = 0;
        if(s1.length() != s2.length()) return false;
        int length = s1.length();
        int i=0;
        for(i=0;i<length;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                charDiff++;
            }
        }
        if(charDiff == 1) return true;
        else return false;
    }
    private static boolean pathExists(Graph<String> G, String begin, String end){
        if(begin.equals(end)) return true;
        Node node = G.getNode(begin);
        if(node == null) return false;
        LinkedList<Node> queue = new LinkedList<Node>();
        ArrayList<String> visited = new ArrayList<String>();
        queue.addLast(node);
        while(!queue.isEmpty()){
            Node n = queue.removeFirst();
            System.out.println(" Source " + n.getId().toString());
            //System.out.println(n.getId().toString());
            if(visited.contains(n.getId().toString())) continue;
            LinkedList<Edge> list = G.getAdjacentList(n.getId().toString());
            if(list == null) {System.out.println(" list null");continue;}
            Iterator<Edge> iter = list.iterator();
            System.out.println(" List size "+ Integer.toString(list.size()));
            if(iter == null) continue;
            while(iter.hasNext()){
                Edge e = iter.next();
                System.out.println("                  Dests "+e.getNode().getId().toString());
                if(e.getNode().getId().equals(end)){
                    return true;
                }
                else{
                    //add it to the queue
                    visited.add(n.getId().toString());
                    if(!visited.contains(e.getNode().getId().toString()))
                        queue.addLast(e.getNode());
                }
            }
        }
        return false;
    }

}
