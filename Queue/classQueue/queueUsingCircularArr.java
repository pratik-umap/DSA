package classQueue;
public class queueUsingCircularArr {
    
    int a[];
    int front,rear;
    int n;
    queueUsingCircularArr(int n){
        this.n=n;
        a=new int[n];
        front=rear=-1;
    }
   
    void enqueue(int data){
      if (isFull()) {
        System.out.println("queue is full");
        return;
      }
      if (isEmpty()) {
        front=0;
      }
      rear=(rear+1)%n;
      a[rear]=data;
    }
    int dequeue(){
      if (isEmpty()) {
        System.out.println("queue is empty");
        return -1;
      }
      if (front==rear) {
        int ans=a[front];
        front=rear=-1;
        return ans;
      }
      int ans=a[front];
      front=(front+1)%n;
      return ans;
    }

    boolean isFull(){
     return (rear+1)%n==front;
    }
    boolean isEmpty(){
     return front==-1;
    }

    public static void main(String[] args) {
        queueUsingCircularArr q=new queueUsingCircularArr(3);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        // q.enqueue(4);

        System.err.println(q.dequeue());
        System.err.println(q.dequeue());
        q.enqueue(5);
        System.err.println(q.dequeue());
        System.err.println(q.dequeue());


    }
}
