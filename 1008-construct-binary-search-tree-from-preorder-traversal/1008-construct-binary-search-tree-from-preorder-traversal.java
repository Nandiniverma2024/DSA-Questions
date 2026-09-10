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
    int idx=0; //iterate over preorder array
    public TreeNode bstFromPreorder(int[] preorder) {

        return buildTree(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    
    }
    public TreeNode buildTree(int preorder[], long minVal, long maxVal){
        if(idx==preorder.length){
            return null;
        }
        if(preorder[idx]<minVal || preorder[idx]>maxVal){
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        root.left=buildTree(preorder, minVal, root.val);
        root.right=buildTree(preorder, root.val, maxVal);

        return root;
    }
}