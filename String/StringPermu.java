public class StringPermu {
    public static boolean checkPerStr(String s1, String s2) {
        if (s1 == null || s2== null || s1.length()==0 || s2.length()==0 || s2.length() < s1.length()) {
            return false;
        }
        int [] s1Freq=Input(s1);
        int []s2Freq=new int [26];

        for (int i = 0; i < s1.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
        }
        if (matchChar(s1Freq,s2Freq)) {
            return true;
        } else {
            for (int i = s1.length(); i < s2.length(); i++) {
                s2Freq[s2.charAt(i - s1.length())-'a']--;
                s2Freq[s2.charAt(i) - 'a']++;
                if (matchChar(s1Freq,s2Freq)) {
                    return true;
                }
            } 
        }
        return false;
    }
    private static int[] Input(String s) {
        int arr[]=new int [26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
    private static boolean  matchChar(int []input, int [] pattern) {
        for (int i = 0; i < 26; i++) {
            if (input[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
     String s1="ab";
     String s2="ansdrpbojgf";

     boolean a= checkPerStr(s1, s2);
     System.out.println(a);

    }
     
}
