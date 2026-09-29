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
        TreeNode root;
        int col;
        int row;
        Tuple(TreeNode root, int col, int row){
            this.root=root;
            this.col=col;
            this.row=row;
        }
    } 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        // col -> row -> root
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();

        Queue<Tuple> q=new ArrayDeque<>(); // root -> col -> row

        if(root==null){
            return res;
        }

        // root -> col -> row
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple curr=q.poll();

            TreeNode node=curr.root;
            int col=curr.col;
            int row=curr.row;

            // Add col, jo chiz ni pta usa new bna ke chor do
            // jaise new Priority queue
            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }

            // Add Row, and priority for root value
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

        // col -> key, row -> values
        // col se assosiated rows pr loop chal rha h
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
            List<Integer> li=new ArrayList<>();
            // rows(key), pq(root) i.e values
            for(PriorityQueue<Integer> pq:rows.values()){
                // poll to add values in list
                while(!pq.isEmpty()){
                    li.add(pq.poll());
                }
            }
            res.add(li);
        }
        return res;
    }
}