package Play_with_Data_Structures.Demo12SegmentTree;

public class SegmentTree <E>{
    private E[] tree; // 当前区间分配的静态节点个数
    private E[] data; // 存储节点的数组
    private Merger<E> merger; // 区间节点处理函数

    public SegmentTree(E[] arr, Merger<E> merger){

        this.merger = merger; //

        // 初始化传入的数组值
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        // 开辟线段树的静态空间 4n
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    // 类型E 不一定定义了加法，需要设置一个新的接口
    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            // 递归终止，左右节点相等
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // int mid = (l + r) / 2; // 可能有整形溢出的问题
        int mid = l + (r -l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        return data[index];
    }

    // 返回完全二叉树的数组表示，一个索引表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示，一个索引表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(',');
        }
        res.append(']');
        return res.toString();

    }
}
