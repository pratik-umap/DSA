public class SubSequence {
    public static void subSeq(String str, int idx,String newelement) {
        
        if (idx >= str.length()) {
            // not print empty string
          if (newelement.length() > 0) {
            System.out.println(newelement);
          }
            return;
        }
        char current=str.charAt(idx);
        // exclude
        subSeq(str, idx+1, newelement);
        // include
        subSeq(str, idx+1, newelement+current);
    }
    public static void main(String[] args) {
        String str="abc";

        subSeq(str, 0, "");
    }
}
