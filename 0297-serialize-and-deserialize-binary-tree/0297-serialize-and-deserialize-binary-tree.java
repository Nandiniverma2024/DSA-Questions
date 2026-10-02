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
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new ArrayDeque<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            if(curr==null){
                sb.append("n ");
                continue;
            }
            
            sb.append(curr.val+" ");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return sb.toString();
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

        while(!q.isEmpty()){
            TreeNode parent=q.poll();

            int i=0;
            if(!values[i].equals("n")){
                TreeNode left=new TreeNode(Integer.parseInt(parent));
                parent.left=left;
                q.offer(left);
            }

            i++;

            if(i<values.length && !values[i].equals("n")){
                TreeNode right=new TreeNode(Integer.parseInt(curr));
                parent.right=right;
                q.offer(right);
            }
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));