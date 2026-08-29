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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode l = root.left;
        TreeNode r = root.right;
        boolean res = symmetry(l,r);
        return res;
    }
    static boolean symmetry(TreeNode l, TreeNode r){
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;
        if(l.val != r.val) return false;

        boolean b1 = symmetry(l.left,r.right);
        boolean b2 = symmetry(l.right,r.left);
        if(b1 && b2) return true;
        return false;
    }
}