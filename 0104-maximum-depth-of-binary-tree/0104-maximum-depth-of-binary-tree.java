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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int z = md(root,0);
        return z;
    }
    public int md(TreeNode root,int sum){
        if(root==null) return 0;
        int x = md(root.left,sum);
        int y = md(root.right,sum);
        sum = x+y;
        return 1 + Math.max(x,y);
    }
}