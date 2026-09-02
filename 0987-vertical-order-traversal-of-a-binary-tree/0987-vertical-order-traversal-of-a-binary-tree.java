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
    class Tuple{
        TreeNode node;
        int col;
        int row;
        Tuple(TreeNode node, int col, int row){
            this.node=node;
            this.col=col;
            this.row=row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new ArrayDeque<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple curr=q.poll();

            TreeNode node=curr.node;
            int col=curr.col;
            int row=curr.row;

            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).add(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left, col-1, row+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right, col+1, row+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
            ArrayList<Integer> li=new ArrayList<>();
            for(PriorityQueue<Integer> nodes : rows.values()){
                while(!nodes.isEmpty()){
                    li.add(nodes.poll());
                }
            }
            ans.add(li);
        }
        return ans;
    }
}