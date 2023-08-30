import java.util.ArrayList;

public class recursionCls9 {
 public static void permutation(String str ,int idx ,String permutation) {
     
    if ( str.length() == 0) {
        System.out.println(permutation);
        return;
    }
    
    for (int i = 0; i < str.length(); i++) {
        char element=str.charAt(i);
        String newelement=str.substring(0, i) + str.substring(i+1);
        permutation(newelement, idx+1, permutation+element);
    }
 }
  // another way
 public static void swap(char arr[],int i, int j) {
    
         char temp=arr[i];
         arr[i]=arr[j];
         arr[j]=temp;
     
 }
 public static void Permu( char arr[], int idx) {
     
    if (idx == arr.length-1) {
     System.out.println(String.valueOf(arr));
        return;
    }

    for (int i = idx; i < arr.length; i++) {
      swap(arr, idx, i);
      Permu(arr, idx+1);
      swap(arr, idx, i);  
    }
 }
    public static void main(String[] args) {
        String str="abc";
        char arr[]=str.toCharArray();


        // permutation(str, 0, "");

        Permu(arr, 0);
    }
}