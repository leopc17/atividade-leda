package interfaces;

public interface GerenciadorFilmes_IF {

    void inserir(Filme_IF elemento);

    Filme_IF buscar(long id) throws Exception;

    Filme_IF remover(long id) throws Exception;

    Filme_IF[] ordenar() throws Exception;
}