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
        HashMap<TreeNode , TreeNode> parent=new HashMap<>();
        markParent(root, parent);
        HashMap<TreeNode, Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(target);
        visited.put(target, true);
        int dist=0;


        while(!q.isEmpty()){
            // Hr level pr dist ka cnt increase hoga
            if(dist==k){
                break;
            }
            dist++;
            int levelCnt=q.size();

            for(int i=0; i<levelCnt; i++){
                TreeNode curr=q.poll();
                // Radial moment => left child, right child , parent

                // (i) => Left child
                if(curr.left!=null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                // (ii) => right child
                if(curr.right!=null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                // (iii) => parent (agr curr ka parent h, put parent)
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr), true);
                }
            }
        }
        // List to store ans
        List<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            int num=curr.val;
            li.add(num);
        }

        return li;
    }
    public void markParent(TreeNode root, HashMap<TreeNode , TreeNode> parent){
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            if(curr.left!=null){
                parent.put(curr.left, curr); //child and its parent
                q.offer(curr.left);
            }

            if(curr.right!=null){
                parent.put(curr.right, curr); //child and its parent
                q.offer(curr.right);
            }
        }
    }
}