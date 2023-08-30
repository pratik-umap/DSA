package classQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class queueProblem {
    public static Queue<Integer> reverseFirstKElement(Queue<Integer>q,int k) {
        ArrayDeque<Integer>stack=new ArrayDeque<>();
       int n=q.size();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        for (int i = 0; i <n-k ; i++) {
            q.add(q.poll());
        }
        return q;
    }
    public static int circularTourProblem(int[]petrol,int []distance) {
        int start=0,deficit=0,capacity=0;
        for (int i = 0; i < petrol.length; i++) {
            capacity+=(petrol[i]-distance[i]);
           
            if (capacity < 0) {
                deficit+=capacity;
                start=i+1;
                capacity=0;
            }
        }
           
        return capacity+deficit>=0 ? start:-1;
    }
    public static void maxElementInKWindow(int arr[],int k) {
        Deque<Integer>q=new ArrayDeque<>();
        int i;
        for ( i = 0; i < k; i++) {
            while (!q.isEmpty() && arr[i]>=arr[q.peekLast()]) 
                q.removeLast();
            
            q.addLast(i);
        }
        System.out.print(arr[q.peek()]+" ");

        for ( ; i < arr.length; i++) {
             while (!q.isEmpty() && q.peek() <= i-k) 
                q.removeFirst();
             
            while (!q.isEmpty() && arr[i]>=arr[q.peekLast()]) 
                q.removeLast();
            
            q.addLast(i);

            System.out.print(arr[q.peek()]+" ");
        }
    }
    public static void main(String[] args) {
        Queue<Integer>q=new ArrayDeque<>();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.add(6);

    //  System.out.println(reverseFirstKElement(q, 4));

     int []petrol={5,8,2,10};
      int[]distance={3,10,5,6};

    //   System.out.println(circularTourProblem(petrol, distance));
    int arr[]={1,3,5,2,1,4,5,3,1,2,4};
    int k=3;
     maxElementInKWindow(arr, k);
    }
}
