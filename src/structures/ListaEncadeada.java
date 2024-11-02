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
            head = head.getProx();
            if(head.isNIL()) {
                tail = head;
            }
            head.setProx(new NoLE());
        }

        return aux.getDado();
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        if (head.getDado().getID() == id) {
            return removeFirst();
        } else {
            NoLE aux = head;

            while (!(aux.isNIL()) && aux.getDado().getID() != id) {
                aux = aux.getProx();
            }

            if (!(aux.isNIL())) {
                aux.getAnt().setProx(aux.getProx());
                if (!aux.getProx().isNIL()) {
                    aux.getProx().setAnt(aux.getAnt()); // Checa se não é o último elemento
                } else {
                    tail = aux.getAnt(); // Atualiza o tail se for o último nó
                }
            }

            return aux.getDado();
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        NoLE novo = new NoLE(elemento);
        novo.setAnt(tail);
        novo.setProx(new NoLE());
        tail.setProx(novo);

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

        while (aux1 != aux2 && aux1.getProx() != aux2 && aux1.getDado().getID() != id && aux2.getDado().getID() != id) {
            aux1 = aux1.getProx();
            aux2 = aux2.getAnt();
        }

        if (aux1.getDado().getID() != id && aux2.getDado().getID() != id) {
            throw new Exception("o ID não foi encontrado");
        }

        if (aux1.getDado().getID() == id) {
            return aux1.getDado();
        } else {
            return aux2.getDado();
        }
    }

    @Override
    public Filme_IF head() throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        return head.getDado();
    }

    @Override
    public Filme_IF tail() throws Exception {
        if(isEmpty()) {
            throw new Exception("A lista está vazia");
        }

        return tail.getDado();
    }

    @Override
    public int size() {
        int size = 0;
        NoLE aux = head;
        while (!(aux.isNIL())) {
            size++;
            aux = aux.getProx();
        }
        return size;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println();
        } else {
            NoLE aux = head;
            while (!(aux.getProx().isNIL())) {
                System.out.print(aux.getDado() + ", ");
                aux = aux.getProx();
            }
            System.out.println(aux.getDado());
        }
    }

    public void reversePrint() {
        if (isEmpty()) {
            System.out.println();
        } else {
            NoLE aux = tail;
            while (!(aux.getAnt().isNIL())) {
                System.out.print(aux.getDado() + ", ");
                aux = aux.getAnt();
            }
            System.out.println(aux.getDado());
        }
    }

    public Filme_IF[] toArray() {
        Filme_IF[] vetor = new Filme_IF[size()];
        NoLE aux = head;
        int contador = 0;
        while (!aux.isNIL()) {
            vetor[contador] = aux.getDado();
            aux = aux.getProx();
            contador++;
        }
        return vetor;
    }
}