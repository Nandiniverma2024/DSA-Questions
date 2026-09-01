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
    public int findBottomLeftValue(TreeNode root) {
        int ht=height(root);

        Queue<TreeNode> q=new ArrayDeque<>();
        if(root==null){
            return 0;
        }
        q.offer(root);

        int levels=0;
        int ans=-1;

        while(!q.isEmpty()){
            int levelNum=q.size();
            levels++;

            for(int i=0; i<levelNum; i++){
                TreeNode curr=q.poll();
                if(levels==ht){
                    ans=curr.val;
                    break;
                }

                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
        return ans;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        return Math.max(lh, rh)+1;
    }
}