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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }
    public boolean solve(TreeNode root, int targetSum, int sum){
        // Base Case
        if(root==null){
            return false;
        }

        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum!=targetSum){
                return false;
            }else{
                return true;
            }
        }

        
        if(solve(root.left, targetSum, sum)){
            return true;
        }
        // sum-=root.val; //backtracking (since primitive int)
        // Previous call ka sum samerhega usa minus krne jarurat nhi on basis of children

        return solve(root.right, targetSum, sum);
    }
}