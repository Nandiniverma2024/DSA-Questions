/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        if(root==null){
            return null; //no common ancestor
        }

        // work
        if(root.val==p.val || root.val==q.val){
            return root;
        }

        // Recursive call
        TreeNode leftLca=lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca=lowestCommonAncestor(root.right, p, q);

        if(leftLca!=null && rightLca!=null){
            return root;
        }else if(leftLca!=null){
            return leftLca;
        }else if(rightLca!=null){
            return rightLca;
        }

        return null;
    }
}