import java.util.Arrays;
import java.util.function.IntFunction;

public class recursionCls4 {
    public static void reverse(char arr[], int start, int end) {
        
        if (start > end) {
            return;
        }
         char temp = arr[start];
         arr[start]=arr[end];
         arr[end]=temp;

         reverse(arr, start+1, end-1);
    }
    public static boolean isPalindrome(char arr[],int start,int end) {
        if (start > end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        } else {
            isPalindrome(arr, start+1, end-1);
        }
        return true;
    }
    public static int power(int a, int b) {
        if (b==0) {
            return 1;
        }
        if (b==1) {
            return a;
        }
        int ans=power(a, b/2);
        if (b%2==0) {
            return ans * ans;
        } else {
            return a * ans * ans;
        }
    }
    public static void bubbleSort(int arr1[],int n) {
        if (n==0 || n==1) {
            return;
        }

        for (int i = 0; i < arr1.length-1; i++) {
            if (arr1[i] > arr1[i+1]) {
                int temp=arr1[i];
                arr1[i]=arr1[i+1];
                arr1[i+1]=temp;
            }
        }
       bubbleSort(arr1, n-1);
    }

    public static void main(String[] args) {
        
        // String s="abcde";
        //   char arr[]=s.toCharArray();
    //   reverse(arr, 0, arr.length-1);

    //   for (int i = 0; i < arr.length; i++) {
    //       System.out.print(arr[i]+" ");
    //   }


     boolean a = isPalindrome(arr, 0, arr.length-1);
      if (a) {
          System.out.println("its a palindrome");
      } else {
          System.out.println("its a not palindrome");
      }

        // int p= power(2, 3);
        // System.out.println(p);

        // int arr1[]={2,1,3,4,5};

        // bubbleSort(arr1, arr1.length);
        // for (int i = 0; i < arr1.length; i++) {
        //     System.out.print(arr1[i]+" ");
        // }
        
    }
}
