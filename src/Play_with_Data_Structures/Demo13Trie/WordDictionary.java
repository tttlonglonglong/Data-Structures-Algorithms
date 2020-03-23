package Play_with_Data_Structures.Demo13Trie;

import java.util.TreeMap;

class WordDictionary {
    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    // 当前查询的节点，搜索word字符串，搜索当前字符串的index个字符
    private boolean match(Node node, String word, int index) {
        // 递归结束条件
        if (index == word.length())
            return node.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            // 是否存在当前字符
            if (node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        } else {
            // node的所有字符都可以匹配这个点
            for (char nextChar : node.next.keySet())
                // 等于"."的时候，看是否能匹配到下一个字符
                if (match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }
}

