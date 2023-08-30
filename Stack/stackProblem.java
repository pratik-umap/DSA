import java.util.*;

public class stackProblem {
    public static boolean patternMatching(String s){
          ArrayDeque<Character>stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if(cur=='(' || cur=='{' || cur == '['){
              stack.push(cur);
            }
          char top='a';
            switch (cur) {
                case ')':
                top=stack.pop();
                    if(top != '(')return false;
                    break;
                case '}':
                top=stack.pop();
                    if(top != '{')return false;
                    break;
                case ']':
                top=stack.pop();
                if(top != '[')return false;
                break;
            }
        }
        return stack.isEmpty();
    }
    public static int[] previousSmallerElement(int[]a) {
        int ans[]=new int[a.length];
        int j=0;
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i : a) {
            while (!stack.isEmpty() && stack.peek() >= i) {
                stack.pop();
            }
           if (stack.isEmpty()) {
            ans[j]=-1;
           }else{
            ans[j]=stack.peek();
           }
           stack.push(i);
           j++;
        }
        return ans;
    }
    public static int[] nextSmallerElement(int[]a) {
        int ans[]=new int[a.length];
        int j=0;
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i =a.length-1;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }
           if (stack.isEmpty()) {
            ans[j]=-1;
           }else{
            ans[j]=stack.peek();
           }
           stack.push(a[i]);
           j++;
        }
        return ans;
    }
    public static int[] previousGreaterElement(int[]a) {
        int ans[]=new int[a.length];
        int j=0;
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i : a) {
            while (!stack.isEmpty() && stack.peek() <= i) {
                stack.pop();
            }
           if (stack.isEmpty()) {
            ans[j]=-1;
           }else{
            ans[j]=stack.peek();
           }
           stack.push(i);
           j++;
        }
        return ans;
    }
    public static int[] nextGreaterElement(int[]a) {
        int ans[]=new int[a.length];
        int j=0;
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i =a.length-1;i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
           if (stack.isEmpty()) {
            ans[j]=-1;
           }else{
            ans[j]=stack.peek();
           }
           stack.push(a[i]);
           j++;
        }
        return ans;
    }
    public static void reverseWordInGivenString(String s) {
         String[]token=s.split(" ");
        ArrayDeque<String>stack=new ArrayDeque<>();

        for (int i = 0; i < token.length; i++) {
             stack.push(token[i]);
        }
      
        while (!stack.isEmpty()) {
            System.out.print(stack.peek()+" ");
            stack.pop();
        }
    }
    public static void insertAtBottom(int data,Stack<Integer>s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top=s.pop();
        insertAtBottom(data, s);
        s.push(top);
    }
   public static void reverseStack(Stack<Integer>s) {
    if (s.isEmpty()) {
        return;
    }
         int top=s.pop();
         reverseStack(s);
         insertAtBottom(top, s);
   }
    public static void main(String[] args) {
        
        // String s="()a{b[]c}";
        // System.out.println(patternMatching(s));

        int[]a={5,1,2,3,9,6,1,4,3};
        int[]ans=nextGreaterElement(a);

        // for (int i=ans.length-1;i>=0;i--) {
        //     System.out.print(ans[i]+" ");
        // }

        String b="I am a Pratik";
        // reverseWordInGivenString(b);

      Stack<Integer>stack=new Stack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}




