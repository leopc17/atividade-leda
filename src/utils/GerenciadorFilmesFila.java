package utils;

import interfaces.Fila_IF;
import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import structures.Fila;

public class GerenciadorFilmesFila implements GerenciadorFilmes_IF {

    private Fila_IF fila;

    public GerenciadorFilmesFila() {
        this.fila = new Fila();
    }

    @Override
    public void inserir(Filme_IF elemento) {
        fila.enqueue(elemento);
    }

    @Override
    public Filme_IF buscar(int id) throws Exception {
        Fila_IF aux = new Fila();

        while (fila.head().getID() != id || fila.isEmpty()) {
            aux.enqueue(fila.dequeue());
        }

        if (fila.isEmpty()) {
            throw new Exception("ID não encontrado");
        }

        Filme_IF filme = fila.head();

        while (!(aux.isEmpty())) {
            fila.enqueue(aux.dequeue());
        }

        return filme;
    }

    @Override
    public Filme_IF remover(int id) throws Exception {
        Fila_IF aux = new Fila();

        while (fila.head().getID() != id || fila.isEmpty()) {
            aux.enqueue(fila.dequeue());
        }

        if (fila.isEmpty()) {
            throw new Exception("ID não encontrado");
        }

        Filme_IF filme = fila.head();
        fila.dequeue();

        while (!(aux.isEmpty())) {
            fila.enqueue(aux.dequeue());
        }

        return filme;
    }

    @Override
    public void ordenar() {

    }
}
