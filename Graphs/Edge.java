package Graphs;

/**
 * Created by praveenkumaralam on 10/29/15.
 */
public class Edge {
    Node node;
    int weight;
    public Edge(Node connectedNode){
        node = connectedNode;
        weight = 1;
    }
    public Edge(Node connectedNode, int edgeWeight){
        node = connectedNode;
        weight = edgeWeight;
    }
    Node getNode(){
        return node;
    }
    int getWeight(){
        return weight;
    }
    void setWeight(int edgeWeight)
    {
        weight = edgeWeight;
    }
    void setNode(Node connectedNode){
        node = connectedNode;
    }
}
