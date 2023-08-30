
public class addArray {

    public static void reverseArray(int ans[]) {
        int s=0;
        int e=ans.length-1;
        while (s <= e) {
            int temp = ans[s];
            ans[s]=ans[e];
            ans[e]=temp;
            s++;
            e--;
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
    public static void add2Array(int arr1[], int n, int arr2[], int m) {
        int i=n-1;
        int j=m-1;
        int carry=0;
        int ans[]=new int [n];
         int k=0;
        while (i>=0 && j>=0) {
        
            int val1=arr1[i];
            int val2=arr2[j];

            int sum=val1+val2+carry;

            carry=sum/10;
            sum=sum%10;
            ans[k]=sum;
            i--;
            j--;
            k++;
        }

        // first case
        while (i>=0){
            int sum=arr1[i]+carry;
            carry=sum/10;
            sum=sum%10;
           ans[k]=sum;
            i--;
            k++;
        }

        // second case
        while (j>=0) {
            int sum=arr2[j]+carry;
            carry=sum/10;
            sum=sum%10;
           ans[k]=sum;
            j--;
            k++;
        }
       
        reverseArray(ans);
       
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4};
        int n=arr1.length;

         int arr2[]={6};
         int m=arr2.length;

         add2Array(arr1, n, arr2, m);
    }
}
