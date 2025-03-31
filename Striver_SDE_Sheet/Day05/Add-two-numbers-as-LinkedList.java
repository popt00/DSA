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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode adder=new ListNode();
        ListNode head=adder;
        int carry=0;
        while(l1!=null && l2!=null){
            carry+= l1.val+l2.val;
            ListNode temp=new ListNode(carry%10);
            adder.next=temp;
            adder=adder.next;
            carry/=10;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            carry+= l1.val;
            ListNode temp=new ListNode(carry%10);
            adder.next=temp;
            adder=adder.next;
            carry/=10;
            l1=l1.next;
        }
        while(l2!=null){
            carry+=l2.val;
            ListNode temp=new ListNode(carry%10);
            adder.next=temp;
            adder=adder.next;
            carry/=10;
            l2=l2.next;
        }
        while(carry!=0){
            ListNode temp=new ListNode(carry%10);
            adder.next=temp;
            adder=adder.next;
            carry/=10;
        }
        return head.next;
    }
}
