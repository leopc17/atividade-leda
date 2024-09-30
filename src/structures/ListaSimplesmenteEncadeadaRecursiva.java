package structures;

import interfaces.LinkedList;

public class ListaSimplesmenteEncadeadaRecursiva<T> implements LinkedList<T> {

    protected T dado;
    protected ListaSimplesmenteEncadeadaRecursiva<T> prox;

    @Override
    public boolean isEmpty() {
        return dado == null;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + prox.size();
        }
    }

    @Override
    public T search(T element) {
        if (isEmpty()) {
            return null;
        } else {
            if (element == dado) {
                return dado;
            } else {
                return prox.search(element);
            }
        }
    }

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            dado = element;
            prox = new ListaSimplesmenteEncadeadaRecursiva<>();
        } else {
            prox.insert(element);
        }
    }

    @Override
    public void remove(T element) {
        if (isEmpty()) {
            return;
        } else {
            if (dado == element) {
                dado = prox.dado;
                prox = prox.prox;
            } else {
                prox.remove(element);
            }
        }
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println();
        } else {
            System.out.print(dado + " ");
            prox.print();
        }
    }
}
