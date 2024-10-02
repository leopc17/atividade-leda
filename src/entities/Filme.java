package entities;

import interfaces.Filme_IF;

public class Filme implements Filme_IF {

    private long ID;
    private String nome;
    private int nota;
    private int ano;

    public Filme() {

    }

    public Filme(String nome, int nota, int ano, int ID) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
        this.ID = ID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF o) {
        if (this.nota != o.getNota()) {
            return Integer.compare(this.nota, o.getNota()) * (-1);
        } else if (this.ano != o.getAno()) {
            return Integer.compare(this.ano, o.getAno());
        } else {
            return this.nome.compareTo(o.getNome());
        }
    }

    @Override
    public String toString() {
        return getNome() + " (" + getAno() +") [" + getNota() + "]";
    }
}
