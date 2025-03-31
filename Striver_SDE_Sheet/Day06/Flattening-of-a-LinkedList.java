class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        while(root.next!=null){
            Node nextRoot= root.next;
            root.next=root.next.next;
            merge(root,nextRoot);
        }
        return root;
    }
    void merge(Node root, Node neighbor){
        Node temp1=root.bottom;
        Node temp2=neighbor;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                root.bottom=temp1;
                temp1=temp1.bottom;
            }
            else {
                root.bottom=temp2;
                temp2=temp2.bottom;
            }
            root=root.bottom;
        }
        while(temp1!=null){
            root.bottom=temp1;
            temp1=temp1.bottom;
            root=root.bottom;
        }
        while(temp2!=null){
            root.bottom=temp2;
            temp2=temp2.bottom;
            root=root.bottom;
        }
    }
}
