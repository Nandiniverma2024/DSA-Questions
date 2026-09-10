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
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root);
        return ans;
    }
    public int[] helper(TreeNode root){
        // Base Case(for leaf node ke baccho ke lia)
        if(root==null){
            return new int[]{0,0};
        }
        int left[]=helper(root.left);
        // left => root node ke basis pr left array bhara jayga
        int right[]=helper(root.right);

        int sum = root.val + left[0] + right[0];

        int cnt = 1 + left[1] + right[1];

        int avg=sum/cnt;

        if(avg==root.val){
            ans++;
        }

        return new int[]{sum, cnt};
    }
}