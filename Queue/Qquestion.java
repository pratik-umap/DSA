import java.util.*;

public class Qquestion {

    public static int solve(int []arr,int n,int k) {
      Deque<Integer>max=new LinkedList<>();
      Deque<Integer>min=new LinkedList<>(); 
      
      for (int i = 0; i < k; i++) {
          
        while (!max.isEmpty() && arr[max.peekLast()] >=arr[i]) {
            max.removeLast();
        }
        
        while (!min.isEmpty() && arr[min.peekLast()] <=arr[i]) {
            min.removeLast();
        }
        max.addLast(i);
        min.addLast(i);
      }
      int sum=0;
      for (int i = k; i < arr.length; i++) {
          sum+=arr[max.peekFirst()] + arr[min.peekFirst()];

          while (!max.isEmpty() && max.peekFirst()-i >= k) {
              max.removeFirst();
          }

          while (!min.isEmpty() && min.peekFirst()-i >= k) {
            min.removeFirst();
        }
        while (!max.isEmpty() && arr[max.peekLast()] >=arr[i]) {
            max.removeLast();
        }
        
        while (!min.isEmpty() && arr[min.peekLast()] <=arr[i]) {
            min.removeLast();
        }
        max.addLast(i);
        min.addLast(i);
      }
      sum+=arr[max.peekFirst()] + arr[min.peekFirst()];
      return sum;
    }

    public static void main(String[] args) {
       
     int []arr={2, 5, -1, 7, -3, -1, -2};
     int k=4;
     int n=arr.length;
     
     System.out.println(solve(arr, n, k));


    }
}
