package Practice;
import java.util.*;
public class practice3{
    
    public static void flipflop(int arr[],int n) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for (int i = 1; i < arr.length; i++) {
            pq.add(arr[i]);
        }        
        while (true) {
            if(pq.remove()==-1 && pq.remove()==-1){
                pq.add(1);
                pq.add(1);
                break;
            }else if (pq.remove()==1 && pq.remove()==1) {
                pq.add(-1);
                pq.add(-1);
                break;
            }
        }
        int sum=arr[0];
        while (!pq.isEmpty()) {
            sum+=pq.remove();
        }
        System.out.println(sum);
    }
    public static void increasingSubarray(int a[],int n) {
        int arr[]=new int[n];
        int j=0;
        arr[j]=a[0];
        for (int i = 1; i < arr.length; i++) {
             if (arr[j] < a[i]) {
                j++;
                arr[j]=a[i];
             }else{
                arr[j]=a[i];
             }
        }
        System.out.println(j+1);
    }
    public static int weirdSubArray(int a[],int n) {
        // HashMap<Integer,Integer>map=new HashMap<>();
        // for (int i : a) {
        //     map.put(i, map.getOrDefault(a[i],0)+1);
        // }
        // int MaxCnt=0,ele=0;
        // for (int key : map.keySet()) {
        //     if (map.get(key)> MaxCnt) {
        //         MaxCnt=map.get(key);
        //         ele=key;
        //     }
        // }
        // int cnt=0,count=0;
        // for (int i : a) {
        //     if (i==ele) {
        //        cnt++; 
        //     }else{
        //     count=Math.max(count, cnt);
        //         cnt=0;
        //     }
        // }
        // System.out.println(count);
            if (n < 2) {
                return 0;
            }
            int arr[]=new int[n];
            int cnt=0,max=0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    if (a[i]==a[j]) {
                        cnt++;
                    }else{
                        arr[i]=cnt;
                        cnt=0;
                        break;
                    }
                }
            }
           max= Arrays.stream(arr).max().getAsInt();
            return max;
    }
    public static boolean helper(int arr[],int no,int n) {
            int i=no,j=no+1;
            int left=1,right=1;
        while (i>=0 && j<n ) {
            left*=arr[i];
            right*=arr[j];
            i--;
            j++;
        }
        if(left==right)return true;
        return false;
    }
    public static int sum(int arr[]) {
        int ans=0;
        int n=arr.length;
        for (int i = 0; i < arr.length; i++) {
           if(helper(arr, i, n)){
              ans=Math.min(ans, i+1);
           }
        }
        return ans==0?-1:ans;
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // for (int i = 0; i < n; i++) {
        //     int m=sc.nextInt();
        //     int arr[]=new int[m];
        //     for (int j = 0; j < m; j++) {
        //         arr[j]=sc.nextInt();
        //     }
        //     flipflop(arr, m);
        // }
        // int n=a.length;
        // increasingSubarray(a, n);
        // System.out.println(weirdSubArray(a, n));
        
        Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        for (int i = 0; i < input; i++) {
            int n=sc.nextInt();
            int arr[]=new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j]=sc.nextInt();
            }
            System.out.println(sum(arr));
        }
    }
}