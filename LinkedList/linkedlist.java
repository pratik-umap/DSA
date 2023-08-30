import javax.sql.rowset.spi.SyncResolver;

public class linkedlist {
     private int size;
    linkedlist(){
      this.size=0;
    }
    node head;
    class node{
        String data;
         node next;

         node(String data){
             this.data=data;
             this.next=null;
            size++;
         }
    }
    // linked list using scratch
    public void addFirst(String data) {
        node newnode = new node(data);
        if (head == null) {
            head=newnode;
            return;
        }
   
        newnode.next=head;
        head=newnode;
        
    }

    public void addLast(String data) {
        node newnode = new node(data);
        if (head == null) {
            head=newnode;
            return;
        }
      node currnode=head;
      while (currnode.next != null) {
          currnode=currnode.next;
      }
      currnode.next=newnode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        node currnode = head;
        while (currnode != null) {
            System.out.print(currnode.data +" -> ");
            currnode=currnode.next;
        }
        System.out.print("NUll");
        System.out.println();
    }

    public void deleteFirst() {
        if (head==null) {
            System.out.println("list is empty");
        }
        size--;
        head=head.next;
    }
    public void deleteLast() {
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
         size--;
        if (head.next == null) {
            head=null;
            return;
        }
        node secondnode=head;
        node lastnode=head.next;
        while (lastnode.next != null) {
            lastnode=lastnode.next;
            secondnode=secondnode.next;
        }
        secondnode.next=null;
    }

    public int getSize() {
        return size;
    }

     public void reverseIteration(){
      if (head==null || head.next==null) {
          return;
      }
      node prevnode=null;
      node currnode=head;
      while (currnode != null) {
          node nextnode=currnode.next;
          currnode.next=prevnode;

          prevnode=currnode;
          currnode=nextnode;
      }
    //    head.next=null;
       head=prevnode;
     } 

     public node reverseRecursion(node head) {
        if (head==null || head.next==null) {
            return head;
        }
        // System.out.println(head.data);
      node newhead= reverseRecursion(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;

     }
    public static void main(String[] args) {
      linkedlist list= new linkedlist();
       list.addFirst("4");
       list.addFirst("3");
       list.addFirst("2");
       list.addFirst("1");
       list.printList();

    //  list.reverseIteration();
    //  list.printList();
       
    
     list.head= list.reverseRecursion(list.head);
      list.printList();
    }
}



