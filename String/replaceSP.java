public class replaceSP {
    public static String replaceSpace(String s) {
        
        s=s.replace(" ", "@40");
       return s;
    }
    public static void main(String[] args) {
        String s="my name is pratik";

         String a=replaceSpace(s);
         System.out.println(a);
        
    }
}
