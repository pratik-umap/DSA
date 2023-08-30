import java.util.*;

public class SortingAlgorithm {
    
    public static void bubbleSort(int[]a) {
        
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j] > a[j+1]) {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static void selectionSort(int[]a) {
        
        for (int i = 0; i < a.length; i++) {
              int small=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[small]) {
                    small=j;
                }
            }
            int temp=a[small];
            a[small]=a[i];
            a[i]=temp;
        }
    }
    public static void insertionSort(int[]a) {
        
        for (int i = 1; i < a.length; i++) {
            int current=a[i];
            int j=i-1;
            while (j >=0 && current < a[j]) {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=current;
        }
    }
    public static void intersectionOfTwoArr(int[]a,int[]b) {
        int i=0,j=0;
        
        while (i<a.length && j < b.length) {
             if (a[i]==b[j]) {
                System.out.print(a[i]+" ");
                i++;
                j++;
             } else if(a[i] > b[j]) {
                j++;
             }else if(a[i] < b[j]){
                i++;
             }
        }
        
    }
    public static void swap(int a[],int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void sortArrWithThreeTypeOfElement(int a[]) {
        // Dutch flag sorting Algorithm
        int low=0;
        int mid=0;
        int high=a.length-1;
        while (mid < high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            }else if (a[mid]== 1) {
                mid++;
            }else if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            }
        }
    }
    public static void UnionOfTwoSortedArr(int[]a,int[]b) {
       int i=0;
       int j=0;
    
       while (i < a.length && j < b.length) {
          
             if (a[i] == b[j]) {
                System.out.print(a[i]+" ");
                i++;
                j++;
             }else if (a[i] > b[j]) {
                System.out.print(b[j]+" ");
                j++;
             }else if (a[i] < b[j]) {
                System.out.print(a[i]+" ");
                i++;
             }
       }
       if (i!=a.length) {
          for (int j2 = i; j2 < a.length; j2++) {
               System.out.print(a[j2]+" ");
          }
       }
       if (j!=b.length) {
        for (int j2 = j; j2 < b.length; j2++) {
             System.out.print(b[j2]+" ");
        }
     }

    }
    public static int findMinimumDiffBetwTwoElement(int a[]) {
       Arrays.sort(a);
       int sub=Integer.MAX_VALUE;
       for (int i = 0; i < a.length-1; i++) {
            sub=Math.min(sub, a[i+1]-a[i]);
       }
       return sub;
    }
    public static void sortArrWithTwoTypeOfElement(int []a) {
    
        int low=0;              
        int mid=a.length-1;
          while( low < mid){
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
            } else if(a[mid] == 1) {
                mid--;
            }
        }
    }
    public static void main(String[] args) {
        // int a[]={8,1,4,6,7,3};
        // bubbleSort(a);
        // selectionSort(a);
        // insertionSort(a);
        
        // for (int i : a) {
        //     System.out.print(i+" ");
        // }
       int []a={2,4,6,8,9,10};
       int []b={1,2,5,6,7,8,11,12};
        // intersectionOfTwoArr(a, b);

        int s[]={2,2,1,0,0,1,2,0,1};
        // sortArrWithThreeTypeOfElement(s);

        // for (int i : s) {
        //     System.out.print(i +" ");
        // }

        UnionOfTwoSortedArr(a, b);
        // int a[]={6, 18, 1, 9, 14};
        // System.out.println(findMinimumDiffBetwTwoElement(a));

        // int b[]={1,0,0,1,0,1,1,0};
        //   sortArrWithTwoTypeOfElement(b);

        //   for (int i : b) {
        //     System.out.print(i+" ");
        //   }
    }
}
