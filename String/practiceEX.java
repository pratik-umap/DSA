public class practiceEX {
    public static int compress(char arr[]) {
       int i=0;
       int ansidx=0;
       int n=arr.length;
       while (i < n) {
           int j=i+1;
           while (j < n && arr[i]==arr[j]) {
               j++;
           }
           arr[ansidx++]=arr[i];
           int count=j-i;
          if (count > 1) {
              String cnt= String.valueOf(count);
            for (char ch:cnt.toCharArray()) {
                arr[ansidx++]=ch;
            }
          }
          i = j;
       }
       return ansidx;
    }
    public static void main(String[] args) {
        char arr[]={'a','a','b','b','b','c','c','d'};

        int a=compress(arr);
        System.out.println(a);
    }
}
// string compression