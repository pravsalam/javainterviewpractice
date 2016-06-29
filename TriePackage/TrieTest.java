package TriePackage;

/**
 * Created by praveenkumaralam on 8/30/15.
 */
public class TrieTest {
    public static void main(String[] args){
        Trie trieRoot = new Trie();
        trieRoot.insert("abc");
        if(trieRoot.search("abc")) System.out.println("true");else System.out.println("false");
        if(trieRoot.search("ab")) System.out.println("true");else System.out.println("false");
        trieRoot.insert("ab");
        if(trieRoot.search("ab")) System.out.println("true");else System.out.println("false");
        trieRoot.insert("ab");
        if(trieRoot.search("ab")) System.out.println("true");else System.out.println("false");
    }
}
