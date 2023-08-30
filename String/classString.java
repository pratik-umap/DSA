import java.util.Arrays;

public class classString{
   
    public static boolean checkAnagram(String a,String b){
        int arr[]=new int[256];

        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            arr[b.charAt(i)]--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
     public static void reverse(char arr[],int i,int j) {
      
        while (i<j) {
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;
       } 
     }
    public static String reverseWord(String s) {
         int start=0;
         int end = 0;
         char c[]=s.toCharArray();
        for (; end < s.length(); end++) {
             if (c[end]==' ') {
                reverse(c, start, end-1);
                start=end+1;
             }
        }
        reverse(c, start, s.length()-1);

        reverse(c, 0, s.length()-1);
        return new String(c);
    }
    public static boolean checkStrIsSubSequenceOfAnother(String a,String b) {
         int m=a.length();
         int n=b.length();

        int j=0;
        for (int i = 0; i < n && j < m ; i++) {
            if (a.charAt(j) == b.charAt(i)) 
                j++;
        }
        return j==m;
    }
    public static int findLeftMostCharThatRepeat(String s) {
        int n=256;
        boolean visited[]=new boolean[n];
        Arrays.fill(visited,false);
         int res=0;
       
        for (int i = s.length()-1; i >= 0; i--) {
            if (visited[s.charAt(i)]== false) {
                visited[s.charAt(i)]=true;
            } else {
                res=i;
            }
        }
        return res;
    }
    public static int lengthOfLastWordInString(String s) {
        int len=0;
        for (int i = s.length()-1; i >=0; i--) {
             if (s.charAt(i)==' ') {
                break;
             }else{
                len++;
             }
        }
        return len;
    }
    public static void main(String[] args){
    //    String a="pratik";
    //    String b="rapdkit";
    //    System.out.println(checkAnagram(a, b));
        
    //   String s="I am the boss";
    //  System.out.println(reverseWord(s));

         String a="abc";
         String b="bafasbacacds";
         System.out.println(checkStrIsSubSequenceOfAnother(a, b));

        // String s="praptik";
        // int ans=findLeftMostCharThatRepeat(s);
        // System.out.println(s.charAt(ans));

        String s="I am the boss";
        // System.out.println(lengthOfLastWordInString(s));

        
    }
}