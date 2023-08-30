import java.util.Scanner;

import javax.swing.RowFilter;

public class TwoDArray {
    
    public static void Sum(int [][]arr) {
        for (int i = 0; i < 3; i++) {
            int sum=0;
            for (int j = 0; j < 3; j++) {
               sum += arr[i][j];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }

    public static boolean checkPresent(int [][]arr, int k) {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == k) {
                    return true;
                }
            }
        }
        return false;
    }
     public static int maxRow(int arr[][]) {
         int max=0;
         int roxidx=0;
        for (int i = 0; i < 3; i++) {
            int sum=0;
            for (int j = 0; j < 3; j++) {
                sum += arr[i][j];
            }
            if (max < sum) {
                max=sum;
                roxidx=i;
            }
        }
        System.out.println("greater sum is");
        System.out.println(max);
        System.out.println("row at index");
        return roxidx;
     }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        // int [][] arr={{1,2,3},{4,5,6},{7,8,9}};
      int [][]arr=new int [3][3];
       // taking user input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
               arr[i][j]= sc.nextInt();
            }
        }

         // print output
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] +" ");
            }
           System.out.println();
        }
        // print sum row and column wise
        System.out.println("sum is ");
        Sum(arr);

        // System.out.println("enter the element");
        // int k=sc.nextInt();
        // if (checkPresent(arr, k)) {
        //     System.out.println("element found");
        // }else{
        //      System.out.println("element not found");
        // }

       int p= maxRow(arr);
       System.out.println(p);
    }
}
