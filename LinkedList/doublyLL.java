public class doublyLL {
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;

          Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
          }     
    }
    public void addFirst(int data){
      Node newnode =new Node(data);
      if( head==null){
        head=newnode;
        return;
      }
      Node curr=head;
       newnode.next=curr;
       curr.prev=newnode;
       head=newnode;
    }
    public  void addLast(int data) {
        Node newnode =new Node(data);
        if( head==null){
          head=newnode;
          return;
        }
        Node currnode=head;
        while (currnode.next != null) {
            currnode=currnode.next;
        }
        currnode.next=newnode;
        newnode.prev=currnode;
    }
    public  void print() {
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
        Node curr=head;
        while (curr != null) {
            System.out.print(curr.data+" <-> ");
            curr=curr.next;
        }
        System.out.println("null");
        System.out.println();

    }
    public void deleteFirst(){
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
       head=head.next;
    }
    public void deleteLast(){
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
        Node prev=head;
        Node curr=head.next;
        while (curr.next != null) {
            curr=curr.next;
            prev=prev.next;
        }
        prev.next=null;
    }
    public void reverse(){
        if (head==null || head.next==null ) {
            return;
        }
        Node prev =null;
        Node curr=head;
        while (curr != null) {
            Node next=curr.next;
            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }
        // head.next=null;
        // head.prev=curr;
        head=prev;
    }
    public Node reverseRecursion(Node head){
        if (head==null || head.next==null ) {
            return head;
        }
        
        Node newnode=reverseRecursion(head.next);
        head.next.prev=head.next.next;
        head.next.next=head;
        head.prev=head.next;
        head.next=null;
       return newnode;

    }
    public static void main(String[] args){
     doublyLL n =new doublyLL();
     n.addLast(1);
     n.addLast(2);
     n.addLast(3);
     n.addLast(4);
     n.print();
    
    //  n.reverse();
    // list.head= list.reverseRecursion(list.head);
      n.head= n.reverseRecursion(n.head);
     n.print();


    }
    
}