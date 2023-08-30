public class classArray1 {
    
    //  java Arrays 1 class

    public static int searchArr(int []arr,int k) {
        int ans=-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                ans=arr[i];
            }
        }
        if (ans==-1) {
            System.out.println("solution not found");
        } else {
            System.out.println("solution found");
        }
        return ans;
    }

    public static void deleteArr(int arr[],int k) {
        int i=0;
        for ( i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                break;
            }
        } 
       
        for (int j = i; j < arr.length-1; j++) {
            arr[j]=arr[j+1];
        }    
    }

    public static int LargeNo(int arr[]) {
        int max=-1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > max) {
                max=arr[i];
            }
        }
        return max;
    }
    
    public static void secondLargest(int []arr) {
        int large=-1;
        int secondLarge=-1;
        int thirdLarge=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > large) {
                secondLarge=large;
                large=arr[i];
            } else {
                if (arr[i] > secondLarge) {
                    // thirdLarge=secondLarge;
                    secondLarge=arr[i];
                } else {
                   thirdLarge=arr[i];
                }
            }
        }
        System.out.println("third large no is "+ secondLarge);
    }

     public static void removeDuplicateFromSortedArr(int a[]) {
         int j=0;
        for ( int i = 0 ; i < a.length-1; i++){ 
            if (a[i] != a[i+1]){ 
                a[j++]=a[i];
            }
        }    
         a[j++]=a[a.length-1];
         return ;       
       
     }

     public static void reverseArr (int arr1[]) {
         int s=0;
         int e=arr1.length-1;

         while (s<=e) {
             int temp=arr1[s];
             arr1[s]=arr1[e];
             arr1[e]=temp;

             s++;
             e--;
         }
     }

     public static void smallNo(int arr[]) {
         int small=0;

         for (int i = 0; i < arr.length-1; i++) {
             if (arr[i] < arr[small]) {
                 small=i;
             }
         }

         System.out.println(small);
     }

     public static void isSorted(int a[]) {
              int n=a.length;
        for ( int i = 0; i < n-1; i++) {
            if (a[i+1] > a[i]) {
                System.out.print(a[i] + " ");
            }else{
                System.out.println("not sorted");
                break;
            }
            
        }

        if (a[n-2] < a[n-1]) {
            System.out.print(a[n-1]);
        }
     }

     public static void greaterElementOnRight(int arr[]) {
        //7,5,8,9,6,8,5,7,4,6 
    //   9 9 9 8 8 7 7 6 6 0

    for (int i = 0; i < arr.length; i++) {
        arr[i]=helper(arr, i);
    }
       arr[arr.length-1]=0;
     }

     public static int helper(int arr[],int idx) {
         int max=0;

         for (int i = idx+1; i < arr.length; i++) {
             if(arr[i] > max){
               max=arr[i];
             }
         }
         return max;
     }

     static void leaderInArr(int arr[]){

        // not contain greater no in rightside
        int largest=Integer.MIN_VALUE;
        int n=arr.length;
        int []b=new int[arr.length];
        int j=0;
          for (int i = n-1; i >=0; i--) {
               if (arr[i] > largest) {
                   largest=arr[i];
                  b[j++]=arr[i];
               }
          }

          for (int i = j-1; i >=0; i--) {
              System.out.print(b[i]+" ");
          }
     }
    public static void main(String[] args) {
    
        // int arr[]={7,5,8,9,6,8,5,7,4,6};

        // smallNo(arr);

        // isSorted(arr);

    //     greaterElementOnRight(arr);
    //    for (int i : arr) {
    //        System.out.print(i +" ");
    //     }

    int arr[]={2,7,6,4,1,3};
        leaderInArr(arr);

    //   int n= searchArr(arr, 8);
    //    System.out.println(n);

    //    deleteArr(arr, 1);
    //    for (int j = 0; j < arr.length; j++) {
    //     System.out.print(arr[j]+" ");
    //      }

    //   int m=LargeNo(arr);
    //   System.out.println(m);

    //  secondLargest(arr);

//    int a[]={1,1,1,1,2,3,4,5,5};
//     removeDuplicateFromSortedArr(a);

//     for (int j = 0; j < a.length; j++) {
//         System.out.print(a[j]+" ");
//     }


     int []arr1={1,2,3,4,5};
      reverseArr(arr1);

      for (int i = 0; i < arr1.length; i++) {
          System.out.print(arr1[i]+" ");
      }
    }

}
