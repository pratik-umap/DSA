public class str {

    public static void reverseSTR(char arr[]) {
        
        int s=0;
        int e=arr.length-1;
        while (s<e) {
            char temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
   public static void printChar() {
      char arr[]={'p','r','a','t','i','k'};

       for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i]+" ");
       }
        System.out.println();
       reverseSTR(arr);
   }

   public static boolean isPalindrome(char arr[]) {
    int s=0;
    int e=arr.length-1;

    while (s<=e) {
        if (tolower(arr[s])!= tolower(arr[e])) {
            return false;
        }
        s++;
        e--;
    }
     return true;

}
   public static char tolower(char ch) {

    if (ch >= 'a' && ch <= 'z') {
        return ch;
    } else {
        char temp = Character.toLowerCase(ch);
        return temp;
    }
   }
    public static void main(String[] args) {
      char arr[]={'P','r','a','t','i','k'};
    //    char a= tolower('B');
    //   System.out.println(a);

       boolean c= isPalindrome(arr);
         System.out.println(c);
    }
}

