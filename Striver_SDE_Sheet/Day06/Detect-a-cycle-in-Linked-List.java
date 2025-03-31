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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode slowPointer=head,fastPointer=head;
        do{
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next;
            if(fastPointer!=null)fastPointer=fastPointer.next;
        }while(fastPointer!=null && slowPointer!=fastPointer);
        
        return fastPointer!=null;
    }
}
