package utils;

import entities.Filme;
import interfaces.Ordenacao_IF;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        return false;
    }

    @Override
    public void bubbleSort(Filme[] filmes) {

    }

    @Override
    public void selectionSort(Filme[] filmes) {

    }

    @Override
    public void insertionSort(Filme[] vetor) {
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

    @Override
    public void quickSort(Filme[] filmes) {

    }

    @Override
    public void quickSortRandom(Filme[] filmes) {

    }

    @Override
    public void mergeSort(Filme[] filmes) {

    }

    @Override
    public void countingSort(Filme[] filmes) {

    }
}
