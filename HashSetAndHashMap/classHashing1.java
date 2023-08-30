import java.util.*;

public class classHashing1 {

    public static int countDistinctElement(int a[]) {   
        Set<Integer>set=new HashSet<>();

         for (int e : a) {
            set.add(e);
         }
        //  System.out.println(set);
         return set.size();
    }

    public static void frequencyOfEachElement(int a[]) {
        Map<Integer,Integer>map=new HashMap<>();

        for (int i : a) {
            if (map.containsKey(i)) {
                 int temp=map.get(i);
                 map.put(i, temp+1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map);
    }
    public static boolean pairWithGivenSum(int arr[],int sum) {
        Set<Integer>set=new HashSet<>();

        for (int e : arr) {
            int comp=sum-e;
            if (set.contains(comp)) {
                System.out.println(e+" "+comp);
                return true;
            }
            set.add(e);
        }
        return false;
    }
    public static boolean zeroSumSubarray(int a[]) {
        Set<Integer>set=new HashSet<>();
        int sum=0;
        for ( int e : a) {
            sum+=e;
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;

    }
    public static void subarrayWithGivenSum(int a[],int sum) {
        Map<Integer,Integer>map=new HashMap<>();
          int currSum=0;
          int start=0;
          int end=-1;

        for(int i=0;i<a.length-1;i++){
           currSum+=a[i];
           if (currSum-sum==0) {
             start=0;
             end=i;
             break;
           }
            
           if (map.containsKey(currSum-sum)) {
             start=map.get(currSum-sum)+1;
             end=i;
             break;
           }
          map.put(currSum, i);
        }
        if (end==-1) {
            System.out.println("no subarray found");
        } else {
            System.out.println("subarray found between"+start+" to "+end );
        }
    }
     public static void unionArray(int a[],int b[]) {
        
        Set<Integer>set=new HashSet<>();

        for (int e : a) {
            set.add(e);
        }
        for (int e : b) {
            set.add(e);
        }

        System.out.println(set);
     }
    public static void intersectionArray(int a[],int b[]) {

        Map<Integer,Integer>map=new HashMap<>();
        ArrayList<Integer>array=new ArrayList<>();
        for (int i : a) {
            array.add(i);
        }
        for (int i : b) {
            array.add(i);
        }

        for (int i : array ) {
            if (map.containsKey(i)) {
                 int temp=map.get(i);
                 map.put(i, temp+1);
            } else {
                map.put(i, 1);
            }

            if (map.get(i) >= 2) {
                System.out.println(i);
            }
        }
    }
    public static void countDistinctElementForKWindow(int a[],int k) {
        
        Map<Integer,Integer>set=new HashMap<>();

        for (int i = 0; i < k; i++) {
            set.put(a[i], set.getOrDefault(a[i], 0)+1);
        }
       System.out.println(set.size());

       for (int i = k; i < a.length; i++) {
        if (set.get(a[i-k])==1) {
            set.remove(a[i-k]);
        } else 
            set.put(a[i-k], set.get(a[i-k])-1);

            set.put(a[i], set.getOrDefault(a[i], 0)+1);
            System.out.println(set.size());
        
       }
    }

    public static void main(String[] args) {
        // int a[]={1,5,4,2,3,3,1,1,2,4,3,6};

        //  System.out.println(countDistinctElement(a));

        // frequencyOfEachElement(a);
    //    int arr[]={1,2,3,1,4,5,2,-1,4};
    //    int sum=8;
        // System.out.println(pairWithGivenSum(arr, sum));

        // int arr1[]={1,4,-3,2,1,2};

        // System.out.println(zeroSumSubarray(arr1));

        // int a[]={5,1,4,6,8,9};

        // subarrayWithGivenSum(a, 11);

        int arr[]={1,3,6,7,8};
        int arr1[]={3,4,6,8,10};
       unionArray(arr, arr1);
    //    intersectionArray(arr, arr1);

    //    int a[]={1,2,1,3,4,2,3};
    //    countDistinctElementForKWindow(a, 4);
    }
}
