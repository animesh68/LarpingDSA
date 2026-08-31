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
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

        if(count<=2) return new int[]{-1,-1};
        
        List<Integer> crit = new ArrayList<>();
        curr = head.next;
        ListNode prev = head;
        count = 0;
        while(curr.next!=null){
            if(curr.val < prev.val && curr.val<curr.next.val) crit.add(count);
            if(curr.val > prev.val && curr.val > curr.next.val) crit.add(count);          
            prev = curr;
            curr = curr.next;
            count++;
        }
        if (crit.size() < 2) {
            return new int[]{-1, -1};
        }
        int maxdist = crit.get(crit.size()-1) - crit.get(0);
        int mindist = Integer.MAX_VALUE;
        for(int i=1;i<crit.size();i++){
            mindist = Math.min(mindist,crit.get(i)-crit.get(i-1));
        }
        return new int[]{mindist,maxdist};
    }
}