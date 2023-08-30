public class classBitManipulation {
    
    public static int findIthBit(int n,int i) {
        int mask= 1<<i;
       if ((n & mask)==0) {      
        return 0;
       }
       return 1;
    }
    public static int toggleIthBit(int n,int i) {
        int mask=1<<i;
         return n^mask;
    }
    public static boolean isNoOfPowerTwo(int n) {
         int res=n & n-1;
         return res==0;
    }
    public static int countSetBit(int n) {
        int cnt=0;

        while (n > 0) {
            if ((n&1)==1) {
                cnt++;
            }
              n=n>>1;
        }
        return cnt;
    }
    public static boolean evenOrOdd(int n) {
         int res=n & n-1;
         return res==0;
    }
    public static boolean isEven(int n) {
        if((n ^ 1)==n+1){
            return true;
        }
        return false;
    }
    public static void swapTwoNoWithoutUsingThirdVar(int x,int y) {
        
        x=x^y;
        y=x^y;
        x=x^y;

        System.out.println(x+" "+y);
    }
    public static int setIthBit1(int n,int i) {
         int mask=1<<i;
         return (n | mask);
    }
    public static int unsetIthBit(int n,int i) {
        int mask=1<<i;
        return (n ^ mask);
    }
    public static int  printAllXOR1TON(int n) {
        int res=0;
        for (int i = 1; i <= n; i++) {
            res=res^i;
        }
        return res;
    }
    public static int countofBitChange(int a,int b) {
        return(countSetBit(a^b));
    }
    public static void main(String[] args) {
   
        // System.out.println(findIthBit(3, 2));

        // System.out.println(toggleIthBit(3, 1));

        // System.out.println(isNoOfPowerTwo(36));

        // System.out.println(countSetBit(12));
        //  System.out.println(evenOrOdd(6));
        // System.out.println(isEven(30));
        //   swapTwoNoWithoutUsingThirdVar(50, 37);
        // System.out.println(setIthBit1(10, 2));
        // System.out.println(unsetIthBit(14, 1));
        // System.out.println(printAllXOR1TON(6));
        System.out.println(countofBitChange(14, 15));
    }
}
