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
        int cnt=-1; //level 0 pr kuch infect nhi ho rha, vo level 0 cnt nhi hoga

        q.offer(startNode);
        visited.put(startNode, true);

        while(!q.isEmpty()){
            int levelCnt=q.size();
            cnt++; //on each level
            for(int i=0; i<levelCnt; i++){
                TreeNode curr=q.poll();

                // Radial moment => left, right, child

                // (i) left child
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                // (i) Right child
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                // (i) left child
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        return cnt;
    }

    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> q=new ArrayDeque<>();
        
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            
            if(curr.left!=null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
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
        if(root.val==start){
            return root;
        }
        TreeNode left=findStart(root.left, start);
        TreeNode right=findStart(root.right, start);

        if(left!=null){
            return left;
        }

        return right;
    }
}