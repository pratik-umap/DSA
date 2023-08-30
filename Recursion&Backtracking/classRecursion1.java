public class classRecursion1 {
    // class Recursion and backtracking 1
    static void printno(int n){
        if(n==0) return;

        // System.out.println(n);
        printno(n-1);
        System.out.println(n);
    }
    static int sumOfNNo(int n){
        if(n==0)return 0;

        int ans=sumOfNNo(n-1)+n;
        return ans;
    }
    public static int aPowerB(int a,int b) {
        if (b==0) return 1;

        if (b==1) return a;

        int ans=aPowerB(a, b-1)*a;
         return ans;
    }
    public static int factorial(int n) {
        if (n==0) {
            return 1;
        }

        int ans=n*factorial(n-1);
        return ans;
    }
    public static int fibonacci(int n) {
        // 0 1 1 2 3 5 8
       if (n==0 || n==1) {
        return n;
       }
        int a=fibonacci(n-1);
        int b=fibonacci(n-2);
    
        return a+b;
    }
    public static int possiblePath(int n ,int m) {
        if (n==1 || m==1) {
            return 1;
        }

         int right=possiblePath(n, m-1);
         int down=possiblePath(n-1, m);
         return right + down;
    }

    public static boolean isPalindrome(int arr[],int start,int end) {
        if (start > end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        } else {
            isPalindrome(arr, start+1, end-1);
        }
        return true;
    }

    public static int twoRestN(int n) {
        if (n==0) {
            return 1;
        }

        int ans=2*twoRestN(n-1);
        return ans;
    }
    public static int GCD (int a,int b) {
        // System.out.println(a +" "+b);
        if (a < b) {
          return GCD(b, a);
        }
        // Greetest common divisor  large divide no
        if (a==0) {
            return b;
        }
        if (b==0) {
            return a;
        }

        int ans=GCD(a%b, b);
        return ans;
    }
    public static void main(String[] args) {
        
        // printno(5);

        // System.out.println(sumOfNNo(5));

        // System.out.println(aPowerB(2, 6));

        System.out.println(factorial(15));

        //  int n=7;
        // System.out.println(fibonacci(n-1));

        // System.out.println(possiblePath(3, 4));

        // int arr[]={1,2,3};
        // boolean a = isPalindrome(arr, 0, arr.length-1);
        // if (a) {
        //     System.out.println("its a palindrome");
        // } else {
        //     System.out.println("its a not palindrome");
        // }

        // System.out.println(twoRestN(0));

        // System.out.println(GCD(25, 50));
    }
}
