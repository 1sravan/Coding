import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    TrieNode root = new TrieNode();
    String[] wordsContainer;
    private int better(int oldIdx, int newIdx) {
        if (oldIdx == -1) {
            return newIdx;
        }

        int oldLen = wordsContainer[oldIdx].length();
        int newLen = wordsContainer[newIdx].length();

        if (newLen < oldLen) {
            return newIdx;
        }

        if (newLen == oldLen && newIdx < oldIdx) {
            return newIdx;
        }

        return oldIdx;
    }

    private void insert(String word, int idx) {

        TrieNode node = root;
        node.index = better(node.index, idx);
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
            node.index = better(node.index, idx);
        }
    }

    private int search(String query) {
        TrieNode node = root;
        for (int i = query.length() - 1; i >= 0; i--) {
            int ch = query.charAt(i) - 'a';
            if (node.children[ch] == null) {
                break;
            }
            node = node.children[ch];
        }
        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer,String[] wordsQuery) {
        this.wordsContainer = wordsContainer;
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
}
