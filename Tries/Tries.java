public class Tries {

   static class TrieNode{
        TrieNode children[];
       boolean isTerminal;

       TrieNode(){
            children=new TrieNode[26];

           for(int i=0;i<26;i++){
               children[i]=null;
           }

           isTerminal=false;
       }
   }
    public  static class Trie{
        public static TrieNode root;

        Trie(){
            root=new TrieNode();
        }
          // insert element
        public static void insert(String word) {
            TrieNode current = root;
    
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
    
                if (current.children[index] == null) {
                    current.children[index]= new TrieNode();
                }
    
                current = current.children[index];
            }
    
            current.isTerminal = true;
        }

         // search element
    public static boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isTerminal;
     }

    public static boolean isEmpty(TrieNode root){
            
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
     }
    public  static TrieNode deleteUtil(TrieNode root,String word, int i){
          if (root==null) {
              return null;
          }
          if (i == word.length()) {
              if (root.isTerminal) {
                  root.isTerminal=false;
              }
              if (isEmpty(root)) {
                  root=null;
              }
              return root;
            }
            int index=word.charAt(i)-'a';

            root.children[index]=deleteUtil(root.children[index], word, i+1);

            if (isEmpty(root) && root.isTerminal==false) {
                root=null;
            }
            return root;
          }
          public static TrieNode delete(String word) {
              return deleteUtil(root, word, 0);
          }
    }

    public static void main(String[] args) {
        
        Trie t=new Trie();
        t.insert("pratik");
       t.insert("umap");
       t.delete("pratik");


         System.out.println(t.search("pratik"));
         System.out.println(t.search("uma"));

    }
    
}