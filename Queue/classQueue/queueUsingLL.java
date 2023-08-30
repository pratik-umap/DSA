package classQueue;
public class queueUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }        
    }
    Node front=null,rear=null;
    void enqueue(int data){
      Node newNode=new Node(data);
      if (isEmpty()) {
        front=rear=newNode;
        return;
      }
      rear.next=newNode;
      rear=newNode;
    }

    int dequeue(){
        if (isEmpty()) {
            return -1;
        }
      int ans=front.data;
      front=front.next;
      return ans;
    }

    boolean isEmpty(){
       return front==null;
    }
    public static void main(String[] args) {
        queueUsingLL q= new queueUsingLL();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
    
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    
    
    }
}
