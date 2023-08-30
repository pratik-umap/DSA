import java.util.Stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
public class stackProblem1 {
    
        static Node head;
        static Node add(int data){
            Node newNode =new Node(data);
            if (head == null) {
                head=newNode;
                return head;
            }
            newNode.next=head;
            head=newNode;
            return head;
        }
        static void printLL(Node head){
            Node cur=head;
            while (cur != null) {
                System.out.println(cur.data);
                cur=cur.next;
            }
        }
        static Node reverse(Node head){
            Node prev=null,cur=head;
            while (cur != null) {
                Node nextNode=cur.next;
                cur.next=prev;

                prev=cur;
                cur=nextNode;
            }
            return prev;
        }
    public static void deleteMidElement(Stack<Integer>stack,int n,int cur) {
        if(stack.empty() || cur == n){
            return;
        }
        int temp=stack.pop();
        deleteMidElement(stack, n, cur+1);
        if (cur != n/2) {
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
       stackProblem1 s=new stackProblem1();

       s.add(1);
       s.add(2);
       s.add(3);
       s.add(4);

    //    printLL(head);
       Node newNode= reverse(head);
        // printLL(newNode);
        Stack<Integer>stack=new Stack<>();
          stack.push(1);
          stack.push(2);
          stack.push(3);
          stack.push(4);
          stack.push(5);
       deleteMidElement(stack, stack.size(), 0);
       while (!stack.isEmpty()) {
           System.out.println(stack.peek());
           stack.pop();
       }


    }
}
