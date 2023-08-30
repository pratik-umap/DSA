import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class classString2 {
    public static void patternMatching(String a,String b) {
        int n=a.length();
        int m=b.length();
        for (int i = 0; i <=n-m ; i++) {
            int j=0;
            for (; j <m ; j++) {
                if (a.charAt(i+j)!=b.charAt(j)) {
                    break;
                }
            }
            if (j==m) {
                System.out.println("sequence find at "+i );
            }
        }
    }
    public static boolean rotationalString(String a, String b) {
        if (a.length()!= b.length()) {
            return false;
        }
        String full=a+a;
        return full.contains(b);
    }
    public static int longestSubstringWithDistinctChar(char[]s) {
       int i=0;
       int j=0;
       int index[]=new int[256];
       Arrays.fill(index, -1);
       int ans=0;

       while(j < s.length){
        int lastPos=index[s[j]];
          boolean isPresent=true;
          if (lastPos < i) {
            isPresent=false;
          }
          if (isPresent) {
            i=lastPos+1;
          } 
        int currentWindowSize=j-i+1;
        ans=Math.max(ans, currentWindowSize);
        index[s[j]]=j;
        j++;
       }  
          return ans;
    }
    public static void main(String[] args) {
        // String a="caddabdacdabbab";
        // String b="abd";
        // patternMatching(a, b);

        String a="abcd";
        String b="cdab";
        // System.out.println(rotationalString(a, b));

        String s="abbacdabcdeabacbac";
         System.out.println(longestSubstringWithDistinctChar(s.toCharArray()));
    }
}
