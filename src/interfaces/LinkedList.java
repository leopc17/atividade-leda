package interfaces;

import entities.Filme;

public interface LinkedList {
    boolean isEmpty();
    int size();
    Filme search(int id);
    void insert(Filme f);
    void remove(int id);
    Filme[] toArray();
    void print();
}