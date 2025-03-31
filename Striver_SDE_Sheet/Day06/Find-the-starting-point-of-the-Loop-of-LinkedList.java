/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode slowPointer=head,fastPointer=head;
        do{
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;
            if(fastPointer!=null)fastPointer=fastPointer.next;
        }while(fastPointer!=null && slowPointer!=fastPointer);
        
        if(fastPointer==null)return null; //no cycle
        slowPointer=head;
        while(slowPointer!=fastPointer){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;
        }
        return fastPointer;
    }
}
