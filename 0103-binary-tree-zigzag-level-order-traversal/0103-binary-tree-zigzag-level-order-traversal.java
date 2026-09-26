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
        List<List<Integer>> li=new ArrayList<>();
        Queue<TreeNode> q=new ArrayDeque<>();

        if(root==null){
            return li;
        }

        q.offer(root);
        
        boolean leftToRight=true;
        while(!q.isEmpty()){
            int levelCnt=q.size();
            List<Integer> subLi=new ArrayList<>();
            for(int i=0; i<levelCnt; i++){
                TreeNode curr=q.poll();


                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                } 
                

                if(leftToRight==true){
                    subLi.add(curr.val);
                }else{
                    subLi.add(0, curr.val);
                }
            }
            leftToRight = !leftToRight;
            li.add(subLi);
        }
        return li;
    }
}
