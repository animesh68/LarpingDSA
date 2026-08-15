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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        
        ListNode left = head;
        ListNode res = null;
        ListNode prevleft = null;
        ListNode right;
        int size = 2;
        while(true){
            right=left;
            for(int i=0;i<size-1;i++){
                if(right==null) break;
                right = right.next;
            }

            if(right!=null){
                ListNode nextleft = right.next;
                left.next = nextleft;
                right.next = left;
                if(prevleft!=null){
                    prevleft.next = right;
                }
                prevleft = left;
                if(res==null){
                    res = right;
                }
                left = nextleft;
            }
            else{
                if(prevleft!=null){
                    prevleft.next = left;
                }
                if(res==null) res=left;
                break;
            }
        }
        return res;
    }
}