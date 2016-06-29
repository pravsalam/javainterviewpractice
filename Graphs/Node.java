package Graphs;

/**
 * Created by praveenkumaralam on 10/29/15.
 */
public class Node<T> {
    T  id;
    int weight;
    public Node(T nodeid){
        id = nodeid;
        weight=1;
    }
    public Node(T nodeid, int nodeWeight){
        id = nodeid;
        weight = nodeWeight;
    }
    public T getId(){
        return id;
    }
    public int getWeight(){
        return weight;
    }
}
