public class sortingAlgorithm1 {
    public static int partition(int a[],int low,int high) {
        int pivot=a[high];
        int i=low-1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        int temp=a[i];
        a[i]=pivot;
        a[high]=temp;
        return i;
    }
    public static void quickSort(int a[],int low,int high) {
        if(low >= high){
            return ;
        }
        int pivotIdx=partition(a, low, high);

         quickSort(a, low, pivotIdx-1);
         quickSort(a, pivotIdx+1, high);
    }
    public static void Conquror(int a[],int s ,int e,int mid) {
        int b[]=new int[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while(i <= mid && j <= e){
            if (a[i] < a[j]) {
                b[k++]=a[i++];
            } else {
                b[k++]=a[j++];
            }
        }

        while (i <= mid) {
            b[k++]=a[i++];
        }

        while (j <= e) {
            b[k++]=a[j++];
        }

        for (int k2 = 0,p=s; k2 < b.length; k2++,p++) {
            a[p]=b[k2];
        }
    }
    public static void mergedSort(int a[],int s,int e) {
        if (s >= e) {
            return;
        }
            int mid=s+(e-s)/2;

            mergedSort(a, s, mid);
            mergedSort(a, mid+1, e);
           Conquror(a, s, e, mid);
        
    }

    public static void main(String[] args) {
        int a[]={5,3,8,1,6,9};
        int n=a.length;

        // quickSort(a, 0, n-1);
        mergedSort(a, 0, n-1);

        for (int i : a) {
            System.out.print(i +" ");
        }

    }
}
