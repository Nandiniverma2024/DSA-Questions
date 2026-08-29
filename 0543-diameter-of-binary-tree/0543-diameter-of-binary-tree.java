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
    public int diameterOfBinaryTree(TreeNode root) {
        // Base Condition
        if(root==null){
            return 0;
        }
        // work
        int lh=height(root.left);
        int rh=height(root.right);
        int currDia=lh+rh;

        // Recursive Call
        int leftDia=diameterOfBinaryTree(root.left);
        int rightDia=diameterOfBinaryTree(root.right);

        int maxLeftRightDia=Math.max(leftDia, rightDia);

        return Math.max(currDia, maxLeftRightDia);
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        return Math.max(lh, rh)+1;
    }
}