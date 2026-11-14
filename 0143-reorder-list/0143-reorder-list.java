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
    public void reorderList(ListNode head) {
        //split the list
        ListNode slow = head;
        ListNode fast = head.next; 
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        //reverse the list
        ListNode prev= null;
        ListNode second = slow.next;//slow or slow.next?
        slow.next=null;
        while(second!=null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        //merge the list
        second = prev;
        ListNode first = head;
        while(second!=null){
            ListNode t1= first.next, t2=second.next;
            first.next = second;
            second.next= t1;
            first=t1;
            second=t2;
        }
    }
}