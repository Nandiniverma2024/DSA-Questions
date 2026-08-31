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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();

        // Base Case
        if(root==null){
            return ans;
        }

        q.offer(root);

        // Flag
        boolean leftToRight=true;

        while(!q.isEmpty()){
            int levelNum=q.size();
            List<Integer> subLi=new ArrayList<>();
            for(int i=0; i<levelNum; i++){
                TreeNode curr=q.poll();
                if(leftToRight==true){
                    subLi.add(curr.val);
                }else{  // reverse
                    // add curr el on 0th index, and baki el right m shift ho jaynge
                    subLi.add(0, curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            ans.add(subLi);
            // reverse direction of flag after each level
            leftToRight = !leftToRight;
        }
        return ans;
    }
}