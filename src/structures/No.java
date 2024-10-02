package structures;

import interfaces.Filme_IF;

public class No {
    protected Filme_IF dado;
    protected No prox;
    protected No ant;

    public No() {

    }

    public No(Filme_IF dado) {
        this.dado = dado;
    }

    public boolean isNIL() {
        return dado == null;
    }
}
