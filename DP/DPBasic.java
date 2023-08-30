package DP;
import java.util.*;
public class DPBasic{
     static int fib(int n){
        // 0 1 1 2 3 5 8
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
   
        fibDp(n, dp);

       return dp[n];
     }
     static int fibDp(int n,int dp[]){
        if(n < 0) return 0;
      if(dp[n] != -1) return dp[n];
       
      return dp[n]= fibDp(n-1, dp)+fibDp(n-2, dp);
     }
     public static int coinChange(int []price,int n) {
         int dp[]=new int[n+1];
         Arrays.fill(dp, -1);
         dp[0]=0;

            coinChangeDP(price, n, dp);
              for (int i : dp) {
                System.out.print(i+" ");
              }
              System.out.println();
            return dp[n];
     }
     public static int coinChangeDP(int price[],int n,int dp[]) {
        if(n < 0)return 1000;
        if(dp[n] != -1)return dp[n];

           int min=Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            min=Math.min(min, coinChangeDP(price, n-price[i], dp));
        }
        return dp[n]=min+1;
     }
     public static int rodCutting(int rate[],int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
    
        rodCuttingDP(rate, n, dp);
        return dp[n];
     }
     public static int rodCuttingDP(int rate[],int n,int dp[]) {
        if(n < 0)return 0;
        if(dp[n] != -1)return dp[n];

           int profit=0;
        for (int i = 0; i < rate.length; i++) {
            profit=Math.max(profit,rate[i] + rodCuttingDP(rate, n-i-1, dp));
        }
        return dp[n]=profit;
     }
    public static void main(String[] args){
    //    int n=6;
    //    System.out.println(fib(n));

    //   int price[]={8,5,1};
    //   int n=10;
    //   System.out.println(coinChange(price, n));

     int rate[]={2,5,7,6,8};
     int n=5;
     System.out.println(rodCutting(rate, n));

    }
}