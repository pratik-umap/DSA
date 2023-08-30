public class moveZero {
    
    public static void printZero(int arr[]) {
       int i=0;

       for (int j = 0; j < arr.length; j++) {
           if (arr[j] != 0) {
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp;
               i++;
           }
       }
    }


    public static void main(String[] args) {
        
        int arr[]={0,2,0,3,0,1,0,0};

      printZero(arr);

      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i]+" ");
      }
    }
}
