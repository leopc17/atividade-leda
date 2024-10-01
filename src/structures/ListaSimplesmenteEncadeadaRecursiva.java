package structures;

import entities.Filme;
import interfaces.LinkedList;

public class ListaSimplesmenteEncadeadaRecursiva implements LinkedList {

    protected Filme dado;
    protected ListaSimplesmenteEncadeadaRecursiva prox;

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
    public Filme search(int id) {
        if (isEmpty()) {
            return null;
        } else {
            if (dado.getId() == id) {
                return dado;
            } else {
                return prox.search(id);
            }
        }
    }

    @Override
    public void insert(Filme f) {
        if (isEmpty()) {
            dado = f;
            prox = new ListaSimplesmenteEncadeadaRecursiva();
        } else {
            prox.insert(f);
        }
    }

    @Override
    public void remove(int id) {
        if (isEmpty()) {
            return;
        } else {
            if (dado.getId() == id) {
                dado = prox.dado;
                prox = prox.prox;
            } else {
                prox.remove(id);
            }
        }
    }

    @Override
    public Filme[] toArray() {
        int t = size();
        Filme[] resultado = new Filme[t];
        toArray(resultado, this, 0);
        return resultado;
    }

    private void toArray(Filme[] array, ListaSimplesmenteEncadeadaRecursiva no, int indice) {
        if (!no.isEmpty()) {
            array[indice] = no.dado;
            toArray(array, no.prox, indice + 1);
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println();
        } else {
            System.out.print(dado + ", ");
            prox.print();
        }
    }
}
