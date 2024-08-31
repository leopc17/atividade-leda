package utils;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.Ordenacao_IF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            if (filmes[i].compareTo(filmes[i + 1]) > 0) {
                return false;
            }
        }

        return true;
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
        quickSort(filmes, 0, filmes.length - 1);
    }

    private void quickSort(Filme[] A, int left, int right) {
        if (left < right) {
            int pivot = partition(A, left, right);
            quickSort(A, left, pivot - 1);
            quickSort(A, pivot + 1, right);
        }
    }

    private int partition(Filme[] A, int left, int right) {
        Filme p = A[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (A[i].compareTo(p) <= 0) {
                i++;
            } else if (A[j].compareTo(p) > 0) {
                j--;
            } else {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        swap(A, left, j);
        return j; // posição do pivot
    }

    private void swap(Filme[] A, int i, int j) {
        Filme temp = A[i];
        A[i] = A[j];
        A[j] = temp;
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
