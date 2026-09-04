/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        
        // (children, children ka parent)
        HashMap<TreeNode, TreeNode> parent=new HashMap<>();  
        markParent(root, parent); //mark parent of every node
        HashMap<TreeNode, Boolean> visited=new HashMap<>();

        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(target);
        visited.put(target, true);

        int dist=0;
        while(!q.isEmpty()){
            int levelCnt=q.size(); //hr level pr kitne count/nodes h
            if(dist==k){
                break;
            }
            dist++; //increase distance at each level

            for(int i=0; i<levelCnt; i++){
                TreeNode curr=q.poll();

                // Radial moment => in all direction

                // Left
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                // right
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }

                // Parent => can't access root.parent, check using markParent fun
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            int num=curr.val;
            ans.add(num);
        }
        return ans;
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
}