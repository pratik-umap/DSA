import java.util.ArrayDeque;

public class classStack1 {
    public static boolean isOperator(char c) {
        return c == '+'|| c =='-' || c =='*' || c =='/';
    }
    public static int precedence(char cur) {
        if(cur=='/' || cur == '*') return 2;
        if(cur == '+' || cur == '-') return 1;
        else return -1;
    }
    public static int calculate(int a,int b,char c) {
        switch (c) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b; 
            case '/':
                return a/b;
        }
        return 0;
    }
    public static String infixToPostFix(String s) {
        ArrayDeque<Character>stack=new ArrayDeque<>();
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (cur =='(') {
                stack.push(cur);
            } else if(isOperator(cur)) {
                if (!stack.isEmpty() && precedence(cur) <= precedence(stack.peek())) {
                   ans.append(stack.pop());
                }
                stack.push(cur);
            }else if (cur == ')') {
               while (stack.peek()!= '(') {
                  ans.append(stack.pop());
               }
               stack.pop();
            }else{
                ans.append(cur);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
    public static int evaluatePostFix(String s) {
      ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (isOperator(cur)) {
                int second=stack.pop();
                int first=stack.pop();
                int eval=calculate(first, second, cur);
                stack.push(eval);
            }else{
                stack.push(cur-'0');
            }
        }
        return stack.pop();
    }
    public static String  infixToPrefix(String s) {
        ArrayDeque<Character>stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            char cur=s.charAt(i);
            if (cur==')') {
                // for opening 
                stack.push(cur);
            } else if(cur == '('){
                // for closing 
                while (stack.peek() != ')') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(isOperator(cur)){
               if (!stack.isEmpty() && precedence(cur) < precedence(stack.peek())) {
                sb.append(stack.pop());
               }
               stack.push(cur);
            }else{
               sb.append(cur);
            }
        }
        while (!stack.isEmpty()) {
           sb.append(stack.pop());
        }
        return sb.toString();
    }
    public static int evaluationPrefix(String s) {
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (isOperator(cur)) {
                int first=stack.pop();
                int second=stack.pop();
                int eval=calculate(first, second, cur);
                stack.push(eval);
            } else {
              stack.push(cur-'0');
            }
        }
       return stack.pop();
    }
    public static String postfixToPrefix(String s) {
        StringBuilder sb=new StringBuilder();
        ArrayDeque<Integer>stack=new ArrayDeque<>();
        for (int i = 0; i <s.length(); i++) {
            char cur=s.charAt(i);
           if (isOperator(cur)) {
               int ans2=stack.pop();
               if (!stack.isEmpty()) {
                int ans1=stack.pop();
                sb.append(cur);
                sb.append(ans1);
                sb.append(ans2);
                continue;
               }
               sb.append(cur);
               sb.append(ans2);
           } else {
              stack.push(cur-'0');
           }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // String s="(a+b)*(c/d-f)+h";
        String s="(2+3)(5/6)";
        // String s="12+";
        String output=infixToPostFix(s);
        // String o=postfixToPrefix(output);
        System.out.println(output);
        // System.out.println(o);
        // System.out.println(evaluationPrefix(output));
        // for (int i = output.length()-1; i >= 0; i--) {
        //     System.out.print(output.charAt(i));
        // }

        // System.out.println(evaluatePostFix(output));
    }
}
