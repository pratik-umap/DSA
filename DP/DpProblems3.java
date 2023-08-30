import java.util.Arrays;

public class DpProblems3 {
    public static int palindromicPartition(char a[]) {
        // minimum no of cut such that all  substring are palindrome
        
        int n=a.length;
        int dp[][]=new int[n][n];

        for (int len = 1; len < dp.length; len++) {
            for (int row = 0,col=len; row < n-len; row++,col++) {
                if (palindrome(a, row, col)) {
                    dp[row][col]=0;
                } else {
                    dp[row][col]=Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        dp[row][col]=Math.min(dp[row][col],dp[row][k]+dp[k+1][col]+1);
                    }
                }
            }
        }
        //  for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp.length; j++) {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        //  }
        return dp[0][n-1];
    }
    public static boolean palindrome(char a[],int i,int j) {
        while (i<j) {
           if (a[i] != a[j]) {
            return false;
           } 
           i++;j--;
        }
        return true;
    }
    public static int optimalStrategy(int a[]) {
        int n=a.length;
        int dp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        optimalStrategy(a, 0, n-1,dp);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][n-1];
    }
    public static int optimalStrategy(int a[],int i,int j,int dp[][]) {
        // get max coin from array
        if(i+1==j) return dp[i][j]= Math.max(a[i], a[j]);
         
        if(dp[i][j] != -1)return dp[i][j];

        int left = a[i] + Math.min(optimalStrategy(a, i+2, j, dp), optimalStrategy(a, i+1, j-1, dp));
        int right =a[j] + Math.min(optimalStrategy(a, i+1, j-1, dp), optimalStrategy(a, i, j-2, dp));

        return dp[i][j]= Math.max(left, right);
    }
    public static int optimalStrategyIterative(int a[]) {
        int n=a.length;
        int dp[][]=new int[n][n];

        for (int len = 1; len < n; len+=2) {
            for (int row = 0, col = len; row < n-len; row++, col++) {
 
               int  x = ((row + 2) <= col) ? dp[row + 2][col] : 0;
               int  y = ((row + 1) <= (col - 1)) ? dp[row + 1][col - 1] : 0;
               int z = (row <= (col - 2)) ? dp[row][col - 2] : 0;
 
                dp[row][col] = Math.max(a[row] + Math.min(x, y),a[col] + Math.min(y, z));
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
        // String a="abacc";
        // System.out.println(palindromicPartition(a.toCharArray()));

        int a[]={10,2,100,2};
        // System.out.println(optimalStrategy(a));
        System.out.println(optimalStrategyIterative(a));
    }
}
