public class classBinarySearchProblem {
    public static int binarySearch(int a[],int k,int s,int e) {
    
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
        return ans;
    }
    public static int searchElementInInfifniteArray(int a[],int k) {
        if (a.length==0) {
            return -1;
        }
        if (a[0]==k) {
            return 0;
        }
        int index=1;
        while (a[index] <= k) {
            index *=2;
        }

        return binarySearch(a, k, index/2, index);
    }
    public static int findSqrt(int n) {
        int s=0;
        int e=n;
        int ans=1;
        while (s<=e) {
            int mid=s+(e-s)/2;
            int midSq=mid*mid;
            if (midSq == n) {
                return mid;
            }
            if (midSq > n) {
                e=mid-1;
            }else{
                ans=mid;
                s=mid+1;
            }
        }
        return ans;
    }
    public static double findMedianOfTwoSortedArr(int a[],int b[]) {
        int n=a.length;
        int m=b.length;
        if (n > m) return findMedianOfTwoSortedArr(b, a);
       
        int s=0 , e=n;
        while (s<=e) {
            int mid1=(s+e)/2;
            int mid2=(n+m+1)/2 -mid1;
            
            int max1= mid1 == 0 ? Integer.MIN_VALUE : a[mid1-1];
            int max2= mid2 == 0 ? Integer.MIN_VALUE : b[mid2-1];

            
            
            int min1= mid1 == n ? Integer.MAX_VALUE : a[mid1];
            int min2= mid2 == m ? Integer.MAX_VALUE : b[mid2];

           if (max1 <= min2 && max2 <= min1) {
            if ((n+m)%2 == 0) {
                return ((double)Math.max(max1, max2)+ (double)Math.min(min1, min2))/2;
            } else {
                return (double) Math.max(max1, max2);
            }
           } else if(max2 > min1){
             s=mid1+1;
           }else{
            e=mid1-1;
           }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        
    //  int a[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,28,29,30,31,33,34,35,37,39};
     int k=30;
    //  System.out.println(searchElementInInfifniteArray(a, k));

        // System.out.println(findSqrt(48));   
        int a[]={1,2,3,4};
        int b[]={2,3,5,6,7,9,10,11};
        System.out.println(findMedianOfTwoSortedArr(a, b));
    }
}
