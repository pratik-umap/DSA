package classQueue;
public class Queueusearray {
    static class Queue{
         static int arr[];
        static  int size;
        public static int rare=-1;
        Queue(int size){
            arr=new int [size];
            this.size=size;
        }
         public static boolean isEmpty () {
             return rare==-1;
         }
          // enqueue
        public static void add(int data){
          if (rare == size-1) {
              System.out.println("queue full");
              return;
          }
          rare++;
          arr[rare]=data;
        }
        // dequeue
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front=arr[0];

            for (int i = 0; i < rare; i++) {
                arr[i]=arr[i+1];
            }
            rare--;
            return front;
        }
       // peak
       public static int peak() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        return arr[0]; 
       }
    }
    public static void main(String[] args) {
       Queue q=new Queue(5); 

       q.add(1);
       q.add(2);
       q.add(3);
     
       while (! q.isEmpty()) {
           System.out.println(q.peak());
           q.remove();
       }
    }
}
