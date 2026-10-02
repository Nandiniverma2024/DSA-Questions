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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        // Base Case
        if(root==null){
            return;
        }

        // Recursive call
        flatten(root.right);
        flatten(root.left);


        // work(flatten binary tree) 
        root.right=prev;
        prev=root;

        root.left=null;
    }
}