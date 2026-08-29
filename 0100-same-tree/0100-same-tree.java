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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Condition
        if(p==null && q==null){
            return true;
        }
        if(q==null || p==null){
            return false;
        }
        // work
        if(p.val!=q.val){
                return false;
        }
        // recursive call
        boolean left=isSameTree(p.left, q.left);
        boolean right=isSameTree(p.right, q.right);

        return (left&&right);
    }
}