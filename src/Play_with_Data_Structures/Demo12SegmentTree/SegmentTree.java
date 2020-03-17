package Play_with_Data_Structures.Demo12SegmentTree;

import java.util.Objects;

public class SegmentTree <E>{
    private E[] tree; // 当前区间分配的静态节点个数
    private E[] data; // 存储节点的数组
    public SegmentTree(E[] arr){
        // 初始化传入的数组值
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        tree = (E[])new Object[4 * arr.length];
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
}
