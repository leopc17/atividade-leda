package utils;

import interfaces.Filme_IF;
import interfaces.GerenciadorFilmes_IF;
import structures.TabelaHash;

public class GerenciadorFilmesTH implements GerenciadorFilmes_IF {

    private TabelaHash t;

    public GerenciadorFilmesTH(int tam) {
        this.t = new TabelaHash(tam);
    }

    @Override
    public void inserir(Filme_IF elemento) {
        t.insert(elemento);
    }

    @Override
    public Filme_IF buscar(int id) throws Exception {
        return t.search(id);
    }

    @Override
    public Filme_IF remover(int id) throws Exception {
        return t.remove(id);
    }

    @Override
    public Filme_IF[] ordenar() {
        return t.toArray();
    }
}
