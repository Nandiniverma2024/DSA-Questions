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
        solve(root);
        return maxSum;
    }
    public int solve(TreeNode root){
        // Base Case
        if(root==null){
            return 0;
        }

        // Traversal
        int leftSum=Math.max(0, solve(root.left));
        int rightSum=Math.max(0, solve(root.right));

        // Work(hr node pe path sum cal kra and maxSum ke sath compare kra
        maxSum=Math.max(maxSum, root.val+leftSum+rightSum);

        // Give path ki left se choose kru ya right se
        return root.val + Math.max(leftSum, rightSum);
    }   
}