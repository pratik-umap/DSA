import java.util.*;

public class BinarySearchTree {
  
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    Node root;
    // BinarySearchTree(){
    //     root=null;
    // }

    public void insertHelp(int k){
     root= Insert(root, k);
    }
    public Node Insert(Node root,int k) {
        if (root==null) {
            root=new Node(k);
            return root;
        }

        if (k < root.data) {
            root.left=Insert(root.left, k);
        } else {
            root.right=Insert(root.right, k);
        }
        return root;
    }

    public  void levelorderHelp() {
        levelorder(root);
    }

    public static void levelorder(Node root){
        if(root==null){
            return;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode=q.remove();
            if (currNode==null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                
                System.out.print(currNode.data+" ");
                if(currNode.left !=null) {
                   q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }

    }
    public static void preorder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");

        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root) {
        if(root == null){
            return;
        }
        inorder(root.left);

        System.out.print(root.data+" ");

        inorder(root.right);
    }
    public static void postorder(Node root) {
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    public void print() {
        inorder(root);
        // System.out.println("min value is");
        // System.out.println(Minval(root));
        // System.out.println("max value is");
        // System.err.println(Maxval(root));
    }

    public static int Minval(Node root) {
        Node temp=root;
        while (temp.left !=null) {
            temp=temp.left;
        }
        return temp.data;
    }

    public static int Maxval(Node root) {
        Node temp=root;
        while (temp.right !=null) {
            temp=temp.right;
        }
        return temp.data;
    }
    static Node pred;
    static Node succ;
    public static void InorderPreSucc(Node root,int x) {
        // predessor

        if (root == null) {
            return;
        }
        if (root.data == x) {
       // predessor
       if (root.left != null) {
           Node temp=root.left;
           while (temp.right != null) 
               temp=temp.right;
           
               pred=temp;
       }  
      // succusor
       if (root.right != null) {
        Node temp=root.right;
        while (temp.left != null) 
            temp=temp.left;
        
            succ=temp;
    } 
      return;
        }
     if (x < root.data) {
        //  succ=root;
         InorderPreSucc(root.left, x);
     } else {
        //  pred=root;
         InorderPreSucc(root.right, x);
     }
    }
    public void print1() {
        
      InorderPreSucc(root, 30);
      if (pred != null) {
          System.out.println(pred.data);
      } 
      if (succ != null) {
          System.out.println(succ.data);
      }
    }

    public static Node DeleteNode(Node root, int x) {
        if (root==null) {
            return root;
        }
      
        if(x < root.data){
            root.left=DeleteNode(root.left,x);
        }else if(x > root.data){
            root.right=DeleteNode(root.right,x);
        }else{
            // one child
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }
             // two child
            root.data=minVal(root.right);
            // delete node
            root.right=DeleteNode(root.right,root.data);
        }
        return root;
    } 
    public  void print3(int x){
        DeleteNode(root,x);

     }
    public static int minVal(Node root){
        int min=root.data;
        while(root.left!=null){
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
   public static void main(String[] args) {
       
    BinarySearchTree tree =new BinarySearchTree();

    tree.insertHelp(50);
    tree.insertHelp(30);
    tree.insertHelp(20);
    tree.insertHelp(40);
    tree.insertHelp(70);
    tree.insertHelp(60);
    tree.insertHelp(80);
    
    // tree.levelorderHelp();
    // tree.print();
    // System.out.println();
    // tree.print1();

    tree.print3(30);
    tree.print();
   }
}