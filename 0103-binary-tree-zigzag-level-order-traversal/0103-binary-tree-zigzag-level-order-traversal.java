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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int lvlSize = q.size();

            List<Integer> temp = new ArrayList<>(
                Collections.nCopies(lvlSize, 0)
            );

            int start = 0;
            int end = lvlSize - 1;

            while (lvlSize-- > 0) {

                TreeNode t = q.poll();

                if (leftToRight) {
                    temp.set(start, t.val);
                    start++;
                } else {
                    temp.set(end, t.val);
                    end--;
                }

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }
            }

            ans.add(temp);

            leftToRight = !leftToRight;
        }

        return ans;
    }
}