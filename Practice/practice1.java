package Practice;
import java.util.*;

public class practice1 {
    public static void Kidnaped() {
        // HashMap<Character,Integer>map=new HashMap<>();
        // for (int i = 0; i < ar.length; i++) {
        //     String s=ar[i];
        //     for (int j = 0; j < s.length(); j++) {
        //         map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
        //     }
        //    int max=0;char ch='a';
        //    for (char  key : map.keySet()) {
        //         if (map.get(key) > max) {
        //             max=map.get(key);
        //             ch=key;
        //         }
        //    }
        //    System.out.println(ch);
        //    map.clear();
        // }
    }
    public static void GuardIdcard() {
        // ArrayList<Integer>ans=new ArrayList<>();
        // int a=n;
        // while (a!=0) {
        //     ans.add(a%10);
        //     a/=10;
        // }
        // Collections.reverse(ans);
        // int first=ans.get(0);
        // for (int i = 0; i < ans.size(); i++) {
        //     ans.add(ans.remove(0));
        //     int no=0;
        //     for (int j = 0; j < ans.size(); j++) {
        //         no=no*10+ans.get(j);
        //     }
        //     System.out.println(no);
        //     if(first==ans.get(1))break;
        // }
    }
    public static void matrixProblem() {
        // int mid= n/2; 
        // int midRow=1,midCol=1;
        //  for (int i = 0; i < n; i++) {
        //     midRow*=a[mid][i];
        //     midCol*=a[i][mid];
        //  }
       
        //   int profit= midRow+midCol,invest=0;
  
        //    while (profit!=0) {
        //        invest=invest *10 + profit%10;
        //        profit/=10;
        //    }
        //    System.out.println(invest);
    }
    public static void ArrayProblem() {
        // int max=0;
        // for (int i = 0; i < n; i++) {
        //      a[i]=sc.nextInt();
        //      max=Math.max(max, a[i]);
        // }
        // Set<Integer>set=new HashSet<>();
        // for(int e:a) set.add(e);
        // int cnt=0,sum=0;
        //  for (int i = 0; i <max ; i++) {
        //      int no=(int)Math.pow(2, i);
        //      if(no > max)break;
        //      if(set.contains(no)){
        //          cnt++;
        //          sum+=no;
        //      }
        //  }
        //  System.out.println(cnt+" "+sum);
    }
    public static void noRepalcedByChar() {
        // ArrayList<Integer>ans=new ArrayList<>();
        // int a=n;
        // while (a!=0) {
        //   ans.add(a%10);
        //   a/=10;
        // }
        // Collections.reverse(ans);
        // StringBuilder sb=new StringBuilder();
        // int cntZero=0;
        // Map<Integer,Character>map=new HashMap<>();
        // map.put(1, 'a');
        // map.put(2, 'b');
        // map.put(3, 'c');
 
        // for (int i = 0; i < ans.size(); i++) {
        //     if(ans.get(i)==0){
        //      cntZero++;
        //     }else{
        //         sb.append(map.get(ans.get(i)));
        //     }
        // }
        // while (cntZero > 0) {
        //    sb.append(0);
        //    cntZero--;
        // }
        // System.out.println(sb.toString());
    }
    public static void noOccurOddTimes() {
        // Map<Integer,Integer>map=new HashMap<>();
        // for (int i = 0; i < a.length; i++) {
        //     map.put(a[i],map.getOrDefault(a[i],0)+1);
        // }
        // int sum=0;
        // for (int e :a) {
        //    if(map.containsKey(e) && map.get(e)%2!=0){
        //      sum+=e;
        //    }
        // }
        // System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int arr[]=new int[n];
        arr[0]=1;arr[1]=1;
        for (int i = 2; i < n; i++) {
           arr[i]=arr[i-1]+arr[i-2];
        }
        int sum=0;
        for (int i : arr) sum+=i;
         sb.append(sum);
        for (int i = 0; i < arr.length; i++) {
            sb.append(s.charAt(i));
            sb.append(arr[i]);
        }
      
        System.out.println(sb);
      
    }
}
