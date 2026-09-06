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
    TreeNode prev=null; //muje hr call m previous null nhi chahiye
    // muje updated previous chahiye, isilye use Global prev
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root; // update prev

        // do reverse of preorder to get linked list of style preorder 
        // root left right => right left root
    }
}


// niche se jo node milega vo previous h
// pr upper se dhekhne m vo next node lagega