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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        bounce(root,0);
        return res;
    }
    public int bounce(TreeNode root, int sum){
        if(root==null) return 0;
        int x = bounce(root.left,sum);
        int y = bounce(root.right,sum);
        sum = x+y;
        res = Math.max(res,sum);
        return 1 + Math.max(x,y);
    }
}