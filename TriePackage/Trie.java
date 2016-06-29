package TriePackage;
import java.util.HashMap;

class TrieNode {
    // Initialize your data structure here.
    public HashMap edges = new HashMap();
    public TrieNode() {

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insertSubString(root,word);
    }
    private void insertSubString(TrieNode head, String word){
        if(word.length() == 0){
            head.edges.put("END",null);
            return;
        }
        if(head.edges.containsKey(word.charAt(0))){
            TrieNode temp = (TrieNode)head.edges.get(word.charAt(0));
            insertSubString(temp, word.substring(1));
        }
        else{
            TrieNode newNode = new TrieNode();
            head.edges.put(word.charAt(0),newNode);
            insertSubString(newNode, word.substring(1));
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return searchSubString(root, word);
    }
    private boolean searchSubString(TrieNode head, String word){
        if(word.length() == 0 && head.edges.containsKey("END")) return true;
        else if( word.length() == 0 ) return false;
        if(head.edges.containsKey(word.charAt(0))){
            TrieNode temp = (TrieNode)head.edges.get(word.charAt(0));
            return searchSubString(temp, word.substring(1));
        }
        else{
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchPrefix(root, prefix);
    }
    private boolean searchPrefix(TrieNode head, String word) {
        if (word.length() == 0) return true;
        if (head.edges.containsKey(word.charAt(0))) {
            TrieNode temp = (TrieNode) head.edges.get(word.charAt(0));
            return searchPrefix(temp, word.substring(1));
        } else {
            return false;
        }
    }
}