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
        if(root==null){
            return 0;
        }

        int leftHt=getLeft(root);
        int rightHt=getRight(root);

        if(leftHt==rightHt){
            // series => 1,2,4,8...
            // sum of n terms in gp series => a((r^n)-1)/(r-1)
            // Gp formula => 2^h -1
            return (int)(Math.pow(2, leftHt) -1); 
        }
        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    public int getLeft(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    public int getRight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}   