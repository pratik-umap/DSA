import java.util.Arrays;

public class classMaths1 {
    public static boolean isPrime(int n){
          if(n==1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
public static boolean isPrimeEfficient(int n) {
    if (n==1)return false; 
        
    for (int i = 2; i*i <=n ; i++) {
        if (n % i==0) {
            return false;
        }
    }
    return true;
}
public static boolean isPrimeMoreEfficient(int n) {
    if(n==1)return false;
    if(n==2 || n==3)return true;
    if(n%2==0 || n%3==0) return false;

    for (int i = 5; i*i <= n; i+=6) {
        if (n % i==0 || n  % (i+2)==0) {
            return false;
        }
    }
    return true;
}
public static void printAllDivisorOfN(int n) {
    
    for (int i = 2; i<= n; i++) {
        if (n % i ==0) {
            System.out.println(i);
        }
    }
}
public static void sieveOfEratosthenes(int n) {
    boolean isPrime[]=new boolean[n+1];
     Arrays.fill(isPrime, true);

     for (int i = 2; i*i <= n; i++) {
        if (isPrime[i]) {
            for (int j = 2*i; j <=n; j+=i) {
                isPrime[j]=false;
            }
        }
     }

     for (int i = 2; i <= n; i++) {
        if(isPrime[i]) System.out.println(i);
     }
}
public static int aPowerB(int a,int b) {
    if(b==0) return 1;
 
    int half=aPowerB(a, b/2);
    int full=half*half;
    if (b % 2 != 0) return full *a;
    
    return full;
}
public static void printAllPrimeFactor(int n) {
    
    while (n%2==0) {
        System.out.print(2+" ");
        n/=2;
    }

    for (int i = 3; i*i <= n; i+=2) {
        while (n%i==0) {
            System.out.print(i +" ");
            n/=i;
        }
    }
    if (n > 2) {
        System.out.print(n);
    }
}
    public static void main(String[] args) {
        
        // System.out.println(isPrime(5));
        // System.out.println(isPrimeEfficient(17));
        // System.out.println(isPrimeMoreEfficient(31));

        // printAllDivisorOfN(12);
        // sieveOfEratosthenes(30);
        // System.out.println(aPowerB(3, 5));
        printAllPrimeFactor(12);
    }
}
