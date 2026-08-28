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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=minDepth(root.left);
        int rh=minDepth(root.right);

        // agr left child exist hi nhi krta to return right child ki height
        if(root.left==null){
            return rh+1;
        }
        // agr right child exist hi nhi krta to return left child ki height
        if(root.right==null){
            return lh+1;
        }

        return Math.min(lh, rh)+1;
    }
}