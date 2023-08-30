import java.util.ArrayList;

public class btToHeap {
    static class Node{
        int data;
        Node left , right;

        // Node(){
        //     this.data=0;
        //     this.left=this.right=null;
        // }
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root,ArrayList<Integer>arr) {
        if (root==null) {
            return;
        }
         
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    static int idx=0;
    public static void arrTOMeanheap(Node root,ArrayList<Integer>arr) {
        if (root==null) {
            return;
        }
 
        root.data=arr.get(idx++);
        arrTOMeanheap(root.left, arr);
        arrTOMeanheap(root.right, arr);
    }
    public static void ConvertMinHeap(Node root) {
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(root, arr);

        arrTOMeanheap(root, arr);
    }
    public static void main(String[] args) {
        // convert binary tree to min heap
        Node root=new Node(4);
        root.left=new Node(2);
        root.right=new Node(6);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
        root.right.left=new Node(5);
        root.right.right=new Node(7);

        System.out.println("preorder traversal before conversion");
        preorder(root);

        ConvertMinHeap(root);
        System.out.println();
        System.out.println("preoreder traversal after conversion");

        preorder(root);


    }
}
