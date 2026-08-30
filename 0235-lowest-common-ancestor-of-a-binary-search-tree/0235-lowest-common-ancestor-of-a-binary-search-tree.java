/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if(p.val<q.val) res = lca(root,p,q);
        else res = lca(root,q,p);
        return res;
    }
    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==p || root==q) return root;
        if(root.val<p.val) return lca(root.right,p,q);
        else if(root.val>q.val) return lca(root.left,p,q);
        else return root;
    }
}