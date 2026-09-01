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
    int maxVal=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxVal;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int leftMax=Math.max(0, solve(root.left));
        int rightMax=Math.max(0, solve(root.right));
        
        // work(Global maximum) (u-Shape)
        maxVal=Math.max(maxVal, (root.val + leftMax + rightMax));


        // MAxima from left nad right subtree
        // For finding left nad right maximum
        return Math.max(leftMax, rightMax) + root.val;
        
    }
}