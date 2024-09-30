package interfaces;

public interface LinkedList<T> {
    boolean isEmpty();
    int size();
    T search(T element);
    void insert(T element);
    void remove(T element);
    T[] toArray();
    void print();
}