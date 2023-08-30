import java.util.ArrayList;

public class stackAl {
//    static class stack{
//         // stack using array
//         int arr[];
//         int top=-1;
//         int size;
//          stack(int size){
//           this.size=size;
//           arr=new int[size];
//          }
 
//          public void push(int data){
//              if ( top <= size ) {
//                  top++;
//                  arr[top]=data;
//              }
//          }

//          public boolean isEmpty(){
//              return top==-1;
//          }

//          public int pop(){
//              if (isEmpty()) {
//                  System.out.println("stack underflow");
//              } 
//                  int value=arr[top];
//                  top--;
//                return value;
//          }

//          public int peek(){
//             if (isEmpty()) {
//                 System.out.println("stack underflow");
//             } 
//                return arr[top];
//          }
//     }
     
    static class Stack{
        // stack using arraylist
      ArrayList <Integer> list=new ArrayList<>();

       public void push(int data){
           list.add(data);
       }
       
       public boolean isEmpty(){
           return list.size()==0;
       }
       public int pop(){
           if (isEmpty()) {
               System.out.println("stack underflow");
           }
         return  list.remove(list.size()-1);
       }
       
       public int peek(){
        if (isEmpty()) {
            System.out.println("stack underflow");
        }
       return  list.get(list.size()-1);  
       }
    }
    public static void main(String[] args) {
        // using array
    //     stack s=new stack(5);
    //    s.push(1);
    //    s.push(2);
    //    s.push(3);
    //    s.push(4);

    //    while (! s.isEmpty()) {
    //        System.out.println(s.peek());
    //        s.pop();
    //    }

    //    using arraylist
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
 
        while (! s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
