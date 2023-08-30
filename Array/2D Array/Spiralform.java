public class Spiralform {
    public static void spiralWave(int arr[][]) {
        int startrow=0;
        int endrow=arr.length;
        int startcol=0;
        int endcol=arr[0].length;

        while (startrow < endrow && startcol < endcol) {
            for (int i = startcol; i < endcol; i++) {
                System.out.print(arr[startrow][i]+" ");
            }
            startrow++;

            for (int i = startrow; i < endrow-1; i++) {
                System.out.print(arr[i][endcol-1]+" ");
            }
            endcol--;

            for (int i = endcol-1; i >= startcol; i--) {
                System.out.print(arr[endrow-1][i]+" ");
            }
            endrow--;

            for (int i = endrow-1; i >=startrow; i--) {
                System.out.print(arr[i][startcol]+" ");
            }
            startcol++;
        }

    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},
                     {5,6,7,8},
                    {9,10,11,12}};

       spiralWave(arr);
    }
}
