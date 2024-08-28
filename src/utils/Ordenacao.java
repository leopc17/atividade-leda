package utils;

import entities.Filme;

public class Ordenacao {

    public static void insertionSort(Filme[] vetor) {
        for (int j = 1; j < vetor.length; j++) {
            Filme chave = vetor[j];
            int i = j - 1;

            while (i >= 0 & vetor[i].compareTo(chave) > 0) {
                vetor[i + 1] = vetor[i];
                i = i - 1;
            }
            vetor[i + 1] = chave;
        }
    }
}
