/**
 * Created by praveenkumaralam on 12/22/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //q.push(null);
        stack1.push(root);
        int level = 0;
        do {
            while (stack1.size() != 0) {
                TreeNode node = stack1.pop();
                if (level % 2 != 0) {
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }
            Stack<TreeNode> temp = stack1;
            stack1 = stack2;
            stack2 = stack1;
        } while (!stack1.isEmpty());
        return result;
    }
}
