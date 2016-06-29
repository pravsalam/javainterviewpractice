/**
 * Created by praveenkumaralam on 10/16/15.
 */
public class kthInBST {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public static void main(String[] args){

        TreeNode head = null;
        int kth = 5;
        if(head == null) return;
        findKthNode(head, kth);

    }
    private static int countNodes(TreeNode head){
        if(head == null)return 0;
        else return 1+ countNodes(head.left) + countNodes(head.right);
    }
    private static int findKthNode(TreeNode head,int kth){
        if( head == null) throw new IllegalArgumentException();
        int leftCount = countNodes(head.left);
        int currentCount = leftCount+1;
        if(currentCount == kth) return head.val;
        if(currentCount > kth) //search on left
        {
            return findKthNode(head.left, kth );
        }else{
            return findKthNode(head.right, kth - currentCount);
        }
    }
}
