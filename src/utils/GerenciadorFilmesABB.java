package utils;

import interfaces.BST_IF;
import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import structures.ABB;

public class GerenciadorFilmesABB implements GerenciadorFilmes_IF {

    private final BST_IF abb = new ABB();

    @Override
    public void inserir(Filme_IF elemento) {
        abb.insert(elemento);
    }

    @Override
    public Filme_IF buscar(long id) throws Exception {
        return abb.search(id);
    }

    @Override
    public Filme_IF remover(long id) throws Exception {
        return abb.remove(id);
    }

    @Override
    public Filme_IF[] ordenar() {
        Filme_IF[] vetor = abb.order();
        Ordenacao.mergeSort(vetor);
        return vetor;
    }
}
