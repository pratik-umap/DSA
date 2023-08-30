public class classLinkedList1 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
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
    public static Node reverseLLRecursive(Node head) {
        if(head == null || head.next == null) return head;
        Node temp=head.next;
        Node newHead=reverseLLRecursive(head.next);
         temp.next=head;
         head.next=null;
         return newHead;
    }
    public static Node reverseLLInKGroup(Node head,int k) {
        // 4 5 6 7 8
        Node cur=head;
        Node newHead=null, prevfirst=null;
        while (cur != null) {
            int count=0;
            Node prev=null , first=cur;

            while (cur != null && count < k) {
                Node NextNode=cur.next;
                cur.next=prev;
                prev=cur;
                cur=NextNode;
                count++;
            }
         
            if (newHead == null) {
                newHead=prev;
            } else {
                prevfirst.next=prev;
            }
            prevfirst=first;
        }
        return newHead;
    }
    public static Node isCyclePresent(Node head) {
        Node slow=head, fast=head;
   
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public static int cycleStartPt(Node head) {
        Node meet=isCyclePresent(head);
        Node first=head;
        while (meet != first) {
            meet=meet.next;
            first=first.next;
        }
        return meet.data;
    }

    public static void printLL(Node head) {
        Node cur=head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public static Node  rotateLLbyKthNode(Node head,int k) {
        // 4 5 6 7 8 
        Node cur=head;
        int count=1;
        while (cur != null && count < k) {
            cur=cur.next;
            count++;
        }
        Node kthNode=cur;
        while (cur.next != null) {
            cur=cur.next;
        }
        cur.next=head;
        head=kthNode.next;
        kthNode.next=null;

        return head;
    }
    public static void addTwoNOLL(Node first,Node second) {
        first=reverseLL(first);
        second=reverseLL(second);
         int carry=0;
         Node  sum=null;
         
         while (first != null || second != null || carry == 1) {
            int newVal=carry;
            if( first != null)
            newVal+=first.data;

            if( second != null)
            newVal+=second.data;

           carry=newVal/10;
           newVal=newVal%10;

           Node NewNode=new Node(newVal);
           NewNode.next=sum;
           sum=NewNode;

           if( first != null)
           first=first.next;
           if( second != null)
           second=second.next;
         }
         printLL(sum);
    }
    public static Node mergeLLToAnotherLL(Node first, Node Second) {
        Node cur1=first, Next1=first.next;
        Node cur2=Second, Next2=Second.next;
       

        while (cur1.next != null && cur2.next != null) {

            cur1.next=cur2;
            cur2.next=Next1;

            cur1=Next1;
            Next1=Next1.next;
            cur2=Next2;
            Next2=Next2.next;
        }
        cur1.next=cur2;
        cur2.next=null;
        return first;
    }
    public static void main(String[] args) {
        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);

        Node head2=new Node(4);
        head2.next=new Node(5);
        head2.next.next=new Node(6);
        head2.next.next.next=new Node(7);
        head2.next.next.next.next=new Node(8);

        // head.next.next.next=new Node(40);
        // head.next.next.next.next=new Node(50);
        // head.next.next.next.next.next=new Node(60);
        // head.next.next.next.next.next.next=new Node(70);
        // head.next.next.next.next.next.next.next= head.next.next.next;

        // printLL(head1);
    //    Node newHead= reverseLLRecursive(head);
        // printLL(newHead);

        //   Node newHead=reverseLLInKGroup(head2, 3);
        //   printLL(newHead);

        // Node newhead=isCyclePresent(head);
        // if (newhead != null) {
        //     System.out.println("cycle is present");
        //     System.out.println(cycleStartPt(head));
        // } else {
        //     System.out.println("cycle is not present");
        // }
        // Node newNode=rotateLLbyKthNode(head2, 3);
          addTwoNOLL(head1, head2);
    //    Node newHead= mergeLLToAnotherLL(head1, head2);
        // printLL(newNode);



    
        }
}
