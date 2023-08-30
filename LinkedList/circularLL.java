import java.util.*;

public class circularLL {
    class Node{
        int data;
        Node next;

        Node(int data){
          this.data=data;
          this.next=null;
        }
    }
    public Node head=null;
    public Node tail=null;
    public void add(int data) {
      Node newnode=new Node(data);
      if(tail ==null){
       head=newnode;
       tail=newnode;
       newnode.next=head;
       return;
      }
      tail.next=newnode;
      tail=newnode;
      tail.next=head.next;
    }
    public void print(){
      if(head ==null){
        System.out.println("list is empty");
        return;
      }
      Node curr=head;
      do {
        System.out.print(curr.data+"->");
        curr=curr.next;
      } while (curr!=head);
    }
    public void delete(int  data){
      if (head==null) {
        System.out.println("list is empty");
      }
      Node prev=head;
      Node curr=head.next;
      while (curr.data != data) {
       curr=curr.next;
       prev=prev.next;
      }
      prev.next=curr.next;
      if (curr == prev) {
        tail=null;
      }
      if (tail==curr) {
        tail=prev;
      }
      curr.next=null;
    }
    public static Node isLoop(Node head){
      if (head==null) {
        return null;
      }
      Node slow =head;
      Node fast=head;
      while (slow != null || fast != null) {
        fast=fast.next;
        if (fast != null) {
          fast=fast.next;
        }
        slow=slow.next;

        if (slow == fast) {
          // System.out.println(slow.data);
          // System.out.println(fast.data);
          return slow;
        }
      }
      return slow;
    }
    public Node startNode(Node head){
      if (head==null) {
        return null;
      }
       Node presentNode=isLoop(head);
       Node slow=head;
       
       while (slow != null) {
         slow=slow.next;
         presentNode=presentNode.next;

         if (slow == presentNode) {
          System.out.println(slow.data);
           return slow;
         }
       }
       return slow;
    }
    public void removeLoop(Node head){
      if (head == null) {
        return;
      }
      Node presentNode=startNode(head);
      Node curr=presentNode;
      Node prev=head;
       while (curr.next != presentNode) {
         curr=curr.next;
         prev=prev.next;
         System.out.println(prev.data);
       }
       curr.next=null;
    }
    public static void main(String[] args) {
        circularLL list=new circularLL();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // list.print();
       System.out.println();
      //  if (isLoop(list.head)) {
      //    System.out.println("loop is present");
      //  } else {
      //    System.out.println("no loop");
      //  }
    //  list.head=list.startNode(list.head);
    
        list.removeLoop(list.head);
    
    }
}
