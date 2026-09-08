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
    int curr=0, ans=0; //make it global, taki hr call m 0 na ho
    public int kthSmallest(TreeNode root, int k) {
        // Base Case
        if(root==null){
            return 0;
        }
        // Inorder Traversal
        kthSmallest(root.left, k);
        curr++; //root milte count barao
        if(curr==k){ 
            ans=root.val;
            return ans;
        }
        kthSmallest(root.right, k);

        return ans;
    }
}