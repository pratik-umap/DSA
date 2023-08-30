package classQueue;
import java.util.ArrayDeque;

public class queueUsingTwoStack {
    
    static class twoStack{
        static ArrayDeque<Integer>s1=new ArrayDeque<>();
        static ArrayDeque<Integer>s2=new ArrayDeque<>();
     
        void push(int data){
             s1.push(data);
        }

         int pop(){
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int ans= s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return ans;
         }
        boolean isEmpty(){
            return s1.isEmpty();
        }

    }
    static class ImplementStackUsingTwoQueue{
        static ArrayDeque<Integer>q1=new ArrayDeque<>();
        static ArrayDeque<Integer>q2=new ArrayDeque<>();

         void push(int data){
            q1.add(data);
         }

        int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            while (!q1.isEmpty()) {
                q2.add(q1.pollLast());
            }
          int ans=q2.pollFirst();

          while (!q2.isEmpty()) {
            q1.add(q2.pollLast());
          }
          return ans;
        }

        int peek(){
           return q1.getLast();
        }
        boolean isEmpty(){
            return q1.isEmpty();
        }
    }
    static class ImplementStackUsingOneQueue{
        static ArrayDeque<Integer>q=new ArrayDeque<>();

         void push(int data){
            q.add(data);
         }

        int pop(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            
          return q.pollLast();
        }

        int peek(){
           return q.getLast();
        }
        boolean isEmpty(){
            return q.isEmpty();
        }
    }
    public static void main(String[] args) {
 
        ImplementStackUsingOneQueue s=new ImplementStackUsingOneQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    //   twoStack q=new twoStack();

    //   q.push(1);
    //   q.push(2);
    //   q.push(3);
   
    //    System.out.println(q.pop());
    //    System.out.println(q.pop());
    //    System.out.println(q.pop());
    //    System.out.println(q.pop());

    }
}
