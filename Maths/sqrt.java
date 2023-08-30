import java.util.Scanner;

public class sqrt {

    public static int printSqrt(int n) {
        int s=0;
        int e=n;
        int mid= s + (e - s)/2;
        int ans=-1;

        while (s <= e) {
            int sqt= mid*mid;

            if (sqt == n) {
                return mid;
            }
            if (sqt > n) {
                e= mid-1;
            } else {
                ans =mid;
             s=mid+1;   
            }
            mid= s + (e - s)/2;
        }
        return ans;
    }

    public static double morePre(int n,int precision,int a) {
        double factor= 1;
        double ans=a;
        for (int i = 0; i < precision ; i++) {
            factor=factor/10;
            for (double j = ans; j*j <n ; j= j+factor) {
                ans =j;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
     int a=printSqrt(n);
    //  System.out.println(a);
        
      System.out.println(morePre(n, 2, a));
      
    }
}