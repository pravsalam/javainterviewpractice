package TreePackage;

import java.util.Stack;

/**
 * Created by praveenkumaralam on 8/27/15.
 */
public class FindNode {
    public static void main(String[] args){
        int[] valueArray = new int[]{1,2};
        TreeBuilder tree = new TreeBuilder(valueArray);
        TreeNode root = tree.getRoot();
        TreeNode temp = root.left;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            //System.out.println(" Node "+ (new Integer(temp.val)).toString());
            TreeNode oldTemp = null;
            while(temp.right == null || oldTemp == temp.right) {
                oldTemp = stack.pop();
                System.out.println(" Node "+ (new Integer(oldTemp.val)).toString());
                if( stack.empty()) return;
                temp = stack.peek();
            }
            temp = temp.right;
        }
    }
}
