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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent=new HashMap<>();
        markParent(root, parent);
        TreeNode startNode=findStart(root, start);
        HashMap<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(startNode);
        visited.put(startNode, true);

        int dist=-1;
        while(!q.isEmpty()){
            int levelCnt=q.size();
            dist++;
            for(int i=0; i<levelCnt; i++){
                TreeNode curr=q.poll();

                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        return dist;
    }
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            // Explore left
            if(curr.left!=null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            // Expolre right
            if(curr.right!=null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public TreeNode findStart(TreeNode root, int start){
        if(root==null){
            return null;
        }

        // Main kaam 
        if(root.val==start){
            return root;
        }

        // Recursion
        TreeNode left=findStart(root.left, start);
        TreeNode right=findStart(root.right, start);

        if(left!=null){
            return left;
        }

        return right;
    }
}