public class MorrisTraversal {
    
   static class Node{
        int data;
        Node left,right;
        Node(int data){
         this.data=data;
         this.left=null;
         this.right=null;
        }
    }
   static class BinaryTree{
       static Node root;
    void morrisTraversal(Node root) {
       
       Node curr=root;
       while (curr !=null) {

           if(curr.left ==null){
             System.out.print(curr.data+" ");
            curr=curr.right;
           }else{
              Node pred=curr.left;
              while (pred.right!=null && pred.right != curr) {
                  pred=pred.right;
              }
            
              if (pred.right==null) {
                  pred.right=curr;
                  curr=curr.left;
              } else {
                  pred.right=null;
                  System.out.print(curr.data +" ");
                  curr=curr.right;
              }
           }

       }
   }
}
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.root=new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        tree.morrisTraversal(tree.root);
    }
}
