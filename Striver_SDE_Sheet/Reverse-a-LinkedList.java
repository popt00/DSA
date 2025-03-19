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
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode temp=head;
        ListNode tempHead=new ListNode();
        while(temp!=null){
            ListNode t= temp.next;
            temp.next=tempHead.next;
            tempHead.next=temp;
            temp=t;
        }
        return tempHead.next;
    }
}
