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
    class Pair{
        TreeNode root;
        int idx;
        Pair(TreeNode root, int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxWidth=0;
        Queue<Pair> q=new ArrayDeque<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int levelCount=q.size(); //us level pr present nodes
            int first=q.peek().idx;
            int last=first;

            
            for(int i=0; i<levelCount; i++){
                Pair curr=q.poll();
                TreeNode curRoot=curr.root;
                int idx=curr.idx;

                last=idx;
                if(curRoot.left!=null){
                    q.offer(new Pair(curRoot.left, 2*idx+1));
                }
                if(curRoot.right!=null){
                    q.offer(new Pair(curRoot.right, 2*idx+2));
                }
            }
            // width => means length 
            // number of nodes in a level b/w any two nodes
            int width=last-first+1;
            maxWidth=Math.max(maxWidth, width);
        }
        return maxWidth;
    }
}