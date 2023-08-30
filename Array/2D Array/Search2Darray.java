import java.lang.annotation.Retention;

public class Search2Darray {
public static boolean Searchtwodarr(int arr[][],int target) {
  
    int row=arr.length;
    int col=arr[0].length;

    int rowidx=0;
    int colidx=col-1;

    while (rowidx < row && colidx >= 0) {
        int element=arr[rowidx][colidx];
        if (element == target ) {
            return true;
        }
        if (element < target) {
            rowidx++;
        } else {
            colidx--;
        }
    }
   return false;
}
    public static void main(String[] args) {
        int arr[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{11,18,19,25,30}};


       boolean a= Searchtwodarr(arr,40);
       System.out.println(a);
    }
}
