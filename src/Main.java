import entities.Filme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static utils.Ordenacao.*;

public class Main {
    public static void main(String[] args) {

        Filme f1 = new Filme("A", 5, 2020);
        Filme f2 = new Filme("B", 4, 2090);
        Filme f3 = new Filme("C", 3, 1090);
        Filme f4 = new Filme("D", 1, 1899);
        Filme f5 = new Filme("E", 5, 2024);
        Filme f6 = new Filme("F", 5, 2024);

        Filme[] vetor = {f1, f2, f3, f4, f5, f6};

        insertionSort(vetor);

        for (Filme f : vetor) System.out.println(f);
    }
}