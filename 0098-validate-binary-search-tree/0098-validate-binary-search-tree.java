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
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root, long minVal, long maxVal){
        if(root==null){
            return true;
        }
        // Base Case
        if(root.val<=minVal || root.val>=maxVal){
            return false;
        }
        // value range se bhar jane pr invalid h
        // Main recursion
        return valid(root.left, minVal, root.val) && valid(root.right, root.val, maxVal);
        // dono subtree valid bst ki condition satisfy krne chahiye
    }
}