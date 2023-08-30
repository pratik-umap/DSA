public class moveKstep {
    public static void printKstep(int arr[],int arr1[],int k) {
          
        for (int i = 0; i < arr.length; i++) {
            arr1[(i+k) % arr.length] = arr[i];
            
        }

        
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
    }
    public static void main(String[] args) {
        
        int arr[]={1,2,3,4};
       int arr1[]=new int [arr.length];

       printKstep(arr, arr1, 2);


    }
}
