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
        Queue<Pair> q=new ArrayDeque<>();
        int maxWidth=0;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            // to track idx, we need first and last index
            int first=q.peek().idx; //fix idx(of the first)
            int last=first; //initialize 

            int levelCnt=q.size();

            for(int i=0; i<levelCnt; i++){
                Pair curr=q.poll();

                TreeNode node=curr.root;
                int idx=curr.idx;

                // Update last
                last=idx;

                if(node.left!=null){
                    q.offer(new Pair(node.left, 2*idx+1));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, 2*idx+2));
                }
            }
            int width=last-first+1;
            maxWidth=Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}