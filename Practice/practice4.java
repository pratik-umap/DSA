package Practice;

import java.util.*;

public class practice4 {
    
    static void productArrayExceptSelf(int a[]){
       int b[]=new int[a.length];
       int cnt=1;
       b[0]=1;
       for (int i = 1; i < b.length; i++) {
          b[i]= (cnt*=a[i-1]);
       }  
       
       cnt=1;
       for (int i = a.length-1; i >=0; i--) {
           b[i]= b[i]*cnt;
           cnt*=a[i];
       }
       for (int i : b) {
         System.out.print(i+" ");       
       }
    }
    static void nextSmallerElement(int[] a){
       int b[]=new int[a.length];
       int j=a.length-1;
       ArrayDeque<Integer> stack=new ArrayDeque<>();

        for (int i = a.length-1; i >=0 ; i--) {
            while (!stack.isEmpty() && stack.peek()>=a[i]) {
                stack.poll();
            }
            if (stack.isEmpty()) {
                b[j]=-1;
            } else {
                b[j]=stack.peek();
            }
            stack.push(a[i]);
            j--;
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }
    static void greaterElementWithIndex(int[]a){
        int max=0,index=0;
        for (int i=0;i<a.length;i++) {
            if (a[i]>max) {
                max=a[i];
                index=i;
            }
        }
        System.out.print(max+" "+index);
    }
    static int divisibilityCheck(int num,int m){
        int val=num/m;
        int ans1=val*m;
        int ans2=(val+1)*m;

        if (Math.abs(ans1-num)< Math.abs(ans2-num)) {
            return ans1;
        }
        return ans2;
    }
    static boolean checkPrime(int idx){
        if(idx==2 || idx==3 )return true;
        if(idx%2==0 || idx%3==0)return false;

        for (int i = 5; i < Math.sqrt(idx); i+=6) {
            if (idx%i==0 || idx%(i+2)==0) return false;
        }
        return true;
    }
    static void sumOfPrimeIndice(int[]a){
        int sum=0;
        for (int i = 2; i < a.length; i++) {
             if (checkPrime(i)) {
                sum+=a[i];
             }
        }
        System.out.println(sum);
    }
    static void leastAbsoluteDiff(int[]a,int num){
        int min=100000000,val=0;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i]-num)<min ) {
                min=Math.abs(a[i]-num);
                val=a[i];
            }
        }
        System.out.println(val);
    }
    static void UnfairnessOfArray(int[] a,int k){
        Arrays.sort(a);
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            max=Math.max(max, a[i]);
            min=Math.min(min, a[i]);
        }
        System.out.println(max-min);
    }
    static void commonDigit(int a,int b,int c){
        String p=String.valueOf(a);
        String q=String.valueOf(b);
        String r=String.valueOf(c);
        int arr[]=new int[10];
        // for (int i = 0; i < p.length(); i++) {
        //     arr[p.charAt(i)-'0']++;
        //     arr[q.charAt(i)-'0']++;
        //     arr[r.charAt(i)-'0']++;
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i]==3) {
        //         System.out.println(i);
        //         break;
        //     }
        // }
        Map<Character,Integer>map=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i), 0)+1);
            map.put(q.charAt(i),map.getOrDefault(q.charAt(i), 0)+1);
            map.put(r.charAt(i),map.getOrDefault(r.charAt(i), 0)+1);
        }

        for (Character key : map.keySet()) {
            if (map.get(key)==3) {
                System.out.println(key);
                break;
            }
        }
    }
    static void ballboxProblem(int[] a){
       int sum=0;
       for (int i = 0; i < a.length; i++) {
          sum+= Math.pow(i+1, 2)-a[i];
       }
       System.out.println(sum);
    }
    static void rearrangeArray(int a[]){
        int idx=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                int temp=a[idx];
                a[idx]=a[i];
                a[i]=temp;
                idx++;
            }
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
   static void noOfPerfectSquare(int n){
        int cnt=0;
        for (int i = 1; i < n; i++) {
            if (i*i<n) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
    static void Minimumspend(int n,int m,int a,int b){
        if (b/m >= a) {
            System.out.println(a*n);
            return;
        }
        int complete=n/m;
        int remain=n%m;
        
        System.out.println(Math.min(complete*b+remain*a, (complete+1)*b));
    }
    static int noOfCards(int n){
        if(n==0)return 0;
        if(n==1)return 2;
       return (n*(3*n+1))/2;
        // return 2*n+n-1+noOfCards(n-1);

    }
    static void Barrier(int[][] barrier){
       /*  int min=Integer.MAX_VALUE,max=0;
        for (int i = 0; i < barrier.length; i++) {
            min=Math.min(min,barrier[i][0]);
            max=Math.max(max,barrier[i][0]+barrier[i][2]);
        }
        System.out.println(max +" "+ min +" "+ (max-min+1)); */
            int ans=0;
        int start=barrier[0][0],end=start+barrier[0][2];
        for (int i = 1; i < barrier.length; i++) {
            if (end>=barrier[i][0]) {
                end=Math.max(end,barrier[i][0]+ barrier[i][2]);
            } else {
                ans+=(end-start+1);
                start=barrier[i][0];
                end=start+ barrier[i][1];
            }
        }
        ans+=(end-start+1);

        System.out.println(ans);
    }
    static void pattern1(int n){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
      static void pattern2(int n){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j || j==n-i-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int a[]={4 ,8, 2, 1, 3, 9, 5,4};
        // productArrayExceptSelf(a);
        // nextSmallerElement(a);
        // greaterElementWithIndex(a);
        int num=67,m=8;
    //    System.out.println(divisibilityCheck(num, m));
         int arr[]={10,-12,2,5,3,15,17,21,-3,-4};
        //  sumOfPrimeIndice(arr);
        int b[]={1,2,12,1,3,15,17,26,38,45,64,72};
        int n=27;
        //  leastAbsoluteDiff(b, n);
        int[]c={10,100,300,200,1000,20,30};
        int k=3;
        // UnfairnessOfArray(c, k);
        // commonDigit(701, 205, 510);
        int array[]={0,3,5};
        // ballboxProblem(array);
        int ar[]={-1,2,-5,6,7,-14,-22,-21,-6,12};
        // rearrangeArray(ar);
        //  noOfPerfectSquare(20);
        // Minimumspend(5,2,2,3);
        // System.out.println(noOfCards(4));
        int [][] barrier={{2,3,4},{4,6,2},{5,2,4}};
        // Barrier(barrier);
        // pattern2(5);
      Scanner sc=new Scanner(System.in);
      String s=sc.next();
      System.out.println(s);           
    }
}
