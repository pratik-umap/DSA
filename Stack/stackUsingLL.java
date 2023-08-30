public class stackUsingLL {
     static class Node{
        int data;
        Node next;
        Node(int data){
         this.data=data;   
        }
     }
     Node head;

     void push(int element){
        Node newNode=new Node(element);
        if (head==null) {
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    int pop(){
      if (head==null) {
        return 0;
      }
      int ans=head.data;
      head=head.next;
      return ans;
    }
    int peek(){
      return head.data;
    }
    boolean isEmpty(){
        return head==null;
    }
    public static void main(String[] args) {
      stackUsingLL l=new stackUsingLL();

      l.push(2);
      l.push(3);
      l.push(6);

      while (!l.isEmpty()) {
        System.out.println(l.peek());
        l.pop();
      }
    }
}
