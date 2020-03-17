package Play_with_Data_Structures.Demo01Array;

public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
//        data = new int[capacity];
        // data = new E[capacity]; // 历史遗留问题不支持这种语法
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 向所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在第index个位置插入一个新元素e
    public void add(int index, E e) {

        // index非法的情况
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Require index >= 0 and index < size");
        // 数组的扩容
        if (size == data.length)
            resize(2 * data.length);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    /// 对data进行了隐藏，用户只能通过get这个方法来获取静态数组data中的某一个索引对应的元素，不能直接获得静态数组
    /// 静态数组必须开一定量的空间，实际存储的元素可能使用不了那么多空间，没使用的空间，通过get方法用户永远无法查询没有使用的空间
    // 通过封装的方式保证了数据的安全
    public E get(int index) {
        // 判断索引是否合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public E getLast() {
        return get(size - 1); // 不用data[size-1],size=0的时候，会传一个不合法的索引进去
    }

    public E getFirst() {
        return get(0);
    }

    // 修改index索引位置的元素e
    void set(int index, E e) {
        // 判断索引是否合法
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            // == 和 equals：引用比较和值比较
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 寻找元素对应的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        // 未被引用的对象，启动垃圾回收
        data[size] = null; // loitering objects != memory leak:
        // 总容量的四分之一才缩容，算法优化
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个位置的元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e，用户知道要删除哪个，就不返回了
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public void resize(int newCapacit) {
        E[] newData = (E[]) new Object[newCapacit];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
