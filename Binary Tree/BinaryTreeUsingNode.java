import java.util.*;

public class BinaryTreeUsingNode {
    class Node{
        int data ;
        Node left,right;
         Node(int data){
           this.data=data;
         }
       }
    Scanner sc;
    Node root;
   BinaryTreeUsingNode(){
  sc=new Scanner(System.in);
}
   Node creatingBinaryTree() {
    System.out.println("Enter a data");
    int data=sc.nextInt();

    if(data == -1) return null;

    Node node=new Node(data);
    System.out.println("enter "+data+" left data");
    node.left=creatingBinaryTree();

    System.out.println("enter "+data+" right data");
    node.right=creatingBinaryTree();
    return node;
 }    
  void inorder(Node root){
    if(root == null) return ;

    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  void preorder(Node root){
    if(root == null) return ;

    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
  }
  void postorder(Node root){
    if(root == null) return ;

    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+" ");
  }
  int height(Node root){
    if(root==null){
        return 0;
    }

    int lh=height(root.left);
    int rh=height(root.right);
    int max=Math.max(lh, rh)+1;
    return max;
  }
  void printNodeAtkFromRoot(Node root,int k){
    if (root==null)  return;
    if(k==0){
        System.out.print(root.data+" ");
        return;
    }
    printNodeAtkFromRoot(root.left, k-1);
    printNodeAtkFromRoot(root.right, k-1);
  }
  int size(Node root){
   if(root == null)return 0;
    
   int s1=size(root.left);
   int s2=size(root.right);
   return s1+s2+1;
  }
  int maximum(Node root){
    if(root == null)return 0; // for maximum
    if(root == null)return Integer.MAX_VALUE; // for minimum

    int lm=maximum(root.left);
    int rm=maximum(root.right);
    // return Math.max(lm, Math.max(rm, root.data)); // for maximum
     return Math.min(lm, Math.min(rm, root.data)); // for minimum
  }
  void Inorder(Node root){
    if (root==null) {
        return;
    }
    Stack<Node>s=new Stack<>();
    Node cur=root;
    while (cur != null || s.size()>0) {
        
        while (cur!=null) {
            s.push(cur);
            cur=cur.left;
        }
        cur=s.pop();
        System.out.print(cur.data+" ");

        cur=cur.right;
    }
  }
  void Preorder(Node root){
    if (root==null) {
        return;
    }
    Stack<Node>s=new Stack<>();
    Node cur=root;
    while (cur != null || s.size()>0) {
        
        while (cur!=null) {
         System.out.print(cur.data+" ");
            s.push(cur);
            cur=cur.left;
        }
        cur=s.pop();
        cur=cur.right;
    }
  }
  void Postorder(Node root){
    if (root==null) {
        return;
    }
    Stack<Node>s1=new Stack<>();
    Stack<Node>s2=new Stack<>();
    s1.push(root);
    while (!s1.isEmpty()) {
         Node temp=s1.pop();
         s2.push(temp);

         if(temp.left!=null){
            s1.push(temp.left);
         }
         if(temp.right!=null){
            s1.push(temp.right);
         }
    }

    while (!s2.isEmpty()) {
        System.out.print(s2.pop().data+" ");
    }
  }
    public static void main(String[] args) {
        BinaryTreeUsingNode B=new BinaryTreeUsingNode();

      Node root= B.creatingBinaryTree();

       B.Postorder(root);
    //   B.inorder(root);
    //   System.out.println();
    //   B.preorder(root);
    //   System.out.println();
    //   B.postorder(root);


    // System.out.println(B.height(root));
     
    // B.printNodeAtkFromRoot(root, 2);
    // System.out.println(B.size(root));
    // System.out.println(B.maximum(root));
}
}
