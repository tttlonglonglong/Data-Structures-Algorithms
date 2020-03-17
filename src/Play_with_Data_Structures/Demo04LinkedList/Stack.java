package Play_with_Data_Structures.Demo04LinkedList;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
