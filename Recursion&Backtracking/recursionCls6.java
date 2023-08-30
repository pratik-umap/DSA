public class recursionCls6 {
    public static int partition(int arr[],int s,int e) {
        int pivot=arr[e];
        int i=s-1;
        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
    int temp=arr[i];
    arr[i]=pivot;
    arr[e]=temp;
    return i;
    }
   public static void quickSort(int arr[],int s,int e) {
       
    if (s > e) {
        return;
    }
      int pidx=partition(arr, s, e);

      // left side
       quickSort(arr, s, pidx-1);
       // right side
       quickSort(arr, pidx+1, e);
   }
    public static void main(String[] args) {
        int arr[]={5,2,17,8,4,6,6,6,6};
        int n=arr.length;
    
        quickSort(arr, 0, n-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
