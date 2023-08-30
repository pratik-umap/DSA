package DP;
import java.util.*;

public class DpProblems2 {
    public static int LIS(int a[]) {
        int n=a.length;
        int dp[]=new int[n];
        // Arrays.fill(dp, 1);
        dp[0]=1;

        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max=0;
        for (int i : dp) {
            // System.out.print(i+" ");
            max=Math.max(max, i);
        }
        return max;
    }
    public static int MaxSumLIS(int a[]) {
        int n=a.length;
        int dp[]=new int[n];
        // Arrays.fill(dp, 1);
        dp[0]=a[0];


        for (int i = 0; i < n; i++) {
            dp[i]=a[i];
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i]=Math.max(dp[i], dp[j]+a[i]);
                }
            }
        }
        int max=0;
        for (int i : dp) {
            // System.out.print(i+" ");
            max=Math.max(max, i);
        }
        return max; 
    }     
    public static int MaxNoOfNonOverlappingBridges(Integer a[][]) {
        
        Arrays.sort(a , new Comparator<Integer[]>() {
            public  int compare(Integer a[],Integer b[]){
                if (a[0]==b[0]) {
                    return a[1]-b[1];
                } else {
                    return a[0]-b[0];
                }
            }
        });

        int n=a.length;
        int dp[]=new int[n];
        for (int i = 0; i < n; i++) {
            dp[i]=a[i][1];
        }

        return LIS(dp);
    }
    public static int matrixChainMultiplicationProblem(int a[]) {
        int n=a.length;
        int dp[][]=new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int row = 0, col=len; row < n-len; row++,col++) {
                dp[row][col]=Integer.MAX_VALUE;
                for (int k = row+1; k < col; k++) {
                    dp[row][col]=Math.min(dp[row][col], dp[row][k]+dp[k][col]+a[row]*a[k]*a[col]);
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

       return dp[0][n-1];
    }
    public static void main(String[] args) {
       
        // int a[]={2,7,3,1,4,2,5,9,6};

        // System.out.println(LIS(a));

        // int a[]={10,3,30,2,5,6};
        // System.out.println(MaxSumLIS(a));

        // Integer a[][]={
        //    {0,2},{1,1},{2,7},{3,4},{4,5},{5,8},{6,7},{2,6}
        // };

        // System.out.println(MaxNoOfNonOverlappingBridges(a));

        int a[]={3,2,4,6,1};

        System.out.println(matrixChainMultiplicationProblem(a));

    }
}
