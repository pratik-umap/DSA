
public class recursionCls5 {
    public static int Conquror(int arr[],int s , int e ,int mid) {
        
        int merged[]=new int [e-s+1];
        int idx1=s;
        int idx2=mid+1;
        int k=0;
        int count =0;
        while (idx1 <= mid && idx2 <= e ) {
            if (arr[idx1] < arr[idx2]) {
                merged[k++] = arr[idx1++];
            } else {
                merged[k++] = arr[idx2++];
                count += (mid+1) - (s+idx1);
            }
        }
     
        while (idx1 <= mid) {
            merged[k++] = arr[idx1++];
        }

        while (idx2 <= e) {
            merged[k++] = arr[idx2++];
        }

        for (int i = 0 , j=s; i < merged.length; i++,j++) {
            arr[j]=merged[i];
        }
        return count;
    }
  public static int Divide(int arr[],int s , int e) {
      int count=0;
    if (s < e) {
    
     int mid=s + (e - s)/2;
    //  first array
     count += Divide(arr, s, mid);
      // second array
    count +=  Divide(arr, mid+1, e);

    count +=  Conquror(arr, s, e, mid);
    }
    return count;
  }
    public static void main(String[] args) {
        // merge sort
        int arr[]={8,4,2,1};
        int n=arr.length;

      int a=  Divide(arr, 0, n-1);
    System.out.println(a);

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }

    }
}
