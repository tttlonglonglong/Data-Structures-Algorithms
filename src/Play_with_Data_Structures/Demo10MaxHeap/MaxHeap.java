package Play_with_Data_Structures.Demo10MaxHeap;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1); i >= 0 ; i--)
            shiftDown(i);
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 dosn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        shiftUp(data.getSize()-1);
    }
    // 于父节点比较上浮
    private void shiftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    // 找出堆中的最大元素
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when is empty");
        return data.get(0);

    }
    // 取出堆中的最大元素
    public E extractMax(){
        E ret = findMax();

        data.swap(0 ,data.getSize()-1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    // 栈顶元素下沉
    public void shiftDown(int k){

        while(leftChild(k) < data.getSize()){
            int j = leftChild(k); // 此轮循环，data[k] 和 data[j] 交换位置
            // j 是左孩子，j+1是右孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j++; // j = rightChild(k) == j++ ; 右孩比较大，j存储右孩的索引
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }

}
