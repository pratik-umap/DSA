import java.util.ArrayList;

public class ClassArray2 {
    
    public static void maxSumSubArr(int arr[]) {
        // Maximum sum subarray
        int curr=0;
        int maxSum=Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
             curr+=arr[i];

             if (curr < 0) {
                curr=0;
             }
             
             if (curr > maxSum) {
                maxSum=curr;
             }
        }
        System.out.println(maxSum);
    }
    public static void frequecyOfEachElement(int arr[]) {
        int cnt=1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]) {
                cnt++;
            }else{
                System.out.println("frequency of " + arr[i] + " is  " + cnt);
                cnt=1;
            }
        }
        System.out.println("frequency of " + arr[arr.length-1] + " is  " + cnt);
    }
    public static void longestLengthOf1(int arr[]) {
         int cnt=0;
         int maxCnt=Integer.MIN_VALUE;
       for (int i = 0; i < arr.length-1; i++) {
           if (arr[i]==1) {
              cnt++;
           } else{
              cnt=0;
           }
              if (cnt > maxCnt) {
                maxCnt=cnt;
              }
              
           
       }
        System.out.println("longest length of 1 " +maxCnt );
    }

    public static void moveZeroAtEnd(int arr[]) {
        
        int i=0;
        int j=arr.length-1;

        while (i < j) {
            if (arr[i]==0) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j--;
            }
            i++;
        }

        for (int j2 = 0; j2 < arr.length; j2++) {
            System.out.print(arr[j2] +" ");
        }
    }

    public static void minSumSubArr(int arr[]) {
        // Minimum sum subarray
        int curr=Integer.MAX_VALUE;
        int minSum=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {

            if (curr > 0) {
                curr=arr[i];
            }else{
                curr+=arr[i];
            }
             
             minSum=Math.min(minSum, curr);
        }

        System.out.println(minSum);
    }

    public static void maxSumSubArrPrintelement(int arr[]) {
        // Maximum sum subarray print element
        int curr=0;
        int maxSum=Integer.MIN_VALUE;
         ArrayList<Integer> ans =new ArrayList<>();

        for (int i = 0; i < arr.length-1; i++) {
             curr+=arr[i];
            ans.add(arr[i]);

             if (curr < 0) {
                curr=0;
                ans.removeAll(ans);
             }
             
             if (curr > maxSum) {
                maxSum=curr;
             }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
               System.out.println( "sum is " + maxSum);
    }
    public static void buyAndSell(int arr[]) {
        int minPrice=arr[0];
        int maxProfit=0;

        for (int i = 0; i < arr.length; i++) {
           minPrice=Math.min(minPrice, arr[i]);
           maxProfit=Math.max(maxProfit, arr[i]-minPrice);
        }
        System.out.println(maxProfit);
    }
    public static void main(String[] args) {
        
        // int []arr={6,-7,4,-2,1,5,-4};
        // maxSumSubArr(arr);
        // maxSumSubArrPrintelement(arr);

        // int []arr={2,2,2,3,3,4,4,4,5};
        // frequecyOfEachElement(arr);

        // int arr[]={1,1,1,0,0,1,0,1,1,1,1,0,1};
        // longestLengthOf1(arr);

        // int arr[]={8,0,1,3,0,0,5};
        // moveZeroAtEnd(arr);

        // int []arr={6,-7,4,-2,1,5,-4};
        // minSumSubArr(arr);
       
        int arr[]={5,1,4,8,9};
        buyAndSell(arr);
    }
}
