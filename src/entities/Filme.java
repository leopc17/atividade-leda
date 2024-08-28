package entities;

public class Filme implements Comparable<Filme> {
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
    public int compareTo(Filme o) {
        if (this.nota != o.nota) {
            return Integer.compare(this.nota, o.nota) * (-1); // provável gambiarra
        } else if (this.ano != o.ano) {
            return Integer.compare(this.ano, o.ano);
        } else {
            return this.nome.compareTo(o.nome);
        }
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", ano=" + ano +
                '}';
    }
}
