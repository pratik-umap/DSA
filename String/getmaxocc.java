public class getmaxocc {

    public static char getMaxocc(String s) {
        int arr[]=new int [256];
        
        for (int i = 0; i < s.length(); i++) {
           arr[s.charAt(i)]++;

        }
        int max=-1;  char ans=' ';
        for (int i = 0; i < s.length(); i++) {
            if (max < arr[s.charAt(i)]) {
                max=arr[s.charAt(i)];
                ans=s.charAt(i);
            }
        }
        return ans;
        }
    public static void main(String[] args) {
        
        String s= "baaabaa";

       char a= getMaxocc(s);
       System.out.println(a);
    }
}
