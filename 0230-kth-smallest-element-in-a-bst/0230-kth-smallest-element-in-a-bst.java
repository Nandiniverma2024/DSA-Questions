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
    int curr=0, ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        // Base Case
        if(root==null){
            return -1;
        }
        kthSmallest(root.left, k);
        curr++;
        if(curr==k){
            ans=root.val;
            return ans;
        }
        kthSmallest(root.right, k);

        return ans;
    }
}