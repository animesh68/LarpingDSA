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
        List<Integer> arr = new ArrayList<>();
        if(root==null) return false;
        traverse(root,k,arr);
        int i = 0;
        int j = arr.size() - 1;
        for(;i<j;){
            int low = arr.get(i);
            int high = arr.get(j);
            if(low+high==k) return true;
            else if(low+high<k) i++;
            else j--;
        }
        return false;
    }
    static void traverse(TreeNode root, int k,List arr){
        if(root==null) return;
        traverse(root.left,k,arr);
        arr.add(root.val);
        traverse(root.right,k,arr);
    }
}