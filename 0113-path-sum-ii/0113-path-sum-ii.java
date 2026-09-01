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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        solveTS(root,targetSum,0, new ArrayList<>(),res);
        return res;

    }
    public void solveTS(TreeNode root, int targetSum, int sum, List<Integer> rs, List<List<Integer>> res){
        if(root==null){
                return;
            }
        sum += root.val;
        rs.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res.add(new ArrayList<>(rs));
            }
        }
        solveTS(root.left,targetSum,sum,rs,res);
        solveTS(root.right,targetSum,sum,rs,res);

        rs.remove(rs.size()-1);
    }
}