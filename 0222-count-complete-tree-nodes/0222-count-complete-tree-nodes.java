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
    public int countNodes(TreeNode root) {
        if(root==null){ //case for leaf node
            return 0; 
        }

        int leftH=getLeft(root);
        int rightH=getRight(root);

        if(leftH==rightH){
            return (int)Math.pow(2, leftH) - 1;  //(2^h) - 1
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
    public int getLeft(TreeNode root){
        int height=0;
        while(root!=null){
            root=root.left;
            height++;
        }
        return height;
    }
    public int getRight(TreeNode root){
        int height=0;
        while(root!=null){
            root=root.right;
            height++;
        }
        return height;
    }
}