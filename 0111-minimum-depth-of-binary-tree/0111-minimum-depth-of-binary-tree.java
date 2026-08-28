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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q=new ArrayDeque<>();
        int cnt=0;

        if(root==null){
            return 0;
        }

        q.offer(root);
        
        while(!q.isEmpty()){
            int levelNum=q.size();
            cnt++;

            for(int i=0; i<levelNum; i++){
                TreeNode curr=q.poll();

                if(curr.left==null && curr.right==null){
                    return cnt;
                }
                
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            
            }
        }
        return cnt;
    }
}