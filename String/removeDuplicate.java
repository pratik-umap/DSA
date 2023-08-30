import java.util.Arrays;

public class removeDuplicate {
   
      public static String  removeDup(char str[],int n) {
      
       int i=0;
       for (int j = 0; j < n; j++,i++) {
           str[i]=str[j];
           if ( i > 0 && str[i - 1]==str[i]) {
               i-=2;
           }
       }
       return new String(str , 0 , i);
      }
    public static void main(String[] args) {
        String s="azxxzy";
        char str[]=s.toCharArray();
       int n=str.length;

       String a=  removeDup(str, n);
        System.out.println(a);
    }
}
