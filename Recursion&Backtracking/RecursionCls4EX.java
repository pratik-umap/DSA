import java.util.ArrayList;

public class RecursionCls4EX {
    public static void selectionSort(int arr[], int smallest) {
        if ( smallest == arr.length-1 ) {
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
             smallest=i;
                if (arr[smallest] > arr[i+1]) {
                    smallest=i+1;
           
                }
                int temp=arr[smallest];
                arr[smallest]=arr[i];
                arr[i]=temp;
            
        }
        selectionSort(arr, smallest+1);
    }
    public static void InsertionSort(int arr[] ,int s) {
        if (s == arr.length) {
            return;
        }
        int j=s-1;
        int current=arr[s];
        while (j>=0 && arr[j] > current) {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=current;
       InsertionSort(arr, s+1);
    }
    public static void reverse(char arr1[], int n) {
        
        if (n == (arr1.length-1)/2) {
            return;
        }
        for ( int i = 0; i < n/2; i++) {
            char temp=arr1[i];
            arr1[i]=arr1[n-i];
            arr1[n-i]=temp;
        }
        // reverse(arr1, n-1);
    }
    public static boolean isPalindrome(char arr1[], int n) {
        if (n == (arr1.length-1)/2) {
            return true;
        }
          for (int i = 0; i < n/2; i++) {
              if (arr1[i] != arr1[n-i] ) {
                  return false;
              }
            
          }
          return true;
    }
     public static void main(String[] args) {
        // int arr[]={5,2,1,9,8};
      
        // InsertionSort(arr,1);
        // selectionSort(arr, 0);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }
        


          String s="abcba";
          char arr1[]=s.toCharArray();

        //    reverse(arr1, arr1.length-1);
           
    //   for (int i = 0; i < arr1.length; i++) {
    //       System.out.print(arr1[i]+" ");
    //   }
       if (isPalindrome(arr1, arr1.length-1)) {
           System.out.println("its a palindrome");
       } else {
           System.out.println("its a not palindrome");
       }
    }
}
