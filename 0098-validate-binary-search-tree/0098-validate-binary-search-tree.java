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
    TreeNode prev = null;
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        isValid(root);
        return res;
    }
    public void isValid(TreeNode root){
        if(root==null) return;
        isValid(root.left);
        if(prev==null) prev = root;
        else{
            if(root.val<=prev.val){
                res = false;
            }
            prev = root;
        }
        isValid(root.right);
    }
}