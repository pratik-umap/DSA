import java.util.Scanner;

public class recursionCls1 {

    public static void prnNo(int n) {
        if (n == 0) {
            return;
        }

        prnNo(n-1);
        System.out.println(n);
        
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int ans= n * factorial(n-1);
        return ans;
    }
    public static int tworestn(int n) {
        if (n == 0) {
            return 1;
        }
        int ans=2 * tworestn(n-1);
        return ans;
    }
    public static int fibonacci(int n) {
        if (n == 0 || n==1) {
            return n;
        }
        int a=fibonacci(n-1);
        int b=fibonacci(n-2);
        return a + b;
    }
    public static boolean isSorted(int arr[],int idx) {
        if (idx == arr.length-1) {
            return true;
        }
         return  isSorted(arr, idx+1) &  arr[idx] <= arr[idx+1];
        
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
      System.out.println();
        // prnNo(n);
    //    int a= factorial(n);
    //    System.out.println(a);

    // int a= tworestn(n);
    // System.out.println(a);

    int p= fibonacci(n-1);
    System.out.print(p+" ");

    //   int []arr={1,2,8,4,5};
    //   boolean c = isSorted(arr, 0);
    //   System.out.println(c);

    }
}
