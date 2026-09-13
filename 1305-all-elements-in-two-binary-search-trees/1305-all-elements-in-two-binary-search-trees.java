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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> leftStack1=new Stack<>();
        Stack<TreeNode> leftStack2=new Stack<>();
        List<Integer> temp=new ArrayList<>();
        pushLeft(root1, leftStack1);
        pushLeft(root2, leftStack2);

        while(!leftStack1.isEmpty() && !leftStack2.isEmpty()){
            if(leftStack1.peek().val <= leftStack2.peek().val){
                TreeNode curr=leftStack1.pop();
                temp.add(curr.val);
                pushLeft(curr.right, leftStack1); //search for leftmost node from right subtree
            }else if(leftStack2.peek().val < leftStack1.peek().val){
                TreeNode curr=leftStack2.pop();
                temp.add(curr.val);
                pushLeft(curr.right, leftStack2); //search for leftmost node from right subtree
            }
        }

        while(!leftStack1.isEmpty()){
            TreeNode curr=leftStack1.pop();
            temp.add(curr.val);
            pushLeft(curr.right, leftStack1);
        }

        while(!leftStack2.isEmpty()){
            TreeNode curr=leftStack2.pop();
            temp.add(curr.val);
            pushLeft(curr.right, leftStack2);
        }

        return temp;
    }
    public void pushLeft(TreeNode root, Stack<TreeNode> leftStack){
        while(root!=null){
            leftStack.push(root);
            root=root.left;
        }
    }
    
}