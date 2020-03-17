package Play_with_Data_Structures.Demo10MaxHeap;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);;
    E dequeue();
    E getFront();
}
