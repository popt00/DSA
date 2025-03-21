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
        if(head==null)return head;
        int len=getLen(head);
        k= len - k%len;
        if(k==len)return head;
        int ith=1;
        ListNode preCut=head;
        while(ith<k){
            ith++;
            preCut=preCut.next;
        }
        ListNode newHead=preCut.next;
        preCut.next=null;
        preCut=newHead;
        while(preCut.next!=null){
            preCut=preCut.next;
        }
        preCut.next=head;
        return newHead;
    }
    public int getLen(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }

}
