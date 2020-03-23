package Play_with_Data_Structures.Demo13Trie;

import java.util.TreeMap;

// 对于不同的语言，可以使用泛形C
public class Trie {
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
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新单词 // 还可以用递归写法
    public void add(String word){
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
            size ++;
        }
    }

    // 查询单词word是否在Trie中  // 递归可实现
    public boolean contains(String word){

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
    public boolean isPrefix(String prefix){

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
