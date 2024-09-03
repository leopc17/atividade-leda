import utils.Busca;
import entities.Filme;
import interfaces.Busca_IF;
import interfaces.Ordenacao_IF;
import utils.Ordenacao;

public class Main {
    public static void main(String[] args) {
        Ordenacao_IF o = new Ordenacao();
        Busca_IF b = new Busca();

        Filme f1 = new Filme("A", 5, 2020);
        Filme f2 = new Filme("B", 4, 2090);
        Filme f3 = new Filme("C", 3, 1090);
        Filme f4 = new Filme("D", 1, 1899);
        Filme f5 = new Filme("E", 5, 2024);
        Filme f6 = new Filme("F", 5, 2024);

        Filme[] vetor = {f1, f2, f3, f4, f5, f6};

        System.out.println(o.checaVetorOrdenado(vetor));

        o.insertionSort(vetor);

        for (Filme f : vetor) System.out.println(f);

        System.out.println(o.checaVetorOrdenado(vetor));

        try {
            Filme f = b.buscaBinaria_iterativa(vetor, 5);
            System.out.println(f);
            f = b.buscaBinaria_recursiva(vetor, 5);
            System.out.println(f);
            f = b.buscaLinear_iterativa(vetor, 5);
            System.out.println(f);
            f = b.buscaLinear_recursiva(vetor, 5);
            System.out.println(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}