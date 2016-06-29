package TreePackage;

import apple.laf.JRSUIUtils;

/**
 * Created by praveenkumaralam on 8/25/15.
 */
public class TreeBuilder {
    private TreeNode root;
    private TreeNode[] nodeArray;
    TreeBuilder(int[] valArray){
        System.out.println(" Constructor executing");
        int length = valArray.length;
        nodeArray  = new TreeNode[length];
        int i =0;
        for(i=0;i<length;i++) {
            nodeArray[i] = new TreeNode(valArray[i]);
        }
        for(i =0;i<length;i++){
            if( (2*i+1) <length){
                if( nodeArray[2*i+1].val == -99999){
                    nodeArray[i].left = null;
                }
                else {
                    nodeArray[i].left = nodeArray[2 * i + 1];
                }
            }else{
                nodeArray[i].left = null;
            }
            if( (2*i+2) < length) {
                if( nodeArray[2*i+2].val == -99999){
                    nodeArray[i].right = null;
                }
                else {
                    nodeArray[i].right = nodeArray[2 * i + 2];
                }
            }else{
                nodeArray[i].right = null;
            }
        }
    }
    public TreeNode getRoot(){
        return nodeArray[0];
    }
}
