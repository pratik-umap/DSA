import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClassArray3 {

     public static boolean subArrayWithZeroSum(int arr[]) {
        
        Set <Integer>set=new HashSet<>();
         int sum=0;
         for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
         }
      return false;
     }
  
     public static void printMatrix(int a[][]) {
        int n=a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
     }
     static void transposeMatrix(int a[][]){
      int n=a.length;
        System.out.println("transpoze Matrix");
         for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int swap=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=swap;
            }
         }     
     }
     public static void move90DegreeMatrix(int a[][]) {
        int n=a.length;
        transposeMatrix(a);
       
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < n/2; j++) {
                int swap=a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1]=swap;
            }
        }
     }
     public static boolean searchInArray(int a[][],int key) { 
        int row=0;
        int col=a.length-1;

          while (row < a.length && col >=0) {
            if (a[row][col]==key) {
                return true;
            }else if (key > a[row][col]) {
                row++;
            } else {
                col--;
            }
          }
                
           return false;
     }

     public static boolean splitArrayInThreeEqualSum(int arr[]) {
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }

        if (sum%3!=0) {
            return false;
        }
        int k=sum/3;
        sum=0;
        int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (sum==k) {
                cnt++;
                sum=0;
            }
        }
     return cnt>= 3?true:false;
     }

     public static int largestSubArrayWithEqualNoOf1And2(int arr[]) {
        int n=arr.length;
           int prefixSum[]=new int[n];
           prefixSum[0]= arr[0] == 0 ? -1:1;

           for (int i = 1; i < n; i++) {
                prefixSum[i]= arr[i]==0 ? prefixSum[i-1]-1 : prefixSum[i-1]+1;
           }

           Map<Integer,Integer>map=new HashMap<>();
           int ans=0;
           for (int j = 0; j < n; j++) {
            if (map.containsKey(prefixSum[j])) {
                ans=Math.max(ans, j-map.get(prefixSum[j]));
            } else {
               map.put(prefixSum[j], j);
            }
           }
          return ans;
     }
     public static int majorityElement(int arr[]) {
        // find the element which appear more than n/2 times
        // moore's voting algo
        int curElement=0;
        int count=0;

        for (int i = 0; i < arr.length; i++) {
             if (count == 0) {
                curElement=arr[i];
                count=1;
             } else {
                if (arr[i]==curElement) {
                    count++;
                } else {
                    count--;
                }
             }
        }
        int finalcount=0;
        for (int i : arr) {
           if (curElement==i) {
            finalcount++;
           }   
        }
         int ans= finalcount > arr.length / 2 ? curElement : -1;
         return ans;
     }
     static void rotateArrayBy1step(int arr[]){
         int n=arr.length;
        int firstElement=arr[0];
        for (int i = 0; i < n-1; i++) {
            arr[i]=arr[i+1];
        }
        arr[n-1]=firstElement;

        for (int i : arr) {
            System.out.print(i+" ");
        }
     }

     public static void reverseArray(int arr[],int start,int end) {
         
        while (start < end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
     }
     public static void rotateArrayByKStep(int arr[],int k) {
        int n=arr.length-1;

    
            reverseArray(arr, 0, k-1);
            
            
            reverseArray(arr, k, n);
         

            reverseArray(arr, 0, n);


         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
         }
     }
    public static void main(String[] args) {
        
        // int arr[]={2,3,1,4,3,-2};
  
        // System.out.println(subArrayWithZeroSum(arr));

        int a[][]={
                 {1,2,3},
                 {4,5,6},
                 {7,8,9}
                 };
                  int key=10;
                //  System.out.println(searchInArray(a,key ));
            // printMatrix(a);   
            // transposeMatrix(a); 
            // printMatrix(a); 
            // move90DegreeMatrix(a);
            // printMatrix(a);

            // int arr[]={1,3,4,0,4};
            //  System.out.println(splitArrayInThreeEqualSum(arr));

        //     int arr[]={0,0,1,1,0,0,1,1,0};
        //   int ans=  largestSubArrayWithEqualNoOf1And2(arr);
        //     System.out.println(ans);

            // int arr[]={3,2,2,1,2,2};
            // System.out.println(majorityElement(arr));

            int arr[]={6,1,2,4,3,5};
            // rotateArrayBy1step(arr);
            rotateArrayByKStep(arr, 2);
    }
}