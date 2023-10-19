package trie;

public class maxXor {
    public static void main(String[] args) {

    }

    static class TrieNodeInteger {
        TrieNodeInteger zero, one;
    }

    static void insert(TrieNodeInteger root, int n) {
        TrieNodeInteger currNode = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> 1) & 1;
            if (bit == 0) {
                if (currNode.zero == null) {
                    TrieNodeInteger newNode = new TrieNodeInteger();
                    currNode.zero = newNode;
                }
                currNode = currNode.zero;
            } else {
                if (currNode.one == null) {
                    TrieNodeInteger newNode = new TrieNodeInteger();
                    currNode.one = newNode;
                }
                currNode = currNode.one;
            }
        }
    }

    static int findMaxXor(TrieNodeInteger root, int n) {
        TrieNodeInteger currNode = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (currNode.zero != null) {
                    ans += (1 << i);
                    currNode = currNode.zero;
                } else {
                    currNode = currNode.one;
                }
            } else {
                if (currNode.one != null) {
                    ans += (0 << i);
                    currNode = currNode.one;
                } else {
                    currNode = currNode.zero;
                }
            }
        }
        return ans;
    }

    static int max_xor(int[] arr, int n) {
        TrieNodeInteger root = new TrieNodeInteger();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            insert(root, arr[i]);
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, findMaxXor(root, arr[i]));
        }
        return ans;
    }
}
