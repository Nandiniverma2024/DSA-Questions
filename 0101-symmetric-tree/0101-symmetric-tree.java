/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return solve(root.left, root.right);
    }
    public boolean solve(TreeNode left, TreeNode right){
        // Base Case(left and right dono null pr puch gye search krte krte)
        if(left==null && right==null){ 
            return true;
        }
        if(left==null || right==null){  //invalid condition
            return false;
        }

        // Main kaam
        if(left.val!=right.val){
            return false;
        }
        // recursive call
        boolean leftSym=solve(left.left, right.right);
        boolean rightSym=solve(left.right, right.left);

        return leftSym && rightSym;
    }
}