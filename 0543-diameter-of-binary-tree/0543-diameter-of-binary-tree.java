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
        // Base Case
        if(root==null){
            return 0;
        }

        int leftH=height(root.left);
        int rightH=height(root.right);

        int dia=leftH+rightH; // diameter thoush root

        int leftDia=diameterOfBinaryTree(root.left);
        int rightDia=diameterOfBinaryTree(root.right);

        return Math.max(dia, Math.max(leftDia, rightDia));

    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left, right)+1;
    }
}