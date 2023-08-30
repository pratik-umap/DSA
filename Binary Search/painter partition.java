class painter  {
    public static boolean isPossible(int arr[],int n,int p,int mid) {
        
      int paintercount=1;
      int boardsum=0;
      for (int i = 0; i < n; i++) {
          if (boardsum + arr[i] <= mid) {
              boardsum+=arr[i];
          } else {
              paintercount++;
              if (paintercount > p || arr[i] > mid) {
                  return false;
              }
              boardsum=arr[i];
          }
      }
      return true;
    }
  
      public static int  printPainter(int arr[],int n,int p) {
          
          int s=0;
          int sum=0;
          for (int i = 0; i < n; i++) {
              sum+=arr[i];
          }
          int e=sum;
          int ans=-1;
          int mid= s + (e - s)/2;
          while (s <= e) {
              if (isPossible(arr, n, p, mid)) {
                  ans=mid;
                  e=mid-1;
              } else {
                  s=mid+1;
              }
              mid= s + (e - s)/2;
          }
          return ans;
      }

  public static void main(String[] args) {
      
      int arr[]={5,5,5,5};
     int p=2;


     System.out.println(printPainter(arr, arr.length, p));


  }
}
