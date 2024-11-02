package structures;

import interfaces.Filme_IF;

public class NoLE {

    private Filme_IF dado;
    private NoLE prox;
    private NoLE ant;

    public NoLE() {

    }

    public NoLE(Filme_IF dado) {
        this.dado = dado;
    }

    public Filme_IF getDado() {
        return dado;
    }

    public void setDado(Filme_IF dado) {
        this.dado = dado;
    }

    public NoLE getProx() {
        return prox;
    }

    public void setProx(NoLE prox) {
        this.prox = prox;
    }

    public NoLE getAnt() {
        return ant;
    }

    public void setAnt(NoLE ant) {
        this.ant = ant;
    }

    public boolean isNIL() {
        return dado == null;
    }
}
