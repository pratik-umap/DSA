public class classLinkedList {
   static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node insertLL(int position,int data, Node head) {
        Node newNode=new Node(data);
        if (position == 0) {
            // newNode.next=head;
            head=newNode;
            return head;
        }
         Node curr=head;
        for (int i = 0; i < position-1; i++) {
            curr=curr.next;
        }
        newNode.next=curr.next;
        curr.next=newNode;
        return head;
    }
    public static void printLL(Node head) {
        Node curr=head;
        while (curr != null) {
            System.out.print(curr.data +" -> ");
            curr=curr.next;
        }
        System.out.println("null ");
    }
    public static Node DeleteNode(int position,Node head) {
        if (position == 0) {
            head=head.next;
            return head;
        }
        Node curr=head;
        for (int i = 0; i < position-1; i++) {
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
    public static int findMiddleElement(Node head) {
        Node slow=head;
        Node fast=head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    public static Node DeleteGivenNode(Node node) {
       
        node.data=node.next.data;
        node.next=node.next.next;
        return node;
    }
  
    public static void findKthElementFromLast(int k,Node head){
        int cnt=0;
        Node curr1=head;
        while (curr1 != null) {
            cnt++;
            curr1=curr1.next;
        }
    
        int pos=cnt-k;
        Node curr=head;
        for (int i = 0; i < pos; i++) {
            curr=curr.next;
        }
        System.out.println(curr.data);
    }
    public static void removeDuplicateFromSortedLL(Node head) {
        Node temp=head,prev=head;
        while (temp != null) {
           if (temp.data != prev.data) {
            prev.next=temp;
            prev=temp;
           }
           temp=temp.next;
        }
        if (prev != temp) {
            prev.next=null;
        }
    }
    public static void main(String[] args) {
        Node n1=new Node(10);
        Node n2=new Node(20);
        Node n3=new Node(20);
        Node n4=new Node(40);
        Node head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        // printLL(head);
    //    head=insertLL(0, 50, head);
    //    head=insertLL(5, 5, head);
       printLL(head);

    //   head= DeleteNode(4, head);
        // printLL(head);
    //    System.out.println(findMiddleElement(head));
      
        //  DeleteGivenNode(n2);
        //  printLL(head);
         int k=0;
        // findKthElementFromLast(k, head);

         removeDuplicateFromSortedLL(head);
        //  printLL(head);
        //  sortLLUsingBubbleSort(head);
        // reverseLL(head);
         printLL(head);
    } 
}
