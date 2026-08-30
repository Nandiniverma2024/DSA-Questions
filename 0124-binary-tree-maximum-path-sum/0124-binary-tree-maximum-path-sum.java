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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftST=Math.max(0, dfs(root.left));
        int rightST=Math.max(0, dfs(root.right));

        int currSum=leftST+rightST+root.val;

        maxSum=Math.max(maxSum, currSum);

        // Pass the best single path to upward node(if exist)  
        return root.val+Math.max(leftST,rightST);
    }
}