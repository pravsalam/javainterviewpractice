package TreePackage;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by praveenkumaralam on 8/26/15.
 */
public class SumToLeaf {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root.left;
        stack.push(root);
        int branchSum =root.val;
        int tempSum =0;
        while(!stack.empty() || temp!=null){
            while(temp != null){
                branchSum += temp.val;
                //System.out.println(" branchsum "+ (new Integer(branchSum)).toString());
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            tempSum +=temp.val;
            System.out.println(" Node "+(new Integer(temp.val)).toString() +" branchSUm "+(new Integer(branchSum)).toString());
            if((branchSum == sum) && (temp.right == null) && (temp.left == null)) return true;
            TreeNode oldTemp = temp;
            temp = temp.right;
            if(temp == null){
                System.out.println(" Nothing on the right");
                branchSum -= tempSum;
                tempSum = 0;
            }
            else{
                System.out.println(" What is next on right "+(new Integer(temp.val)).toString());
            }
        }
        return false;
    }
    public static void main(String[] args){
                                //  {0,1,2,3,   4,   5, 6,7,8,    -9,   -10, -11,  12};
        int[] valueArray = new int[]{5,4,8,11,-99999,13,4,7,2,-99999,-99999,-99999,1};
        TreeBuilder tree = new TreeBuilder(valueArray);
        TreeNode root = tree.getRoot();
        if(hasPathSum(root, 18)){
            System.out.println(" Path exist from root to leaf with sum");
        }
        else{
            System.out.println(" Path does not exist");
        }
    }
}
