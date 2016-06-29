package TreePackage;

/**
 * Created by praveenkumaralam on 8/26/15.
 */
public class TreeTest {
    public static void main(String[] args){
        int[] valArray = new int[]{5,4,8,11,-99999,13,4,7,2,-99999,-99999,-99999,1};
        TreeBuilder tree = new TreeBuilder(valArray);
        TreeNode root = tree.getRoot();
        System.out.println(" Root node "+ (new Integer(root.val)).toString());
        System.out.println(" On its left "+ (new Integer(root.left.val)).toString());
        System.out.println(" On its right "+ (new Integer(root.right.val)).toString());
        System.out.println(" On its left "+ (new Integer(root.left.right.val)).toString());
    }
}
