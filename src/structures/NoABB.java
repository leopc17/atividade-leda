package structures;

import interfaces.Filme_IF;

public class NoABB {

    private Filme_IF dado;
    private NoABB esq;
    private NoABB dir;
    private NoABB pai;

    public NoABB() {

    }

    public NoABB(Filme_IF dado) {
        this.dado = dado;
        this.esq = new NoABB();
        this.dir = new NoABB();
        this.pai = new NoABB();
    }

    public NoABB(Filme_IF dado, NoABB pai) {
        this.dado = dado;
        this.esq = new NoABB();
        this.dir = new NoABB();
        this.pai = pai;
    }

    public Filme_IF getDado() {
        return dado;
    }

    public void setDado(Filme_IF dado) {
        this.dado = dado;
    }

    public NoABB getEsq() {
        return esq;
    }

    public void setEsq(NoABB esq) {
        this.esq = esq;
    }

    public NoABB getDir() {
        return dir;
    }

    public void setDir(NoABB dir) {
        this.dir = dir;
    }

    public NoABB getPai() {
        return pai;
    }

    public void setPai(NoABB pai) {
        this.pai = pai;
    }

    public boolean isNIL() {
        return dado == null;
    }
}
