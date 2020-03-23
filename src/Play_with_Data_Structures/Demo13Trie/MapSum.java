package Play_with_Data_Structures.Demo13Trie;

import java.util.TreeMap;

//677. 键值映射
// https://leetcode-cn.com/problems/map-sum-pairs/
public class MapSum {
    private class Node {

//        public boolean isWord;
        public int value; // value是0 的时候表示单词不存在
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for(int i = 0 ; i < key.length() ; i ++){
            char c = key.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                // 前缀单词不存在
                return 0;
            cur = cur.next.get(c);
        }
        return sum(cur);

    }

    // 以node为根节点，获取所有节点的值的和
    private int sum(Node node){

        if (node.next.size() == 0)
            // 叶子节点，没有下一个
            return node.value;
        else {
            int res = node.value;
            for (char c : node.next.keySet())
                res += sum(node.next.get(c));

            return res;
        }
    }
}
