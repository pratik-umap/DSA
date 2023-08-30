public class quickSort {
     public static int partition(int arr[],int low,int high) {
         int pivot=arr[high];
         int i= low-1;
         for (int j = low; j < high; j++) {
             if (arr[j] < pivot) {
                 i++;
                //  System.out.println(arr[i]+" andar before swapp "+arr[j]);
                 int temp=arr[i];
                 arr[i]=arr[j];
                 arr[j]=temp;
                //  System.out.println(arr[i]+" andar after swapp "+arr[j]);

             }
         }
         i++;
        //  System.out.println(arr[i]+" bahar before swapp "+pivot);
         int temp=arr[i];
         arr[i]=pivot;
         arr[high]=temp;
        //  System.out.println(arr[i]+" bahar after swapp "+arr[high]);
         return i;
     }
    public static void QuickSort(int arr[], int low, int high) {
        if ( low < high) {
            int pidx=partition(arr,low,high);

            QuickSort(arr, low, pidx-1);
            QuickSort(arr, pidx+1, high);
        }
    }
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
         int n=arr.length;
     
       QuickSort(arr, 0, n-1);

       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
       }
    }
}
