package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class practice {
    
    public static boolean isPrime(int n){
        if(n==2 || n==3)return true;
        if(n%2==0 || n%3==0)return false;
        
        for(int i=5; i< Math.sqrt(n);i+=6){
            if(n%i==0 || n% i+2==0)return false;
        }
        return true;
    }
    public static void printPrime() {
        System.out.print(1+" "+2+" "+3+" ");
        for (int i = 2; i <= 100; i++) {
            if (i%2 != 0 && i%3 != 0) {
                System.out.print(i+" ");
            }
        }
    }
    public static void isArmstrong(int n) {
        // ArrayList<Integer>ans=new ArrayList<>();
        int a=n ,cnt=0;
        while (a!=0) {
            a/=10;
            cnt++;
        }
        a=n;
        int no=0;
        while (a!=0) {
            no+=Math.pow(a%10, cnt);
            a/=10;
        }
        
        if (no==n) {
            System.out.println("no is Armstrong "+ no);
        }else{
            System.out.println("no is not Armstrong "+ no);
        }
    }
    public static void printFactorial() {
        // factorial from 1 to 10 
        for (int i = 1; i <= 10; i++) {
            int ans=1;
            for (int j = i; j >=1; j--) {
                ans*=j;
            }
            System.out.print(ans+" ");
        }
    }
    public static void reverseString(String s) {
        String a=new StringBuilder(s).reverse().toString();
        System.out.println(a);
    }
    public static boolean isNoPalindrome(int n) {
        ArrayList<Integer>ans=new ArrayList<>();
        int a=n;
        while (a!=0) {
            ans.add(a%10);
            a/=10;
        }
        int i=0,j=ans.size()-1;
        while (i<=j) {
            if (ans.get(i) != ans.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void freqOfVowelsInWord(String s) {
        Map<Character,Integer>map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u')
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        System.out.println(map);
    }
    public static boolean twoArrayEqualOrNot(int a[],int b[]) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static void swap(int a[],int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void sortZeroOneTwo(int a[]) {
        int cntZero=0,cntOne=0,cntTwo=0;
        for (int i : a) {
            if (i==0) {
                cntZero++;
            }else if(i==1){
                cntOne++;
            }else if (i==2) {
                cntTwo++;
            }
        }
        for (int i =0;i<a.length;i++) {
            if (cntZero!=0) {
                a[i]=0;
                cntZero--;
            }else if(cntOne!=0){
                a[i]=1;
                cntOne--;
            }else if (cntTwo!=0) {
                a[i]=2;
                cntTwo--;
            }
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    public static boolean subArrayWithGivenSum(int a[],int val) {
        // [ 5 4 8 9 1 2 4] sum=16
        int sum=0,i=0;
        for (int e : a) {
            sum+=e;
            if(sum==val) return true;
            while (sum > val) {
                sum-=a[i];
                i++;
            }
        }
        return false;
    }
    public static void firstRepeatedChar(String s) {
        int freq[]=new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
            if (freq[s.charAt(i)-'a'] > 1) {
                System.out.println(s.charAt(i));
                break;
            }
        }
    }
    public static void printFibonacci(int n) {
    //    if(n==0 || n==1)return n;
    //    return printFibonacci(n-1)+printFibonacci(n-2);
        int a=0,b=1;
        System.out.print(a+" "+b+" ");
        for (int i = 1; i < n-1; i++) {
            int sum=a+b;
            System.out.print(sum+" ");
            a=b;b=sum;
        }
    }
    public static void replaceFiveWithZero(int n) {
        ArrayList<Integer>ans=new ArrayList<>();
        int a=n;
        while (a!=0) {
            int val=a%10;
            if(val==0){
                ans.add(5);
                a/=10;
                continue;
            }
            ans.add(val);
            a/=10;
        }

        int sum=0;
        for (int i = ans.size()-1; i >=0; i--) {
            sum = sum * 10 +ans.get(i);
        }
        System.out.println(sum);
    }
    public static void printSumOfPrimeNo() {
        int sum=0;
        for (int no = 2; no <= 1000; no++) {
            int cnt=0;
            for (int j = 2; j <=Math.sqrt(no); j++) {
                if(no % j==0)cnt++;
            }
            if(cnt==0 && no!=1){
                sum+=no;
            }
        }
        
        System.out.println(sum);
    }
     public static void main(String[] args) {
        // System.out.println(isPalindrome(10));
        // printPrime();
        // isArmstrong(1634);
        // printFactorial();
        //  reverseString("elephant");
        // System.out.println(isNoPalindrome(123451321));
        //  freqOfVowelsInWord("accommodation");
        int a[]={5,4,8,9,1,2,4};
        int b[]={1,2,1,4,5};
        // System.out.println(twoArrayEqualOrNot(a, b));
        //  sortZeroOneTwo(a);
        int val=18;
        // System.out.println(subArrayWithGivenSum(a, val));
        // firstRepeatedChar("abcdefgabc");
    //    printFibonacci(5);
    //   replaceFiveWithZero(1203005102);
        // printSumOfPrimeNo();
    }
}
