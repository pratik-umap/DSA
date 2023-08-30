import java.util.*;

public class Trie {
    TrieNode root;
    Trie(){
        root=new TrieNode();
        
    }
    class TrieNode{
        Map<Character,TrieNode>map;
        boolean EndOfWord;
        TrieNode(){
            map= new HashMap<>();
        }
    }
    void insert(String s){
        if (s==null || s.length()==0) return ;

        TrieNode cur=root;
        for (int i = 0; i < s.length(); i++) {
            char letter=s.charAt(i);
            if (!cur.map.containsKey(letter)) {
                TrieNode newNode=new TrieNode();
                cur.map.put(letter, newNode);
            }
            cur=cur.map.get(letter);
        }
        cur.EndOfWord=true;
    }

    boolean search(String s){   
        if (s==null || s.length()==0) return false;

        TrieNode cur=root;
        for (int i = 0; i < s.length(); i++) {
            char letter=s.charAt(i);
            if (!cur.map.containsKey(letter)) {
                return false;
            }
            cur=cur.map.get(letter);
        }
        return cur.EndOfWord;
    }
    boolean delete(String s){
        if (s==null || s.length()==0) return false;
        TrieNode cur=root;    
        TrieNode nodeTodelete=null;
        char charTodelete='/';

        for (int i = 0; i < s.length(); i++) {
            char letter=s.charAt(i);
            if (!cur.map.containsKey(letter)) {
                return false;
            }
            if (cur.map.size() > 1 || cur.EndOfWord) {
                nodeTodelete=cur;
                charTodelete=letter;
            }
            cur=cur.map.get(letter);
        }
          if(!cur.EndOfWord) return false;
        if (cur.map.isEmpty()) {
            nodeTodelete.map.remove(charTodelete);
        }else{
            cur.EndOfWord=false;
        }
        return true;
    }
    // public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
    //     if (root.EndOfWord) {
    //         list.add(curr.toString());
    //     }
 
    //     if (root.map == null || root.map.isEmpty())
    //         return;
 
    //     for (TrieNode child : root.map.values()) {
    //         suggestHelper(child, list, curr.append(child.c));
    //         curr.setLength(curr.length() - 1);
    //     }

    // }
 
    // public List<String> suggest(String prefix) {
    //     List<String> list = new ArrayList<>();
    //     TrieNode cur = root;
    //     StringBuffer curr = new StringBuffer();
    //     for (char c : prefix.toCharArray()) {
    //         cur = cur.map.get(c);
    //         if (cur == null)
    //             return list;
    //         curr.append(c);
    //     }
    //     suggestHelper(cur, list, curr);
    //     return list;
    // }
    public static void main(String[] args) {
        Trie t=new Trie();
          
        String[]dictionary={"hello", "dog", "hell", "cat", "a", "hel","help","helps","helping"};

        for (int i = 0; i < dictionary.length; i++) {
            t.insert(dictionary[i]);
        }
    //     System.out.println(t.search("dog"));
       System.out.println(t.delete("cat"));
        System.out.println(t.search("cat"));

    //    System.out.println(t.suggest("hel"));
    }
}


