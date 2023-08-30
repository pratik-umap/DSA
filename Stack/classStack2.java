import java.util.*;

public class classStack2 {
    
  static class implement2StackUsing1Array{
    int a[];
    int top1,top2;
    implement2StackUsing1Array(int capacity){
        a=new int[capacity];
        top1=-1;
        top2=capacity;
    }
   void push1(int data){
     if (top1+1 < top2) {
        top1++;
        a[top1]=data;
     }else{
        System.out.println("can,t do push1");
     }
   }
   void push2(int data){
    if (top1+1 < top2) {
        top2--;
        a[top2]=data;
     }else{
        System.out.println("can,t do push2");
     }
   }
   int pop1(){
      if (top1 > -1) {
        int res=a[top1];
        top1--;
        return res;
      }
      return 0;
   }
   int pop2(){
    if (top2 < a.length) {
        int res=a[top2];
        top2++;
        return res;
      }
      return 0;
   }
  }
   public static int maxAreaInHistogram(int a[]) {
      int max=0;

          for (int i = 0; i < a.length; i++) {
            int l=i,r=i;
            while(l >=0 && a[l] >= a[i]) l--;

            while(r<a.length && a[r] >= a[i]) r++;

            int width= (r-l-1);
            int maxArea= a[i] * width;

            max=Math.max(max, maxArea);
          }
      return max;  
   }
   public static int[] previousSmallerElement(int[]a) {
      int ans[]=new int[a.length];
      int j=0;
      ArrayDeque<Integer>stack=new ArrayDeque<>();
      for (int i =0;i<a.length;i++) {
          while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
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
      int j=a.length-1;
      ArrayDeque<Integer>stack=new ArrayDeque<>();
      for (int i =a.length-1;i>=0;i--) {
          while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
              stack.pop();
          }
         if (stack.isEmpty()) {
          ans[j]=-1;
         }else{
          ans[j]=stack.peek();
         }
         stack.push(i);
         j--;
      }
      return ans;
  }
  public static int maxAreaInHistogramOptimised(int []a) {
    int[]ps=previousSmallerElement(a);
    int[]ns=nextSmallerElement(a);
     int max=0;
     for (int i = 0; i < a.length; i++) {
      int width=ns[i]-ps[i]-1;
      int maxArea=a[i]*width;
       max=Math.max(max, maxArea);
     }
    return max;
  }
  public static int findMaxAreaInSubmatrix(int a[][]) {
     int b[]=new int[a[0].length];
     int max=0;

     for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
         if (a[i][j]==0) {
            b[j]=0;
         } else {
            b[j]++;
         }
      }
      int cur=maxAreaInHistogramOptimised(b);
      max=Math.max(max, cur);
     }
   return max;
  }
   static class minStack{
    ArrayDeque<Integer>stack=new ArrayDeque<>();
    ArrayDeque<Integer>minStack=new ArrayDeque<>();

    void push(int data){
      stack.push(data);
      if (minStack.isEmpty()) {
         minStack.push(data);
      }
      if ( data <= minStack.peek()) {
         minStack.push(data);
      }
    }
    int pop(){
       int ans=stack.pop();
       if(ans == minStack.peek()){
         minStack.pop();
       }
       return ans;
    }
    int min(){
      return minStack.peek();
    }
   }
    public static void main(String[] args) {

   //  int a[]={3,1,5,4,3,2};
   //   System.out.println(maxAreaInHistogram(a));
   //    System.out.println(maxAreaInHistogramOptimised(a));

   // int a[][]={
   //     {1,0,1,0},
   //     {1,1,1,1},
   //     {1,1,1,1},
   //     {1,1,1,0}
   // };
   //   System.out.println(findMaxAreaInSubmatrix(a));

   //   implement2StackUsing1Array s=new implement2StackUsing1Array(5);

   // minStack s=new minStack();
   //  s.push(5);
   //  s.push(10);
   //  System.out.println(s.min());
   //  s.push(1);
   //  s.push(3);
   //  System.out.println(s.min());
   //  s.pop();
   //  s.pop();
   //  System.out.println(s.min());

      //   s.push1(5);
      //   s.push1(2);
      //   s.push1(1);
      //   s.push2(10);
      //   s.push2(20);

      //   System.out.println(s.pop1());
      //   System.out.println(s.pop1());

      //   System.out.println(s.pop2());
      //   System.out.println(s.pop2());
      //   System.out.println(s.pop2());
  
       minElementInStack stack=new minElementInStack();
       stack.push(2);
       stack.push(5);
       System.out.println(stack.min());
       stack.push(1);
       stack.push(10);
      System.out.println(stack.min());
      System.out.println(stack.peek());
      stack.pop();
      stack.pop();
      System.out.println(stack.min());
      System.out.println(stack.peek());
   
    }
}

class minElementInStack{
    ArrayDeque<Integer>stack=new ArrayDeque<>();
    private int min=0;
     void push(int data){
        if(stack.isEmpty()){
          stack.push(data);
          min=data;
          return;
        }
        if (data >= stack.peek()) {
            stack.push(data);
        } else {
            stack.push(2*data-min);
            min=data;
        }
     }

    int pop(){
      int data= stack.peek();
      int ans=0;
       if (stack.isEmpty()) {
         System.out.println("stack is empty");
         return 0;
       }
       if (data > min) {
         ans=stack.pop();
       } else {
          ans=min;
         min=2*min-data;
         stack.pop();
       }
       return ans;
    }
    int min(){
       return min;
    }
    int peek(){
      int ans= stack.peek();
      if (ans > min) {
         return ans;
      }else
        return min;
    }
}