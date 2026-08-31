/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> crit = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int pos = 1;

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                crit.add(pos);
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (crit.size() < 2) {
            return new int[]{-1, -1};
        }

        int maxDist = crit.get(crit.size() - 1) - crit.get(0);

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < crit.size(); i++) {
            minDist = Math.min(minDist, crit.get(i) - crit.get(i - 1));
        }

        return new int[]{minDist, maxDist};
    }
}