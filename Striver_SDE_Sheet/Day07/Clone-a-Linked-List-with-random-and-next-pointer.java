/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        insertCopyAfterNode(head);
        setRandomCopiedNode(head);
        return getCopiedAfterSplittingCopiedOriginal(head);
    }
    private void insertCopyAfterNode(Node head){
        Node temp=head;
        while(temp!=null){
            Node afterTemp=new Node(temp.val);
            afterTemp.next=temp.next;
            temp.next=afterTemp;
            temp=temp.next.next;
        }
    }
    private void setRandomCopiedNode(Node head){
        Node temp=head;
        while(temp!=null){
            if(temp.random!=null)temp.next.random=temp.random.next;
            ameatemp=temp.next.next;
        }
    }
    private Node getCopiedAfterSplittingCopiedOriginal(Node head){
        Node preCopiedHead=new Node(0);
        Node temp=head,tempCopied=preCopiedHead;
        while(temp!=null){
            tempCopied.next=temp.next;
            tempCopied=tempCopied.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return preCopiedHead.next;
    }
}
