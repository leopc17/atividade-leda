package entities;

import interfaces.Filme_IF;

public class Filme implements Filme_IF {
    private String nome;
    private int nota;
    private int ano;

    public Filme(String nome, int nota, int ano) {
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
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
            return Double.compare(this.nota, o.getNota()) * (-1);
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
