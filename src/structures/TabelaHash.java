package structures;

import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;

public class TabelaHash implements TabelaHash_IF {

    private ListaEncadeada[] t;
    private int tam;

    public TabelaHash(int tam) {
        this.tam = tam;
        this.t = new ListaEncadeada[tam];
        for (int i = 0; i < tam; i++) {
            t[i] = new ListaEncadeada();
        }
    }

    private int hash(long ID) {
        return (int) (ID % t.length);
    }

    public Filme_IF[] toArray() {
        if (isEmpty()) {
            return new Filme_IF[0];
        }

        ListaEncadeada aux = new ListaEncadeada();
        for (int i = 0; i < tam; i++) {
            Filme_IF[] vetor = t[i].toArray();
            for (int j = 0; j < vetor.length; j++) {
                aux.insert(vetor[j]);
            }
        }

        return aux.toArray();
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        int indice = hash(id);
        try {
            return t[indice].remove(id);
        } catch (Exception e) {
            throw new Exception("ID não encontrado");
        }
    }

    @Override
    public void insert(Filme_IF elemento) {
        int posicao = hash(elemento.getID());
        t[posicao].insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < t.length; i++) {
            if (!t[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        int indice = hash(id);
        return t[indice].search(id);
    }

    @Override
    public String print() {
        return aux();
    }

    private String aux() {
        try {
            String str = "";
            ListaEncadeada aux;
            for (int i = 0; i < tam; i++) {
                str += i + ":   ";
                aux = t[i];
                while (!aux.isEmpty()) {
                    if (aux.head() != null) {
                        str += aux.head() + ", ";
                    }
                    aux.remove(aux.head().getID());
                }
                str = str.substring(0, str.length()-2) + "\n";
                str = str.replaceAll(":   ", ": ");
            }
            return str;
        } catch (Exception e) {
            return "Erro: " + e.getMessage(); // só ocorre caso haja algum erro de implementação da lista
        }
    }
}
