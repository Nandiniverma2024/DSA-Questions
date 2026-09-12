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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> leftStack=new Stack<>();
        Stack<TreeNode> rightStack=new Stack<>();
        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        while(!leftStack.isEmpty() && !rightStack.isEmpty()){
            TreeNode left=leftStack.peek();
            TreeNode right=rightStack.peek();

            // agr dono same node ko point kr rhe h, return false
            if(left==right){
                return false;
            }

            if(left.val + right.val == k){
                return true;
            }else if(left.val + right.val < k){
                TreeNode node=leftStack.pop();
                // right subtree ke sare left child ko stack m push kr
                pushLeft(node.right, leftStack);
            }else if(left.val+right.val > k){
                TreeNode node=rightStack.pop();
                pushRight(node.left, rightStack);
            }
        }
        return false;
    }
    public void pushLeft(TreeNode root, Stack<TreeNode> leftStack){
        while(root!=null){
            leftStack.push(root);
            root=root.left;
        }
    }
    public void pushRight(TreeNode root, Stack<TreeNode> rightStack){
        while(root!=null){
            rightStack.push(root);
            root=root.right;
        }
    }
}