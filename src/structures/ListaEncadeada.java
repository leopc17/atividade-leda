package structures;

import interfaces .Filme_IF;
import interfaces.Lista_IF;

public class ListaEncadeada implements Lista_IF {

    private NoLE head;
    private NoLE tail;

    public ListaEncadeada() {
        this.head = new NoLE();
        this.tail = head;
    }

    private Filme_IF removeFirst() {
        NoLE aux = new NoLE();

        if (!(head.isNIL())) {
            aux = head;
            head = head.prox;
            if(head.isNIL()) {
                tail = head;
            }
            head.ant = new NoLE();
        }

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
            NoLE aux = head;

            while (!(aux.isNIL()) && aux.dado.getID() != id) {
                aux = aux.prox;
            }

            if (!(aux.isNIL())) {
                aux.ant.prox = aux.prox;
                if (!aux.prox.isNIL()) {
                    aux.prox.ant = aux.ant; // Checa se não é o último elemento
                } else {
                    tail = aux.ant; // Atualiza o tail se for o último nó
                }
            }

            return aux.dado;
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        NoLE novo = new NoLE(elemento);
        novo.ant = tail;
        novo.prox = new NoLE();
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

        NoLE aux1 = head;
        NoLE aux2 = tail;

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
        NoLE aux = head;
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
            NoLE aux = head;
            while (!(aux.prox.isNIL())) {
                System.out.print(aux.dado + ", ");
                aux = aux.prox;
            }
            System.out.println(aux.dado);
        }
    }

    public void reversePrint() {
        if (isEmpty()) {
            System.out.println();
        } else {
            NoLE aux = tail;
            while (!(aux.ant.isNIL())) {
                System.out.print(aux.dado + ", ");
                aux = aux.ant;
            }
            System.out.println(aux.dado);
        }
    }
}