public class RecursionCls3EX {
    public static Boolean isPossible(int arr[],int start, int end,int mid) {
        int studentcount=1;
        int pagesum=0;
        int n=arr.length;
        int m=2;
        for (int i = 0; i < n; i++) {
            if (pagesum + arr[i] <= mid) {
                pagesum +=arr[i];
            } else {
                studentcount++;
                if (studentcount > m || arr[i] > mid) {
                    return false;
                }
                pagesum=arr[i];
            }
        }
        return true;
    }
    public static int printBook(int arr[] , int start , int end) {
          if ( start > end) {
            return -1;
        }
       
        int mid = start + (end - start)/2;
        int ans=0;
       if (isPossible(arr , start , end , mid)){
           printBook(arr, start, mid-1);
           ans=mid;
       } else {
         return  printBook(arr, mid+1, end);
       }
       return ans;
    }
    public static void main(String[] args) {
        int arr []={10,20,30,40};
      
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }

        int a=printBook(arr, 0, sum);
       System.out.println(a);
    }
}
