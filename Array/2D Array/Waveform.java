public class Waveform {
   public static void  isWave(int arr[][],int nrows ,int mcols) {
    if(arr.length==0){
        return;
    }
     for (int col = 0; col < mcols; col++) {
         if (col%2==0) {
             for (int row = 0; row < nrows; row++) {
                 System.out.println(arr[row][col]);
             }
            }else {
             for (int row = nrows-1; row >=0; row--) {
                 System.out.println(arr[row][col]);
            }
         }
     }
       
   }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6}};
        
     isWave(arr, 2, 3);
    }
}
