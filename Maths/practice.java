
public class practice {
 public static int gcd(int a,int b) {
     
    if (a==0) {
        return b;
    }
    if (b==0) {
        return a;
    }
    while (a != b) {
        if (a > b) {
            a=a-b;
        } else {
            b=b-a;
        }
    }
    return a;
 }
    public static void main(String[] args) {
        
      int a=  gcd(75, 25);
      System.out.println(a);
    }
    // gretest common divisor
}