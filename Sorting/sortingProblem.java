public class sortingProblem {
    public static String Conquror(String a,String b) {
        // longest common prefix using divide and conquror
        String ans="";
        for (int i = 0,j=0; i < a.length() && j < b.length(); i++,j++) {
            if (a.charAt(i) != b.charAt(j)) {
                break;
            }
            ans+=a.charAt(i);
        }
        return ans;
    }
    public static String Divide(String arr[],int s,int e) {
        if (s >= e) {
            return arr[s] ;
        }
        int mid=s+(e-s)/2;
        String str1=Divide(arr, s, mid);
        String str2=Divide(arr, mid+1, e);
        return Conquror(str1, str2);
    }
    public static void main(String[] args) {
        String arr[]={"apple","apply","application","appliances"};
       
         System.out.println(Divide(arr, 0, arr.length-1));

    }
}
