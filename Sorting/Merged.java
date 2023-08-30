public class Merged {
    
    public static void arrMerged(int arr1[] ,int n ,int arr2[] ,int m ,int arr3[] ) {
        int i=0; int j=0; int k=0;
        
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
              arr3[k++] = arr1[i++];
            }else{
                arr3[k++] = arr2[j++];
            }
        }

        while(i < n){
            arr3[k++]=arr1[i++];
        }

        while(j < m){

            arr3[k++]=arr2[j++];
        }
    }
    
    public static void main(String[] args) {
        int arr1[]={1,3,5,7,9};
        int n=arr1.length;

        int arr2[]={2,4,6};
        int m=arr2.length;

        int arr3[]=new int[n+m];

       arrMerged(arr1, n, arr2, m, arr3);

       for (int i = 0; i < n+m; i++) {
           System.out.print(arr3[i]+" ");
       }
    }
}
