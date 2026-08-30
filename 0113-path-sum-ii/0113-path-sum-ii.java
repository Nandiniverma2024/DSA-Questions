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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();

        solve(root, targetSum, 0, li, ans);
        return ans;
    }
    public void solve(TreeNode root, int targetSum, int sum, List<Integer> li, List<List<Integer>> ans){
        // Base Case
        if(root==null){
            return;
        }

        sum+=root.val;
        li.add(root.val);

        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(li));
            }
        }else{
            // non leaf node => explore left and right choices(branches)\
            solve(root.left, targetSum, sum, li, ans);
            solve(root.right, targetSum, sum, li, ans);
        }

        // Do backtrack either it is leaf node or not (if sum 1= targetSum)
        li.remove(li.size()-1); //backtrack
    }
}