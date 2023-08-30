public class removeAllSubstr {
    public static void removeOcc(String s,String part) {
        for (int i = 0; i < s.length(); i++) {
            s=s.replace(part, "");
        }
        System.out.print(s);
    }
    public static void main(String[] args) {
        String s="daabcbaabcbc";
        String part="abc";

       removeOcc(s, part);
    }
}
