package trie;
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

public class Trie {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        insert(root, "apple");
        insert(root, "ball");
        insert(root, "cat");
        System.out.println(search(root, "dog"));
    }

    static void insert(TrieNode root, String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            char curr = key.charAt(i);
            if (currNode.children[curr - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                currNode.children[curr - 'a'] = newNode;
            }
            currNode = currNode.children[curr - 'a'];
        }
        currNode.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            char curr = key.charAt(i);
            if (currNode.children[curr - 'a'] == null) return false;
            currNode = currNode.children[curr - 'a'];
        }
        return currNode.isEndOfWord;
    }
}