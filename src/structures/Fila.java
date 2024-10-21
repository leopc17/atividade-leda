package structures;

import interfaces.Fila_IF;
import interfaces.Filme_IF;

public class Fila implements Fila_IF {

    private final Pilha p1;
    private final Pilha p2;
    private int size;

    public Fila() {
        this.p1 = new Pilha();
        this.p2 = new Pilha();
    }

    public int getSize() {
        return size;
    }

    @Override
    public Filme_IF dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia");
        }

        while (!p1.isEmpty()) {
            p2.push(p1.pop());
        }
        Filme_IF aux = p2.pop();
        while (!p2.isEmpty()) {
            p1.push(p2.pop());
        }
        size--;
        return aux;
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        p1.push(elemento);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty();
    }

    @Override
    public Filme_IF head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia");
        }

        while (!p1.isEmpty()) {
            p2.push(p1.pop());
        }
        Filme_IF aux = p2.top();

        while (!p2.isEmpty()) {
            p1.push(p2.pop());
        }

        return aux;
    }

    public void print() throws Exception {
        Filme_IF ultimoFila = p1.top();
//        System.out.println("TOP = " + ultimoFila);

        while (!p1.isEmpty()) {
            p2.push(p1.pop());
        }

        while (!p2.isEmpty()) {
            Filme_IF aux = p2.pop();
            if(aux == ultimoFila) {
                System.out.println(aux);
            } else {
                System.out.print(aux + ", ");
            }
            p1.push(aux);
        }
    }
}
