public class stackUsingArray{
   static int arraySize=0;
    static class stack{
        int []a;
        int size;
        int top;
        stack(int size){
            this.size=size;
            a=new int[size];
            top=-1;
        }

        void push(int element){
           top++;
          if(top == size) return;

          a[top]=element;
          arraySize++;
        }

        int pop(){
          if(top == -1)return 0;
          int ans=a[top];
          top--;
          arraySize--;
          return ans;
        }
        int peek(){
            return a[top];
        }
        int size(){
          return arraySize;
        }
        boolean isEmpty(){
            return top==-1;
        }
    }
    public static void main(String[] args) {
        stack s=new stack(3);
        
        s.push(2);
        s.push(5);
        s.push(8);

           System.out.println(s.size());
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}