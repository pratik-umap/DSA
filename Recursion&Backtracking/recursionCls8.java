public class recursionCls8 {
   public static String keypad[]={" "," ","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
   public static void printKeypad(String str, int idx, String combination){
     if (idx == str.length()) {
         System.out.print(combination+" ");
         return;
     }

      char currChar = str.charAt(idx);
      String mapping= keypad[currChar - '0'];

      for (int i = 0; i < mapping.length(); i++) {
          printKeypad(str, idx+1, combination+mapping.charAt(i));
      }
   }
    public static void main(String[] args) {
        String str="10";

        printKeypad(str, 0, "");

    }
}
