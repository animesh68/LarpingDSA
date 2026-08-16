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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int n = 1;
        ListNode last = head;

        while(last.next != null){
            n++;
            last = last.next;
        }
        k=k%n;
        if(k==0) return head;

        int count = 1;
        ListNode newl = head;

        while(newl!=null){
            if(count==(n-k)){
                break;
            }
            count++;
            newl = newl.next;
        }
        ListNode res = newl.next;
        last.next = head;
        newl.next = null;

        return res;
    }
}