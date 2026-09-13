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
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();

        List<Integer> temp=new ArrayList<>();
        
        inorder(root1, l1);
        inorder(root2, l2);

        int i=0, j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<=l2.get(j)){
                temp.add(l1.get(i));
                i++;
            }else if(l2.get(j)<l1.get(i)){
                temp.add(l2.get(j));
                j++;
            }
        }

        while(i<l1.size()){
            temp.add(l1.get(i));
            i++;
        }

        while(j<l2.size()){
            temp.add(l2.get(j));
            j++;
        }

        return temp;
    }
    public void inorder(TreeNode root, List<Integer> li){
        if(root==null){
            return;
        }
        inorder(root.left, li);
        li.add(root.val);
        inorder(root.right, li);
    }
}