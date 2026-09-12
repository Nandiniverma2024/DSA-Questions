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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> li=new ArrayList<>();
        inorder(root, li);
        int i=0, j=li.size()-1;
        while(i<j){
            if(li.get(i) + li.get(j) < k){
                i++;
            }else if(li.get(i) + li.get(j) > k){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
    public void inorder(TreeNode root, ArrayList<Integer> li){
        if(root==null){
            return;
        }
        inorder(root.left, li);
        li.add(root.val);
        inorder(root.right, li);
    }
}