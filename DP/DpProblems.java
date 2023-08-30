package DP;
import java.util.*;
public class DpProblems {
     
    public static int lcsDP(String a,String b) {
        
        int m=a.length();
        int n=b.length();
        int dp[][]=new int[m+1][n+1];
        // for (int i = 0; i <= m; i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // int ans= lcsRecursive(a, b, m, n,dp);
         int ans=lcsIterative(a, b, m, n, dp);

         for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
         }
       return ans;

    }
    public static int lcsRecursive(String a,String b,int m,int n,int dp[][]) {
    // memoization recursive
        if (m==0 || n==0) {
            return 0;
        }
        if (dp[m][n] != -1) return dp[m][n];
        
        if (a.charAt(m-1)==b.charAt(n-1)) {
            return dp[m][n]= lcsRecursive(a, b, m-1, n-1,dp) + 1;
        }else{
            return dp[m][n] = Math.max(lcsRecursive(a, b, m-1, n,dp), lcsRecursive(a, b, m, n-1,dp));
        }
    }
    public static int lcsIterative(String a,String b,int m,int n,int dp[][]) {
        // tabular method
        //   find that character        
        // char []arr=new char[2];
        //  int k=0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    // arr[k++]=a.charAt(i-1);
                }else{
                     dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // for (char c : arr) {
        //     System.out.print(c+" ");
        // }
      return dp[m][n];
    }
    public static int lcsSpaceOptimise(String a,String b,int m,int n) {
        // 2d Array to 1D Array
        int first[]=new int[n+1];
       int second[]=new int[n+1];

       for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
             if (a.charAt(i-1)==b.charAt(j-1)) {
                second[j]=first[j-1]+1;
             }else{
                second[j]=Math.max(first[j],second[j-1]);
             }
         }
         for (int j = 0; j <= n; j++) {
            first[j]=second[j];
         }
         Arrays.fill(second, 0);
       }
    //    for (int i : first) {
    //     System.out.print(i+" ");
    //    }
    //    System.out.println();
    //    for (int i : second) {
    //     System.out.print(i+" ");
    //    }
    //    System.out.println();
       return first[n];
    }
    public static int  minimumInsertAndDeleteToconvertS1ToS2(String a,String b) {
        // minimum Insertion and Deletion to convert a to b
        int m=a.length();
        int n=b.length();
        int ans=lcsSpaceOptimise(a, b, m, n);

        return (m-ans)+(n-ans);
    }
    public static int longestPalindromicSubsequence(String a) {
        StringBuilder b=new StringBuilder();
        for (int i = a.length()-1; i >= 0; i--) {
            b.append(a.charAt(i));
        }
         int m=a.length();
        return lcsSpaceOptimise(a, b.toString(), m, m);
    }
    public static void main(String[] args) {
        // longest common subsequence
        String a="adepnr";
        String b="bdcelp";
        // System.out.println(lcsDP(a, b));
        // System.out.println(lcsSpaceOptimise(a, b, a.length(), b.length()));

        // System.out.println(minimumInsertAndDeleteToconvertS1ToS2(a, b));
        String s="astpuvqacrntqvtpmna";
        System.out.println(longestPalindromicSubsequence(s));
    }
}
