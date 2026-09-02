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
    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        dfs(root, 0, 0);

        for(Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> outer : map.entrySet()){
            TreeMap<Integer, ArrayList<Integer>> levelMap=outer.getValue();
            ArrayList<Integer> li=new ArrayList<>();

            for(Map.Entry<Integer, ArrayList<Integer>> inner:levelMap.entrySet()){
                ArrayList<Integer> subLi=inner.getValue();
               
                Collections.sort(subLi);
                li.addAll(subLi);
            }
            ans.add(li);
        }
        return ans;
    }
    public void dfs(TreeNode root, int col, int level){
        // Base Case
        if(root==null){
            return;
        }
        // Main Kaam
        if(!map.containsKey(col)){
            map.put(col, new TreeMap<>());
        }
        if(!map.get(col).containsKey(level)){
            map.get(col).put(level, new ArrayList<>());
        }
        map.get(col).get(level).add(root.val);

        // recursion
        dfs(root.left, col-1, level+1);
        dfs(root.right, col+1, level+1);
    }
}

// map(col, map(level, us level ki list))
// treemap sirf key ko sort krta h , values ko sort krne ke lia use Collections.sort or use priority queue