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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> borg = new LinkedList<>();
        borg.offer(root);
        boolean isitborg = false;
        while(!borg.isEmpty()){
            TreeNode t = borg.poll();
            if(t==null) isitborg = true;
            else{
                if(isitborg) return false;
                borg.offer(t.left);
                borg.offer(t.right);
            }
        }
        return true;
    }
}