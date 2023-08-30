package classQueue;
import java.util.*;

public class QueueUsingArray {
    int a[];
    int front,rear;
    int n;
    QueueUsingArray(int n){
        this.n=n;
        a=new int[n];
        front=rear=-1;
    }
    void enqueue(int data){
      if(isFull()){
        System.out.println("queue is full");
        return;
      }
      if (isEmpty()) {
        front=0;
      }
      rear++;
      a[rear]=data;
    }
    int dequeue(){
       if (isEmpty()) {
        System.out.println("queue is empty");
         return -1;
       }
      int ans=a[front];
      for (int i = 0; i < rear; i++) {
        a[i]=a[i+1];
      }
      rear--;
      return ans;
    }

    boolean isFull(){
      return rear==n-1;
    }
    boolean isEmpty(){
     return rear==-1;
    }
    public static void reverseQueue(ArrayDeque<Integer>q) {
        Stack<Integer> s=new Stack<>();
      
      while (!q.isEmpty()) {
        s.push(q.pop());
      }
     
      while (!s.isEmpty()) {
         q.add(s.pop());
      }
      
      while (!q.isEmpty()) {
       System.out.print(q.pop()+" ");
      }
    }
    public static void main(String[] args) {
      ArrayDeque<Integer>q=new ArrayDeque<>();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
      reverseQueue(q);


        // QueueUsingArray q=new QueueUsingArray(3);
        // q.enqueue(1);
        // q.enqueue(2);
        // q.enqueue(3);

        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());
        // System.out.println(q.dequeue());


    }
}
