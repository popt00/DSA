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
        HashMap<Node,Node> map=new HashMap<>();
        Node preHead=new Node(0);
        Node tempItr=head,tempItr2=preHead;
        while(tempItr!=null){
            Node temp=new Node(tempItr.val);
            map.put(tempItr,temp);
            tempItr2.next=temp;
            tempItr=tempItr.next;
            tempItr2=tempItr2.next;
        }
        tempItr2=preHead.next;
        tempItr=head;
        while(tempItr!=null){
            if(tempItr.random!=null)
                tempItr2.random=map.get(tempItr.random);
            tempItr=tempItr.next;
            tempItr2=tempItr2.next;
        }
        return preHead.next;
    }
}
