import java.util.*;

public class classHashing2 {
    
    public static int largestSubarrWithZeroSum(int[]a) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0, -1);
        int ans=0;
        int cs=0;
        for (int i = 0; i < a.length; i++) {
            cs+=a[i];
            if (map.containsKey(cs)) {
                int temp=map.get(cs);
                ans=Math.max(ans, i-temp);
            } else {
                map.put(cs, i);
            }
        }
        return ans;
    }
public static int longestConsecutiveSubSequence(int a[]) {
    Set<Integer>set=new HashSet<>();
    for (int i : a) {
        set.add(i);
    }
     int ans=0;
    for (int i :set) {
        
        if (!set.contains(i-1)) {
            int len=1;
            while (set.contains(++i)) {
                len++;
            }
            ans=Math.max(ans, len);
        } 
    }
   return ans;
}
static class Pair{
    int i,j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
public static void fourSum(int a[],int sum) {
    Map<Integer,Pair>map=new HashMap<>();
    int n=a.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j < n; j++) {
            int s=a[i]+a[j];
          map.put(s, new Pair(i, j));
        }
    }

    for(Map.Entry<Integer,Pair>entry:map.entrySet()){
        int firstSum=entry.getKey();
        Pair firstPair=entry.getValue();
        int secondSum=sum-firstSum;
        if (map.containsKey(secondSum)) {
            Pair SecondPair=map.get(secondSum);
            if (firstPair.i!=SecondPair.i && firstPair.i != SecondPair.j && 
            firstPair.j !=SecondPair.i && firstPair.j!=SecondPair.j) {
                System.out.println(firstPair.i+" "+firstPair.j+" "+SecondPair.i+" "+SecondPair.j);
                 return ;
            }
        }
    }
}
 
public static int longestSubstringWithoutRepeat(char a[]) {
    Set<Character>set=new HashSet<>();
    for (char i : a) {
        set.add(i);
    }
    // System.out.println(set);
  return set.size();
}

    public static void main(String[] args) {
        // int a[]={1,1,5,-3,-4,3,4,1};
        // System.out.println(largestSubarrWithZeroSum(a));

        int arr[]={2,1,9,3,5,4,8,7};
        // System.out.println(longestConsecutiveSubSequence(arr));
 
        int ab[]={2,1,0,1,6};
        // fourSum(ab, 10);
        
        char a[]={'A','B','C','A','C','D','A','F','G'};
        // System.out.println(longestSubstringWithoutRepeat(a));

    
    }

}
