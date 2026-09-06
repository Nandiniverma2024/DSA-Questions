/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Base Case
        if(root==null){
            return "";
        }
        StringBuilder pikachu=new StringBuilder();
        Queue<TreeNode> teamRocket=new LinkedList<>();
        teamRocket.offer(root);
        while(!teamRocket.isEmpty()){
            TreeNode curr=teamRocket.poll();
            if(curr==null){
                pikachu.append("n ");
                continue;
                // continue likhne se iske niche wala code nhi chalega, vo skip ho jayga
            }
            pikachu.append(curr.val + " ");
            teamRocket.offer(curr.left);
            teamRocket.offer(curr.right);
        }
        return pikachu.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String values[]=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();

        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        int i=1;

        while(!q.isEmpty()){
            TreeNode parent=q.poll();

            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.offer(left);
            }
        
            i++;

            if(i<values.length && !values[i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));