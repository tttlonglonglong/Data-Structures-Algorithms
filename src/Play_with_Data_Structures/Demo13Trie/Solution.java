package Play_with_Data_Structures.Demo13Trie;
import java.util.TreeMap;


// 208. 实现 Trie (前缀树)
// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
public class Solution {
    private class Node{

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public Solution(){
        root = new Node();
    }

    // 向Trie中添加一个新单词 // 还可以用递归写法
    public void insert(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord){
            // 标识是否是跟节点
            cur.isWord = true;
        }
    }

    // 查询单词word是否在Trie中  // 递归可实现
    public boolean search(String word){

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        // 包含了这个单子的所有字符，但是不一定存储了这个单词
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean startsWith(String prefix){

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
