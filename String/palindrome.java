public class palindrome {

    public static boolean Valid(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }    
    public static char tolower(char ch) {

        if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
            return ch;
        } else {
            char temp = Character.toLowerCase(ch);
            return temp;
        }
    }   
    public static boolean checkPalindrome(char arr[]) {
        int s=0;
        int e=arr.length-1;
    
        while (s<=e) {
            if (arr[s]!= arr[e]) {
                return false;
            }
            s++;
            e--;
        }
         return true;
    }    
    
    public static boolean isPalindrome(char arr1[]) {
        char temp[]=new char [arr1.length];
        for (int i = 0; i < arr1.length;i++) {
            if (Valid(arr1[i])) {
                temp[i]=arr1[i];
            }else{
                i++;
            }
            
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i]=tolower(temp[i]);

        }
        return checkPalindrome(temp);
    }
    public static void main(String[] args) {
        
        char arr1[]={'P','$','o','@','o','n'};
 
         boolean a= isPalindrome(arr1);
         System.out.println(a);
       

    }
}
