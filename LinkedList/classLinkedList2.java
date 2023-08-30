public class classLinkedList2 {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static Node mergedTwoSortedLL(Node head1,Node head2){
        Node a=head1 , b=head2;
        Node head=null,tail=null;
        if(a == null) return b;
        if(b == null) return a;

        if(a.data <= b.data){
            head=a;
            tail=a;
            a=a.next;
        }else{
            head=b;
            tail=b;
            b=b.next;
        }
 
         while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next=a;
                tail=a;
                a=a.next;
            }else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
         }
         if(a ==null) tail.next=b;
         if(b==null) tail.next=a;
       return head;
    }
    public static void printLL(Node head) {
        Node cur=head;
        while (cur != null) {
            System.out.print(cur.data+"->");
            cur=cur.next;
        }
        System.out.println();
    }
    public static Node reverseLL(Node head) {   
        Node prev=null;
        Node cur=head;
        while (cur != null) {
            Node NextNode=cur.next;
            cur.next=prev;

            prev=cur;
            cur=NextNode;
        }
       return prev;
    }
    public static Node findMiddleElement(Node head) {
        Node slow=head;
        Node fast=head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(Node head) {
        if (head==null || head.next==null) {
            return true;
        }
        Node mid=findMiddleElement(head);
        Node rev=reverseLL(mid);
         Node left=head,right=rev;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static Node reverseEvenPos(Node head){
        Node even=null, odd=head;
        if (odd ==null || odd.next == null || odd.next.next == null ) {
            return odd;
        }
        while (odd != null && odd.next != null) {
            Node temp=odd.next;
            odd.next=temp.next;
            
            temp.next=even;
            even=temp;
            odd=odd.next;
        }
         odd=head;
         while ( even != null) {
            Node temp=even.next;
            even.next=odd.next;

            odd.next=even;
            even=temp;
            odd=odd.next.next;
         }
         return head;
    }
    public static void main(String[] args) {
        Node head1=new Node(2);
        head1.next=new Node(5);
        head1.next.next=new Node(6);

        Node head2=new Node(1);
        head2.next=new Node(2);
        head2.next.next=new Node(3);
        head2.next.next.next=new Node(4);
        head2.next.next.next.next=new Node(5);

        // Node newHead=mergedTwoSortedLL(head1, head2);
        // printLL(newHead);

        // System.out.println(isPalindrome(head2));

        printLL(head2);
        Node newHead=reverseEvenPos(head2);
        printLL(newHead);
    }
}
