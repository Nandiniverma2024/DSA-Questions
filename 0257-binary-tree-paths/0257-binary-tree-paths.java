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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        solve(root, "", ans);
        return ans;
    }
    public void solve(TreeNode root, String Path, List<String> ans){
        // Main kaam 
        Path=Path+root.val;

        // Base Case(leaf node milte hi add path into ans list)
        if(root.left==null && root.right==null){
            ans.add(Path);
            return;
        }

        // Recursion
        // explore left possible path
        if(root.left!=null){
            solve(root.left, Path+"->", ans);
        }
        // explore right possible path
        if(root.right!=null){
            solve(root.right, Path+"->", ans);
        }
    }
}