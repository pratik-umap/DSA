import java.util.Scanner;

public class recursionCls2 {
   public static void towerofHanoi(int n,String start,String helper,String end) {
       if (n == 1) {
        System.out.println(" Disk "+ n +" move from "+ start + " to "+ end);
        return;
       }
    towerofHanoi(n-1, start, end, helper);
    System.out.println(" Disk "+ n +" move from "+ start + " to "+ end);

    towerofHanoi(n-1, helper, start, end);
   }
   public static void reachHome(int src,int dest) {
       if (src == dest) {
           System.out.println("reach home");
           return;
       }
      
       System.out.println(" starting from "+ src + " to " + dest);
       reachHome(src+1, dest);
   }
   public static int reachStairs(int n) {
       if (n == 0) {
           return 1;
       }
       if (n < 0) {
          return 0; 
       }
        
        int ans = reachStairs(n-1) + reachStairs(n-2);
        return ans;
   }
   public static void sayDigit(String arr[], int n) {
       if (n==0) {
           return ;
       }
     int digit= n % 10;
      n= n / 10;
       sayDigit(arr, n);
      System.out.print(arr[digit] +" ");

   }
    public static void main(String[] args) {
       
    // int n=3;
    // towerofHanoi(n, "S", "H", "E");

    //  reachHome(1, 10);
    //  Scanner sc=new Scanner(System.in);
    //    int n=sc.nextInt();

    //   int a=reachStairs(n);
    //   System.out.println(a);

      String [] arr ={"zero","one","two","three","four","five","six","seven","eight","nine"};
       sayDigit(arr, 52);
    }
}
