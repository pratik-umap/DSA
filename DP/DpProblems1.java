package DP;
import java.util.*;
public class DpProblems1 {
    static int editDistance(String a,String b){

        int m=a.length();
        int n=b.length();

        int dp[][]=new int[m+1][n+1];
        // for (int i = 0; i <= m; i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // return editDistanceRecusive(a, b, m, n,dp);
        return editDistanceIteration(a, b, m, n, dp);
    }
    public static int editDistanceRecusive (String a,String b,int m,int n,int dp[][]) {
        if(m==0) return n;
        if(n==0) return m;

          if(dp[m][n]!= -1)return dp[m][n];

        if (a.charAt(m-1)==b.charAt(n-1)) {
            return dp[m][n] =editDistanceRecusive(a, b, m-1, n-1,dp);
        }else{
           return dp[m][n]=Math.min(Math.min(editDistanceRecusive(a, b, m-1, n,dp), editDistanceRecusive(a, b, m, n-1,dp)),editDistanceRecusive(a, b, m-1, n-1,dp))+1;
        }
    }
    public static int editDistanceIteration(String a,String b,int m,int n,int dp[][]) {
        for (int i = 0; i <=n; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <=m; i++) {
            dp[i][0]=i;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[m][n];
    }
    
    static long countWays(int m){
        // Count number of ways to cover a distance
        if(m==1)return 1;
        
        long dp[]=new long[m+1];
        
         return solve(m,dp);
    }
    static long solve(int m,long dp[]){
        if(m<0)return 0;
        if(m==0)return 1;
        
        if(dp[m]!=0)return dp[m];
        
        dp[m]=solve(m-1,dp)+solve(m-2,dp)+solve(m-3,dp);
        
        return dp[m];
    }
    static int minJumps(int[] arr){
        int n=arr.length;
 
         if(n==1 && arr[0]==0)return 0;
         
        int dp[]=new int [n];
 
        for(int i=1;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(i <= j+arr[j] && dp[j] != Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                    break;
                }
            }
        }
     //   for(int e:dp){
     //       System.out.print(e+" ");
     //   }
        return dp[n-1]==Integer.MAX_VALUE ? -1: dp[n-1];
     }
    
    public static void main(String[] args) {
        String a="cat";
        String b="cut";
        // System.out.println(editDistance(a, b));
        int m=5;
        // System.out.println(countWays( m));
        
        int arr[]={3,2,4,1,3,5,1,1,2};

        System.out.println(minimumJump(arr));
    }
}






