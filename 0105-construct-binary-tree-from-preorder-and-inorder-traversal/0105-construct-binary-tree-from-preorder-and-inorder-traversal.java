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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        int m=inorder.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root=build(preorder, 0, n-1, inorder, 0, m-1, map);

        return root;
    }
    public TreeNode build(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(inStart>inEnd || preStart>preEnd){
            return null;
        }

        TreeNode root=new TreeNode(preorder[preStart]); //convert array el into TreeNode

        int inroot=map.get(root.val); //index of root
        int numsLeft=inroot-inStart; // no of elements in left

        root.left=build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inroot-1, map);
        root.right=build(preorder, preStart+numsLeft+1, preEnd, inorder, inroot+1, inEnd, map);

        return root;

    }
}