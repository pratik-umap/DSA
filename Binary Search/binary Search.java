
class binary {
     public static int getPivot(int arr[]) {
         int s=0,e=arr.length-1;
         int mid=s + (e - s)/2;

        while (s < e) {
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid=s + (e - s)/2;
        // sorted rotated array find k
        }
        return s;
    }
        public static int bSearch(int arr[],int s,int e,int k) {
            int start=s,end=e;
            int mid=s + (e - s)/2;

            while (start <= end) {
                if (arr[mid] == k) {
                    return mid;
                }
                if (k > arr[mid]) {
                    start=mid+1;
                } else {
                    end=mid-1;
                }
                mid=start + (end - start)/2;
            }
            return mid;
        }

        public static int  findPosition(int arr[],int k) {
           
            int pivot=getPivot(arr);
  
           if (arr[pivot] <= k && k <= arr[arr.length-1] ) {
              return bSearch(arr, pivot, arr.length-1, k);
           } else {
               return bSearch(arr, 0, pivot-1, k);
           }
        }
    public static void main(String[] args) {
        int arr[]={7,8,1,3,5};
        int a=findPosition(arr,3);

        System.out.println(a);
    }
}
