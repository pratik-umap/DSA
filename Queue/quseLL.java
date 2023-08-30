import java.util.*;

public  class quseLL {
        static class node{
        int data;
        node next;
        node(int data){
          this.data=data;
          next=null;
         }
        }
        static class Queue{
            static node head=null;
            static node tail=null;
             public static boolean isEmpty() {
             return head == null && tail==null;
            }
            public static void add(int data) {
             node newnode=new node(data);
              if (tail == null) {
                tail=head=newnode;
                return;
             }
             tail.next=newnode;
             tail=newnode;
            }
            public static int remove() {
              if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
              }
              int front=head.data;
              // first element
              if (head == tail) {
               tail=null;
              }
              head=head.next;
              return front;
             }
             public static int peak() {
               if (isEmpty()) {
               System.out.println("empty queue");
                return -1;
             }  
               return head.data;
        }
     }

    // queue using linked list
    public static void main(String[] args) {
        // Queue  q=new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // while (! q.isEmpty()) {
        //     System.out.println(q.peak());
        //     q.remove();
        // }

        // collection framework
        // Queue <Integer> q =new LinkedList<>();
        Queue <Integer> q =new ArrayDeque<>();
          q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while (! q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
