package utils;

import entities.Filme;
import interfaces.Fila_IF;
import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import structures.Fila;

public class GerenciadorFilmesFila implements GerenciadorFilmes_IF {

    private final Fila fila = new Fila();

    @Override
    public void inserir(Filme_IF elemento) {
        fila.enqueue(elemento);
    }

    @Override
    public Filme_IF buscar(long id) throws Exception {
        return fila.buscar(id);
    }

    @Override
    public Filme_IF remover(long id) throws Exception {
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
    public Filme_IF[] ordenar() throws Exception {
        int t = fila.getSize();
        Filme_IF[] vetor = new Filme[t];

        for (int i = 0; i < t; i++) {
            Filme_IF aux = fila.dequeue();
            vetor[i] = aux;
            fila.enqueue(aux);
        }

        Ordenacao.mergeSort(vetor);
        return vetor;
    }
}
