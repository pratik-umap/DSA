public class classRecursion2 {
    // class Recursion and backtracking 2
   public static int findSumOfDigitInNo(int n) {
        if ( n==0) {
            return 0;
        }
           
        return (n % 10 + findSumOfDigitInNo(n/10));
    }

    public static void subsequenceOfString(String s,int idx,String ans) {
        if (idx>=s.length()) {
            System.out.println(ans);
            // if (ans.length() > 0) {
            //     System.out.println(ans);
            // }
            return ;
        }
         char ch=s.charAt(idx);
        subsequenceOfString(s, idx+1, ans);
        subsequenceOfString(s, idx+1, ans+ch);
    }
  public static void towerOfHanoi(int n,String start,String helper,String end) {
      if (n==1) {
        System.out.println(" disk " + n + " move from "+start+" to "+ end);
        return ;
      }
     
      towerOfHanoi(n-1, start, end, helper);
      System.out.println(" disk " + n + " move from "+start+" to "+ end);
      towerOfHanoi(n-1, helper, start, end);
  }
  
        public static void permutationOfString(String s,int idx,String permutation) {
            if (s.length()==0) {
                System.out.println(permutation);
                return;
            }

            for (int i = 0; i < s.length(); i++) {
                char element=s.charAt(i);
                String newElement=s.substring(0,i)+s.substring(i+1);
                permutationOfString(newElement, idx+1, permutation+element);
            }

        }
        public static int josephus(int n,int k) {
            if (n==1) {
                return 1;
            }
                
            return (josephus(n-1, k)+k-1) % n+1;
        }
        public static int rodCuttingProblem(int n,int a,int b,int c) {
            if(n == 0)return 0;
            if(n < 0) return -1; 
         
            int cutA=rodCuttingProblem(n-a, a, b, c);
            int cutB=rodCuttingProblem(n-b, a, b, c);
            int cutC=rodCuttingProblem(n-c, a, b, c);
            int ans=Math.max(cutA, Math.max(cutB, cutC));
            if (ans == -1) {
                return -1;
            }
            return ans+1;
        }
        public static boolean subsetSum(int a[],int sum,int n) {
            if (n < 0) return false;
            if(sum==0)return true;

            return subsetSum(a, sum-a[n], n-1) || subsetSum(a, sum, n-1);    
            
        }
public static void main(String[] args) {
   
    // int n=2314;
    // System.out.println(findSumOfDigitInNo(n));

     String s="abc";
    subsequenceOfString(s, 0, "");

    //   towerOfHanoi(3, "S", "H", "E");
    //  
    // String s="abc";
    //   permutationOfString(s, 0, "");

    //  System.out.println(josephus(5, 3));

    // System.out.println(rodCuttingProblem(12, 5, 9, 11));
     int a[]={3,34,4,12,5,2};
     int sum=7;
    System.out.println(subsetSum(a, sum, a.length-1));
    }   
}