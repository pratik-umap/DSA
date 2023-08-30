
public class recursionCls3 {
 public static boolean isSorted(int arr[],int start) {
     
    if (start == arr.length-1) {
        return true;
    }

    if (arr[start] <= arr[start+1]) {
       return isSorted(arr, start+1);
    }else{
       return false;
    }
 }

 public static int printSum(int arr[],int start,int sum) {
     if (arr.length == start) {
         return sum;
     }
     int remainingPart=printSum(arr, start+1, sum);
     return sum = arr[start] + remainingPart;
 }

 public static boolean linearsearch(int arr[],int start,int k) {
    if (start == arr.length) {
        return false ;
    } 

    if (arr[start] == k) {
        return true;
    } else {
        Boolean a=linearsearch(arr, start+1, k);
        return a;
    }
 }

 public static boolean binarySearch(int arr[],int s,int e,int k) {
    
     if (s > e) {
        return false; 
     }
     int mid = s + (e - s)/2;

     if (arr[mid]== k) {
        return true;
    }
     if (arr[mid] < k) {
        return  binarySearch(arr, mid+1, e, k);
     } else {
        return  binarySearch(arr, s, mid-1, k);
     }

 }
    public static void main(String[] args) {
        int []arr={2,4,6,8,10};

    //  boolean a=isSorted(arr, 0);
    //  System.out.println(a);

    // int a=printSum(arr, 0, 0);
    // System.out.println(a);

    //   boolean a=linearsearch(arr,0,10);
    //   System.out.println(a);

      boolean a=binarySearch(arr,0,arr.length-1,7);
      System.out.println(a);

    }
}