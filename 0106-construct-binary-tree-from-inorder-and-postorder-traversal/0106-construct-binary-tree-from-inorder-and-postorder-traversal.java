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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        int m=postorder.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root=solve(inorder, 0, n-1, postorder, 0, m-1, map);

        return root;
    }
    public TreeNode solve(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd, HashMap<Integer, Integer> map){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }

        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(root.val);
        int numsRight=inEnd-inRoot;

        root.right=solve(inorder, inRoot+1, inEnd, postorder, postEnd-numsRight, postEnd-1, map);
        root.left=solve(inorder, inStart, inRoot-1, postorder, postStart, postEnd-numsRight-1, map);

        return root;
    }
}