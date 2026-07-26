import javax.swing.tree.TreeNode;



public class searchinBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return null;
        }
        if (val < root.val){
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }

    }
}
