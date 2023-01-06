package Trie;

public class Main {
    public static void main(String[] args) {
        Trie newTrie = new Trie();
        newTrie.insert("NITIN");
        newTrie.insert("NITI");
        System.out.println(newTrie.search("NITI"));
        newTrie.delete("NITI");
        System.out.println(newTrie.search("NITIN"));
    }
}
