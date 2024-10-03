package structures;

import interfaces.Filme_IF;

public class NoLE {

    protected Filme_IF dado;
    protected NoLE prox;
    protected NoLE ant;

    public NoLE() {

    }

    public NoLE(Filme_IF dado) {
        this.dado = dado;
    }

    public boolean isNIL() {
        return dado == null;
    }
}
