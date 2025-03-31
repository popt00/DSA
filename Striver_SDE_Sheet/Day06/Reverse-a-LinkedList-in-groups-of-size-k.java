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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead=new ListNode(0,head);
        ListNode preTemp=preHead;
        while(preTemp!=null){
            ListNode st=preTemp.next;// after reversing st is the preTemp
            ListNode ed=preTemp.next;//iterate ListNode ed, k times
            int count=0;
            while(count<k && ed!=null){
                ed=ed.next;
                count++;
            }
            if(count==k){
                //System.out.println(preTemp.next.val+","+ed.val);
                preTemp.next=reverseGroup(preTemp.next,ed);
                preTemp=st;
            }
            else break;
        }
        return preHead.next;
    }

    //start is returned, end is not included
    //reversing [st,....,ed) and returning st
    public ListNode reverseGroup(ListNode st, ListNode ed){
        ListNode preHead=new ListNode();
        ListNode tempSt=st,tempItr=st;
        while(tempItr!=ed){
            ListNode temp= preHead.next;
            preHead.next=tempItr;
            tempItr=tempItr.next;
            preHead.next.next=temp;
        }
        tempSt.next=ed;
        return preHead.next;
    }
}
