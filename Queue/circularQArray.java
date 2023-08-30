public class circularQArray {
    // circular queue using array
    static class Queue{
        static int arr[];
       static  int size;
        static int rare=-1;
        static int front= -1;
       Queue(int n){
           arr=new int [n];
           this.size=n;
       }
        public static boolean isEmpty () {
            return rare==-1 && front==-1;
        }
        public static boolean isFull() {
            return (rare +1) % size==front;
        }
         // enqueue
       public static void add(int data){
         if (isFull()) {
             System.out.println("queue full");
             return;
         }
         // first element added
         if (front==-1) {
             front=0;
         }
           rare= (rare+1)%size;
         arr[rare]=data;
       }
       // dequeue
       public static int remove() {
           if (isEmpty()) {
               System.out.println("empty queue");
               return -1;
           }
           int result=arr[front];
           // first element
           if (rare == front) {
               rare = front =-1;
           }else{
               front=(front+1)%size;
           }
           return result;
       }
      // peak
      public static int peak() {
       if (isEmpty()) {
           System.out.println("empty queue");
           return -1;
       }
       return arr[front]; 
      }
   }
    public static void main(String[] args) {
        Queue q=new Queue(5); 
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);
        while (! q.isEmpty()) {
            System.out.println(q.peak());
            q.remove();
        } 
    }
}
