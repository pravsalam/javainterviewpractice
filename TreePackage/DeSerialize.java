package TreePackage;

/**
 * Created by praveenkumaralam on 10/31/15.
 */
public class DeSerialize {
    public static void main(String[] args){
        int[] preorder = {5,6,4,13,12,9,7,2,14,1};
        int[] inorder = {13, 4,12,6,9,5,14,2,7,1};
        TreeNode root = buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
        printTree(root);
    }
    public static TreeNode buildTree(int[] inorder, int inBeg, int inEnd, int[] preorder, int preBeg, int preEnd){
        //first node in preorder is root
        if(inBeg > inEnd) return null;
        if(preBeg > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preBeg]);
        //divide the inorder all nodes left to root
        int rootLoc = findIndex(inorder,inBeg,inEnd, preorder[preBeg]);
        if(rootLoc < 0) return null;
        root.left  = buildTree(inorder, inBeg, rootLoc-1, preorder, preBeg+1, preBeg+rootLoc-inBeg);
        root.right = buildTree(inorder, rootLoc+1, inEnd, preorder, preBeg+rootLoc-inBeg+1,preEnd);
        return root;
    }
    private static int findIndex(int[] array,int start, int end,  int element){
        int len = array.length;
        for(int i=start;i<=end;i++){
            if(array[i] == element) return i;
        }
        return -1;
    }
    private  static void printTree(TreeNode root){
        if(root == null) return;
        System.out.print(Integer.toString(root.val)+" ");
        printTree(root.left);
        printTree(root.right);
    }
}
