package utils;

import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import interfaces.Lista_IF;
import structures.ListaEncadeada;

public class GerenciadorFilmesLE implements GerenciadorFilmes_IF {

    private Lista_IF lista;

    public GerenciadorFilmesLE() {
        this.lista = new ListaEncadeada();
    }

    @Override
    public void inserir(Filme_IF elemento) {
        lista.insert(elemento);
    }

    @Override
    public Filme_IF buscar(int id) throws Exception {
        return lista.search(id);
    }

    @Override
    public Filme_IF remover(int id) throws Exception {
        return lista.remove(id);
    }

    @Override
    public void ordenar() {

    }
}
