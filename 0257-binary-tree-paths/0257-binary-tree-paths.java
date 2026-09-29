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
        List<String> li=new ArrayList<>();
        solve(root, "", li);
        return li;
    }
    public void solve(TreeNode root, String path, List<String> li){
        path+=root.val;
        if(root.left == null && root.right==null){
            li.add(path);
        }
        if(root.left!=null){
            solve(root.left, path+"->", li);
        }
        if(root.right!=null){
            solve(root.right, path+"->", li);
        }
    }
}