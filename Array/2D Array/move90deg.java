public class move90deg {
    public static void move90(int arr[][]) {
        int startrow=0;
        int endrow=arr.length;
        int startcol=0;
        int endcol=arr[0].length;
       
        while (startrow < endrow && startcol < endcol) {
            for (int i = endrow-1; i >= startrow; i--) {
                System.out.print(arr[i][startcol]+" ");
            }
            startcol++;
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},
                     {4,5,6},
                     {7,8,9}};

      move90(arr);
    }
}

//  7 4 1
//  8 5 2 
//  9 6 3