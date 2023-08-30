public class classBinarySearchBasic {
    public static int firstOccurenceInSortedArr(int arr[],int k) {
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while (s <= e) {
            int mid=s+(e-s)/2;
            if (arr[mid] == k) {
                ans=mid;
                e=mid-1;
            }else if (k > arr[mid]) {
                s=mid+1;
            } else {
                e=mid-1;
            }
        }
        return ans;
    }
    public static int lastOccurenceInSortedArr(int arr[],int k) {
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while (s <= e) {
            int mid=s+(e-s)/2;
            if (arr[mid] == k) {
                ans=mid;
                s=mid+1;
            }else if (k > arr[mid]) {
                s=mid+1;
            } else {
                e=mid-1;
            }
        }
        return ans;
    }
    public static int countOccurenceOfElement(int arr[],int k) {
        
        int cnt1=firstOccurenceInSortedArr(arr, k);
        int cnt2=lastOccurenceInSortedArr(arr, k);

        return cnt2-cnt1+1;
    }
    public static int searchInRotatedSortedArr(int arr[], int k) {
        int s=0;
        int e=arr.length-1;
        while (s <= e) {
            int mid=s+(e-s)/2;
            if (arr[mid]==k) {
                return mid;
            }
            if (arr[s] < arr[mid]) {
                if (k >= arr[s] && k < arr[mid]) {
                    e=mid-1;
                } else {
                    s=mid+1;
                }
            } else {
                if (k > arr[mid] && k <= arr[e]) {
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
      return -1;
    }
    public static int upperBoundOfElement(int []a,int k) {
        int s=0;
        int e=a.length-1;
        int ans=-1;
        while (s <= e) {
            int mid=s+(e-s)/2;
            if (a[mid] == k) {
               s=mid+1;  
            }else if (a[mid] < k) {
                s=mid+1;
            } else {
                ans=mid;
                e=mid-1;
            }
            }
            return ans;
    }
    public static int isPresent(int a[],int k) {
        // find the element if present else return idx where we can add this element 
        int s=0;
        int e=a.length-1;
        int ans=-1;
        while (s <= e) {
            int mid=s+(e-s)/2;
            if (a[mid] == k) {
                ans=mid;
                 return ans;
            }else if (k > a[mid]) {
                s=mid+1;
            } else {
                e=mid-1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        // int arr[]={1,1,2,4,4,4,4,5,6,6};
    //    int k=2;
    //    System.out.println(firstOccurenceInSortedArr(arr, k));
    //  System.out.println(lastOccurenceInSortedArr(arr, k));
    // System.out.println(countOccurenceOfElement(arr, k));
     
      int arr[]={4,5,7,8,9,1,2,3};
      int k=3;
    //    System.out.println(searchInRotatedSortedArr(arr, k));

    //  int a[]={0,0,0,1,1,1,1};    
    //   System.out.println(firstOccurenceInSortedArr(a, 1));

    int a[]={1,2,4,5,8,9,10,12,15};
    // System.out.println(upperBoundOfElement(a, 9));

    System.out.println(isPresent(a, 6));
     

    }
}
