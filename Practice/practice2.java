package Practice;
import java.util.*;

public class practice2 {
     public static void printDiff() {
        int a[][]={{1,2,3},
                    {4,5,6},
                    {12,8,9}};
        int rowfirst=0,colfirst=0,colRow=0,last=a[0].length-1;
        int diagF=0,diagS=0;
        while (rowfirst< a.length) {
            // System.out.println(rowfirst+" "+colfirst+" "+colRow+" "+last);
            diagF+=a[rowfirst++][colfirst++];
            diagS+=a[colRow++][last--];
        }
        System.out.println(Math.abs(diagF-diagS));
     }
     public static void printbinaryToDecimal() {
        String s="011000100000110100100000";
        char arr[]={'0','1','2','3','4','5','6','7','8','9','+','-','*','/'};
        if (s.length() %4 !=0) {
            System.out.println("Invalid input");
        }else{
            for (int i = 0; i < s.length(); i+=4) {
                 String a=s.substring(i, i+4);
                 int idx=Integer.parseInt(a,2);
                char  value=arr[idx];
                //   System.out.println(value);
                if (value=='+' || value=='-' || value=='*' || value=='/') {
                    System.out.println();
                    System.out.println(value);
                } else {
                    System.out.print(value);
                }
            }
        }
     }
     public static void printLastPage() {
        int a=1,b=2,c=5;
        if (a <=0 || a > b || b<=0) {
            System.out.println("Invalid Input");
        } else {
            for (int i = 0; i < c-2; i++) {
                int ans=a+b;
                a=b;
                b=ans;
            }
            System.out.println(b);
        }
     }
     public static void cellInExcel() {
        String s="A1:A2";
        String arr[]=s.split(":");
         char firstChar=arr[0].charAt(0),secondChar=arr[1].charAt(0),firstNo=arr[0].charAt(1),secondNo=arr[1].charAt(1);
         
         int diffChar=Math.abs(Integer.valueOf(firstChar)-Integer.valueOf(secondChar))+1;
         int diffNo=Math.abs(Integer.valueOf(firstNo) - Integer.valueOf(secondNo))+1;
         System.out.println(diffChar*diffNo);
         
     }
     public static void reverseStringAndVowel() {
        String s="Language";
        StringBuilder sb=new StringBuilder();
         int cnt=1;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch=='a'|| ch=='e'|| ch=='i'||ch=='o'||ch=='u') {
               sb.append(cnt);
               cnt++;  
            }else{
                sb.append(ch);
            }
        }
         
        System.out.println(sb.reverse().toString());
     }
     public static boolean isThreeDigit(int n) {
        int cnt=0;
        while(n!=0){
            cnt++;
            n/=10;
        }
        if(cnt==3){
            return true;
        }
        return false;
     }
     public static void findThreeDigitNthNo() {
         int a[]={550,67,45,820,717,3,90,636,};
         int n=2;
         ArrayList<Integer>ans=new ArrayList<>();
          for (int i = 0; i < a.length; i++) {
            if (isThreeDigit(a[i])) {
                ans.add(a[i]);
            }
          }
          Collections.sort(ans);
          System.out.println(ans.get(n-1));
     }
     public static void placeInVaccineCentre() {
        String adhar="1234 5678 9123";
        String date="13/07/2006";
        String disAblity="no";
        if ( adhar.length()!=14 || date.length()!=10) {
            System.out.println("Invalid Input");
        } else {
            String arr[]=date.split("/");
             int ValidDate=2023 - Integer.parseInt(arr[2]);
                 if (ValidDate > 60 || disAblity=="yes") {
                    System.out.println(1);
                 } else if(ValidDate > 45) {
                    System.out.println(2);
                 }else if (ValidDate > 30) {
                    System.out.println(3);
                 }
        }
     }
     public static void costForDvelopingGarden() {
        int side=50,length=40,breath=35,price=65;
        int diff=(side * side) - (length * breath);
         diff= (diff * price) /100;
         System.out.println(diff);
     }
     public static void NoToString() {
        int n=123;
        String s=Integer.toString(n);
        // System.out.println(s);
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            sum+=Integer.valueOf(s.charAt(i))-'0';
            
            System.out.println(s.charAt(i));
        }
        System.out.println(sum);
     }
     public static void Armstrong(int n) {
        String s=Integer.toString(n);
        int a=s.length(),no=0;
        for (int i = 0; i < s.length(); i++) {
            int val =(Integer.valueOf(s.charAt(i))-'0');
            no+= Math.pow(val, a);
        }
        System.out.println(n+" "+no);
     }
     public static void replaceWithnextChar() {
        String s="abcdexyz";
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='z'){
                sb.append('a');
            }else{
                c=(char) (s.charAt(i) +1);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

     }
     public static void EMPOLYEE(String emp) {
        String empId[]={"019662","1234567","ABC12","KKBL45"};
        String name[]={"Sujata Nustana","Pratik Umap","Nureja","Harman"};
        int sal[]={90000,100000,25000,25000};
        String band[]={"7A","7A","6A","6A"};
        int i;
        for ( i = 0; i < band.length; i++) {
            if (empId[i].equals(emp)) {
                if (band[i] !="6A" && sal[i] >= 70000) {
                    System.out.println("EMP ID:"+empId[i]+", NAME:"+name[i]+", CURRENT SALARY:"+sal[i]+", BAND:"+band[i]);
                    break;
                }else{
                    System.out.println("NOT ELIGIBLE CANDIDATE");
                    break;
                }
            }
        }
        if (i==empId.length) {
            System.out.println("INVALID INPUT");
        }
     }
    public static void main(String[] args) {
        EMPOLYEE("123012");
        // printDiff();
        // printbinaryToDecimal();
        // printLastPage();
        //  cellInExcel();
        // reverseStringAndVowel();
        // findThreeDigitNthNo();
        // placeInVaccineCentre();
        // costForDvelopingGarden();
        // NoToString();
        // Armstrong(170);
        // replaceWithnextChar();
    }
}
