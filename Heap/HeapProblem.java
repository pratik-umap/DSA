 import java.util.*;;
public class HeapProblem {
    
    public static int kthlargestElement(int a[],int k) {
        Queue<Integer>pq=new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.offer(a[i]);
        }

        for (int i = k; i < a.length; i++) {
             if(a[i] > pq.peek()){
                pq.poll();
                pq.offer(a[i]);
             }
        }
        return pq.peek();
    }
    public static int kthsmallestElement(int a[],int k) {
        Queue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.offer(a[i]);
        }

        for (int i = k; i < a.length; i++) {
             if(a[i] < pq.peek()){
                pq.poll();
                pq.offer(a[i]);
             }
        }
        return pq.peek();
    }

    public static int  splitArrayIntoKsubSet(int a[],int k) {
       PriorityQueue<Integer>pq=new PriorityQueue<>();
  
        for (int i = 0; i < k; i++) {
            pq.offer(0);
        }       
        Arrays.sort(a); 
        
        for (int i = a.length-1; i >=0; i--) {
            int val=a[i];
            
            val+=pq.poll();

            pq.offer(val);
        }
        int max=0;
        for (int e : pq) {
            max=Math.max(max, e);
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]={4,6,3,5,1,7,2};
        int k=5;
        // System.out.println(kthsmallestElement(a, k));

        int arr[]={1,4,2,3,7,2,4,5,6,3};
        
        System.out.println(splitArrayIntoKsubSet(arr, 3));
    }
}
