import java.util.Arrays;

public class ClassArray4{

    static int trappingRainWater(int a[]){
    //  trapping rain water problem in o(1) space
        int ans=0;
        int leftMax=0;
        int rightMax=0;

        int left=0;
        int right=a.length-1;

        while(left < right){
            if (a[left] <= a[right]) {
                if (a[left] > leftMax) {
                    leftMax=a[left];
                } else {
                    ans+=(leftMax-a[left]);
                    left++;
                }
            } else {
                if (a[right] > rightMax) {
                    rightMax=a[right];
                } else {
                    ans+=(rightMax-a[right]);
                    right--;
                }
            }
        }
       return ans;
    }
    static int jminusi(int arr[]){
    //    find the max j-i such that arr[j]>arr[i]
     int i=0;
     int j=arr.length-1;
      int max=0;

      while(i<j){
        if (arr[j] > arr[i]) {
            max=Math.max(max, j-i);
        }

        if (arr[i] > arr[j]) {
            j--;
        } else {
            i++;
        }
      }
      return max;
    }

    static boolean findTwoNoSum(int arr[],int sum){
        // {1,2,7,8,10,12}
    //  find two no in sorted array with given sum

        int i=0;
        int j=arr.length-1;
            int ans=0;
        while (i < j) {
             ans=arr[i]+arr[j];
             if (ans==sum) {
                System.out.println(arr[i]+" "+arr[j]);
                return true;
             }else if (ans > sum) {
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    static boolean findThreeNoSum(int arr[],int sum){
           //  find three no in unsorted array with given sum
              Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            
            int k=sum-arr[i];
            System.out.println(k);
            if (findTwoNoSum(arr, k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    //    int arr[]={3,5,1,4,2,6};

    //    System.out.println(trappingRainWater(arr));

        //   int arr[]={3,4,5,1,7,2,6,5,4,2};

        //   System.out.println(jminusi(arr));

    //   int arr[]=  {1,2,7,8,10,12};
    //    System.out.println(findTwoNoSum(arr, 10));

    int arr[]={1,2,4,7,3,5,-2,1};
     System.out.println(findThreeNoSum(arr, 9));
    }
}