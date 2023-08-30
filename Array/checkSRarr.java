 public class checkSRarr {
    public static void checkSorted(int arr[]) {
      int n=arr.length;
      int count=0;
       for (int i = 1; i < n; i++) {
           if (arr[i-1] > arr[i]) {
               count++;
           }
       }
        if (arr[n-1] > arr[0]) {
            count++;
        }
        
        if (count <=1) {
            System.out.println("true");
        }else{
        System.out.println("false");
        }
    }


    public static void main(String[] args) {
        int arr[]={1,1,1};   
       
        checkSorted(arr);


    }
}
