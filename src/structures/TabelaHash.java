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
        try {
            return aux();
        } catch (Exception e) {
            return "Tabela Hash vazia!";
        }
    }

    private String aux() throws Exception {
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
    }
}
