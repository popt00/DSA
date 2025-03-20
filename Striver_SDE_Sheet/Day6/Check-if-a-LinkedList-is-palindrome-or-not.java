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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)fast=fast.next;
        }
        ListNode reverseHead= reverse(slow);
        while(reverseHead!=null && head!=null){
            if(reverseHead.val!=head.val)return false;
            reverseHead=reverseHead.next;
            head=head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode preHead=new ListNode();
        while(head!=null){
            ListNode temp=head.next;
            head.next=preHead.next;
            preHead.next=head;
            head=temp;
        }
        return preHead.next;
    }
}
