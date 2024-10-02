package structures;

import interfaces.Filme_IF;
import interfaces.Lista_IF;

public class ListaEncadeada implements Lista_IF {

    private No head;
    private No tail;

    public ListaEncadeada() {
        this.head = new No();
        this.tail = head;
    }

    private Filme_IF removeFirst() {
        No aux = head;
        head = head.prox;
        tail = head;
        head.ant = new No();
        return aux.dado;
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        if (head.dado.getID() == id) {
            return removeFirst();
        } else {
            No aux = head;

            while (!(aux.isNIL()) && aux.dado.getID() != id) {
                aux = aux.prox;
            }

            if (aux.isNIL()) {
                throw new Exception("O id não foi encontrado");
            }

            if (aux.dado.getID() == id) {
                if (!(aux.isNIL())) {
                    aux.ant.prox = aux.prox;
                    aux.prox.ant = aux.ant;
                }
            }

            return aux.dado;
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        No novo = new No(elemento);
        novo.ant = tail;
        novo.prox = new No();
        tail.prox = novo;

        if(tail.isNIL()) {
            head = novo;
        }
        tail = novo;
    }

    @Override
    public boolean isEmpty() {
        return head.isNIL();
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (id < 0) {
            throw new Exception("o ID deve ser um valor positivo");
        }

        No aux1 = head;
        No aux2 = tail;

        while (aux1 != aux2 && aux1.prox != aux2 && aux1.dado.getID() != id && aux2.dado.getID() != id) {
            aux1 = aux1.prox;
            aux2 = aux2.ant;
        }

        if (aux1.dado.getID() != id && aux2.dado.getID() != id) {
            throw new Exception("o ID não foi encontrado");
        }

        if (aux1.dado.getID() == id) {
            return aux1.dado;
        } else {
            return aux2.dado;
        }
    }

    @Override
    public Filme_IF head() throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        return head.dado;
    }

    @Override
    public Filme_IF tail() throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        return tail.dado;
    }

    @Override
    public int size() {
        int size = 0;
        No aux = head;
        while (!(aux.isNIL())) {
            size++;
            aux = aux.prox;
        }
        return size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println();
        } else {
            No aux = head;
            while (!(aux.isNIL())) {
                System.out.print(aux.dado + ", ");
                aux = aux.prox;
            }
            System.out.println();
        }
    }
}
