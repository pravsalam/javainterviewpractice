package Graphs;

import sun.awt.image.ImageWatched;
import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by praveenkumaralam on 10/29/15.
 */
public class Graph<T> {
    //adjacensy list
    private HashMap<Node, LinkedList<Edge>> adjList;
    public Graph(){
        //System.out.println("Constructor called");
        adjList = new HashMap<Node, LinkedList<Edge>>();
    }
    public void add(Node v){
        if(v != null){
            LinkedList<Edge> emptyList = new LinkedList<Edge>();
            adjList.put(v, emptyList);
        }
    }
    public void add(Node v, LinkedList<Edge> edgeList){
        adjList.put(v, edgeList);
    }
    public void add(Node s, Node d){
        if(adjList.containsKey(s)){
            LinkedList<Edge> list = adjList.get(s);
            list.addLast(new Edge(d));
        }
        else{
            LinkedList<Edge> list = new LinkedList<Edge>();
            list.add(new Edge(d));
            add(s, list);
        }
    }
    public void add(Node s, Node d, int weight){
        if(adjList.containsKey(s)){
            LinkedList<Edge> list = adjList.get(s);
            list.addLast(new Edge(d,weight));
        }
        else{
            LinkedList<Edge> list = new LinkedList<Edge>();
            list.add(new Edge(d,weight));
            add(s, list);
        }
    }
    public void add(T sourceId, T DestId){
        for(Node node: adjList.keySet()){
            if(sourceId.equals(node.getId())){
                //System.out.println("Found sourceid "+sourceId );
                LinkedList<Edge> list = adjList.get(node); if(list == null){System.out.println("Illegal");}
                list.add(new Edge(new Node(DestId)));
                return;
            }
        }
        // couldn't find any node
        Node newNode = new Node(sourceId);
        LinkedList<Edge> list = new LinkedList<Edge>();
        list.add(new Edge(new Node(DestId)));
        add(newNode, list);
    }
    public void printGraph(){

        for(Node n: adjList.keySet()){
            //System.out.println(" new list");
            LinkedList<Edge> list = adjList.get(n);
            Iterator<Edge> iter = list.iterator();
            while(iter.hasNext()){
                Edge e = iter.next();
                //System.out.println("Source "+n.getId().toString()+" Dest "+e.getNode().getId().toString());
            }

        }
    }
    public LinkedList<Edge> getAdjacentList(Node node){
        if(adjList.containsKey(node)){
            return adjList.get(node);
        }
        else{
            return null;
        }
    }
    public LinkedList<Edge> getAdjacentList(T nodeid){
        for(Node n: adjList.keySet()){
            //System.out.println(n.getId().toString()+" "+nodeid.toString());
            if(n.getId().equals(nodeid)){
                return adjList.get(n);
            }
        }
        return null;
    }
    public Node getNode(T nodeid){
        for(Node n: adjList.keySet()){
            if(n.getId().equals(nodeid)){
                return n;
            }
        }
        return null;
    }

}
