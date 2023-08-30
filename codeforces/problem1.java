//  package codeforces;
// import java.util.*;
// public class problem1 {
//     public static boolean checkExp(char c){
//         if(c=='+') return true;
         
//          return false;
//     }
//     public static void solve(String s){
//         int sum=0;
//         char a[]=s.toCharArray();
//         for(int i=0;i<a.length;i++){
//             if(!checkExp(a[i])){
//                 sum+= (a[i]-'0');
//             }
//         }
//         System.out.println(sum);
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         String arr[]=new String[n];
//         for(int i=0;i<n;i++){
//             arr[i]=sc.next();
//         }

//         for(int i=0;i<n;i++){
//             solve(arr[i]);
//         }
//     }
    
// }

package codeforces;
import java.util.*;
public class problem1 {
    public static void Transpose(int [][]a){
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a[i].length;j++){
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
    }
    public static void rotate(int[][] a) {
        Transpose(a);

        int n=a.length;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<n/2;j++){
                int temp=a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1]=temp;
            }
        }
    }
    public static String solve(int a[][]){
         int cnt=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if((a[0][0] < a[0][1] && a[1][0] < a[1][1]) && (a[0][0] < a[1][0] && a[0][1] < a[1][1])){
                   return "Yes";
                }
                cnt++;
            }
           rotate(a);
        }
        return "No";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int a[][]=new int[2][2];

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    a[i][j]=sc.nextInt();
                }
            }
           System.out.println(solve(a));

         }
    }
}





