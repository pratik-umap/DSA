import java.util.*;
public class hashingProblem2 {
    
    public static int nonReapeatingElementOne(int [] a) {
        // Find the only non-repeating element in an array
        // where every other element repeats twice.
        int res=0;
        for (int i : a) {
            res=res ^ i;
        }
        return res;
    }
    public static int[] nonReapeatingElementTwo(int a[]) {
        // Find the two non-repeating elements in an array
        // where every other element repeats twice.
        int xor=0;
        for (int i : a) {
            xor=xor ^ i;
        }
        int temp=xor;
       int mask=xor & (~(xor-1));

       for (int i : a) {
        if ((mask & i)==0) {
            temp=temp ^ i;
        }
       }
       int firstNo=temp;
       int secondNo=xor ^ firstNo;
       int res[]=new int[2];
       res[0]=firstNo;
       res[1]=secondNo;

       return res;
    }
    public static int swapTwoBits(int n,int i,int j) {
        int ith = (n>>i & 1);
        int jth = (n>>j & 1);
         int xor=ith ^ jth;
        if (xor==0) {
            return n;
        }
        int mask=(1<<i) | (1<<j);
       return n ^ mask;
    }
    public static long reverse32BitUInt(long n) {
        long res=0;
        int i=0;
        while (i<=31) {
            if ((n & (1<<i))!=0) 
                res+= (1L<<(31-i));
                i++;
        }
        return res;
    }
    public static int calculateNonRepeatingElement(int []a) {
        // Find the only non-repeating element in an array where every other element repeats
        //   thrice
         int ones=0, twos=0, mask;
         for (int i : a) {
            
            twos = twos | (ones & i);
            ones=ones ^ i;
           
            mask=~(ones&twos);

            ones &= mask;
            twos &= mask;
         }
         return ones;
    }
    public static void main(String[] args) {
        int a[]={1,2,3,2,1,5,5};
    //   System.out.println(nonReapeatingElementOne(a));

        // int arr[]={2,4,1,2,3,7,4,1};
        //    int res[]=nonReapeatingElementTwo(arr);
        //    for (int i : res) {
        //     System.out.println(i);
        //    }
        // System.out.println(swapTwoBits(15, 1, 2));
        // System.out.println(reverse32BitUInt(3));
        int arr[]={1,1,1,2};
       System.out.println(calculateNonRepeatingElement(arr));         
    }
}
