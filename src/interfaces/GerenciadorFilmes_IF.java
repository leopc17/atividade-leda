package interfaces;

public interface GerenciadorFilmes_IF {
    void inserir(Filme_IF elemento);
    Filme_IF buscar(int id) throws Exception;
    Filme_IF remover(int id) throws Exception;
    void ordenar();
}
