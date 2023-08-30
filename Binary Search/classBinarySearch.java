public class classBinarySearch {
    public static boolean isPossible(int[]arr,int n,int student ,int mid) {
        int studentCount=1;
        int pageSum=0;
         for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum+=arr[i];
            }else{
                studentCount++;
                if (studentCount > student || arr[i] > mid) {
                    return false;
                }
                pageSum=arr[i];
            }
         }
        return true;
    }
    public static int booksAllocation(int arr[],int n,int student) {
        int s=0;
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        int e=sum;
        int ans=-1;
        while (s<=e) {
            int mid=s+(e-s)/2;
           if (isPossible(arr,n,student,mid)) {
                ans=mid;
                e=mid-1;
           }else{
            s=mid+1;
           }
        }
        return ans;
    }
    public static boolean isSafe(int[]arr,int n,int painter,int mid) {
        int painterCount=1;
        int boardSum=0;
        for (int i = 0; i < n; i++) {
            if (boardSum + arr[i] <= mid) {
                boardSum+=arr[i];
            } else {
                painterCount++;
                if (painterCount > painter || arr[i]> mid) {
                    return false;
                }
                boardSum=arr[i];
            }
        }
        return true;
    }
    public static int painterPartition(int arr[],int n,int painter) {
        int s=0;
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        int e=sum;
        int ans=-1;
        while (s<=e) {
            int mid=s+(e-s)/2;
            if (isSafe(arr,n,painter,mid)) {
                ans=mid;
                e=mid-1;
            } else {
                s=mid+1;
            }
        }
        return ans;
    }
    public static boolean canAccomodate(int[]arr,int n,int cow,int mid) {
        int cowCount=1;
        int prevPos=arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] - prevPos >= mid) {
                cowCount++;
                if (cowCount == cow) {
                    return true;
                }
                prevPos=arr[i];
            }
        }
        return false;
    }

    public static int aggressiveCows(int arr[],int n,int cow) {
        int s=arr[0];
        int e=arr[n-1];
        int ans=-1;
        while (s<=e) {
            int mid=s+(e-s)/2;
            // System.out.println("mid "+mid);
            if (canAccomodate(arr,n,cow,mid)) {
                ans=mid;
                // System.out.println("s "+s);
                s=mid+1;
            } else {
                // System.out.println("e "+e);
                e=mid-1;
            }
        }
        return ans;
    }
    public static boolean isEnought(int arr[],int k, int cut){
        int total=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i] > cut ) {
                total += (arr[i]-cut);
            }
        }
        return total >= k;
    }

   public static int woodCutterProblem(int arr[],int k) {
     int s=0;
     int e=0;
     for (int i : arr) {
        e=Math.max(e,i);
     }
     int ans=-1;
     while(s <= e){
        int mid=(s+e)/2;
        if (isEnought(arr,k,mid)) {
            ans=mid;
            s=mid+1;
        } else {
            e=mid-1;
        }
     }
     return ans;
   }
    public static void main(String[] args) {
        int arr[]={6,2,8,10,12};
        int student=3;
    //   System.out.println(booksAllocation(arr, arr.length, student));
       int board[]={3,4,5,5};
       int painter=2;
        // System.out.println(painterPartition(board, board.length, painter));
        int stall[]={1,2,4,8,9};
        int cow=3;
        // System.out.println(aggressiveCows(stall, stall.length, cow));

        int height[]={2,4,8,7,3,6,9};
        int k=8;
        System.out.println(woodCutterProblem(height, k));

             
    }
}
