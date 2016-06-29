package TraversalPackage;

import java.util.Stack;

/**
 * Created by praveenkumaralam on 12/20/15.
 */
public class Tree {
    public static void main(String[] args){
        int[] a = {1,8,9,3,4,6,7,5,2};
        TreeNode[] treeNodes = new TreeNode[a.length];
        for(int i=0;i<a.length;i++){
            treeNodes[i] = new TreeNode(a[i]);
            if(i==0)continue;

            if(i%2!=0){
                treeNodes[i/2].left = treeNodes[i];
            }
            else{
                treeNodes[i/2-1].right = treeNodes[i];
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(treeNodes[i].id+" ");
        }
        System.out.println();
        inorderRec(treeNodes[0]);
        System.out.println();
        preOrderRec(treeNodes[0]);
        System.out.println();
        postOrderRec(treeNodes[0]);
        System.out.println();
        inorderIterative(treeNodes[0]);
        System.out.println();
        preorderIterative(treeNodes[0]);
    }
    private static void inorderRec(TreeNode root){
        // traverse left, root, right
        if(root == null) return;
        ///if(root.left == null && root.right == null) {System.out.print(" "+Integer.toString(root.id));return;}
        inorderRec(root.left);
        System.out.print(" "+Integer.toString(root.id));
        inorderRec(root.right);
    }
    private static void preOrderRec(TreeNode root){
        if(root == null ) return;
        System.out.print(" "+Integer.toString(root.id));
        preOrderRec(root.left);
        preOrderRec(root.right);
    }
    private static void postOrderRec(TreeNode root){
        if(root == null) return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(" "+Integer.toString(root.id));
    }
    private static void inorderIterative(TreeNode root){
        System.out.println("In order recursive");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        //stack.push(temp);
        while(temp != null || !stack.isEmpty()){
            while(temp != null) {stack.push(temp); temp = temp.left;}
            temp= stack.pop();
            System.out.print(" "+temp.id);
            temp = temp.right;
        }

    }
    private static void preorderIterative(TreeNode root){
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(temp);
        while(temp != null && !stack.isEmpty() ){
            temp= stack.pop();
            System.out.print(" "+temp.id);
            if(temp.right != null)stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);

        }
    }
    private static void postorderIterative(TreeNode root){
        //incomplete
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp != null || !stack.isEmpty()){
            while(temp != null){

                stack.push(temp);
                stack.push(temp.right);
                temp = temp.left;
            }
        }
    }
}
