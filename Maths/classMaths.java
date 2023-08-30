public class classMaths {
    public static boolean isPalindrome(int n) {
        int temp=n;
        int rev=0;
        while (temp > 0) {
            int ld=temp % 10;
            rev=rev * 10 +ld;
            temp/=10;
        }
         return n==rev;
    }

    public static int gcd(int a,int b) {
        // System.out.println(a +" "+b);
        if (a < b) return gcd(b, a);
        if(a==0) return b;
        if(b==0)return a;
       
        int ans=gcd(a%b, b);
        return ans;
    }
  public static int LCM(int a,int b) {
    // lowest common factor
    // lowest value present in both value
    // 24 48 72
    // 36 72 
     int mul=a*b;
      int ans= mul / gcd(a, b); 
      
      return ans;
  }
  public static int trailingZero(int n) {
    // trailing zero in factorial
    // trailing means how many zero in last
    int res=0;
      while ( n > 0) {
        // System.out.println(n+" ");
        res+=n/5;
        n/=5;
      }
      return res;
  }
  public static int UniquePath(int m,int n) {
    int res=1;
    for (int i = 1; i < n; i++) {
        res=res*(m+i)/i;
    }
    return res;
  }
    public static void main(String[] args) {
        // int n=121;
        // System.out.println(isPalindrome(n));

        // System.out.println(gcd(24, 36));

        // System.out.println(LCM(5, 15));

        // System.out.println(trailingZero(15));

        // System.out.println(UniquePath(2, 2));
       
    }
}
