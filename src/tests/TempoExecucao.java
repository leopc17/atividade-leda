package tests;

import entities.Filme;
import utils.Ordenacao;

public class TempoExecucao {

    private static final Ordenacao o = new Ordenacao();

    public static long testeBubble(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.bubbleSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeSelection(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.selectionSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeInsertion(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.insertionSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeQuick(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.quickSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeQuickRandom(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.quickSortRandom(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeMerge(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.mergeSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }

    public static long testeCounting(Filme[] vetor) {
        long inicio = System.nanoTime();
        o.countingSort(vetor);
        long fim = System.nanoTime();

        return fim - inicio;
    }
}
