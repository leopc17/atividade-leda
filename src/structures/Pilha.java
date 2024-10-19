package structures;

import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Pilha implements Pilha_IF {

    private final ListaEncadeada lista;

    public Pilha() {
        this.lista = new ListaEncadeada();
    }

    @Override
    public Filme_IF pop() throws Exception {
        if (lista.isEmpty()) {
            throw new Exception("Não é possivel remover elementos de uma pilha vazia");
        }

        long id = lista.tail().getID();
        return lista.remove(id);
    }

    @Override
    public void push(Filme_IF elemento) {
        lista.insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Filme_IF top() throws Exception {
        if (lista.isEmpty()) {
            throw new Exception("A pilha está vazia");
        }

        return lista.tail();
    }

    public void print() {
        lista.reversePrint();
    }
}
