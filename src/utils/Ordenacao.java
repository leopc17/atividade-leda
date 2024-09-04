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
        if (filmes == null || filmes.length == 1) {
            return true;
        }

        for (int i = 0; i < filmes.length - 1; i++) {
            if (filmes[i].compareTo(filmes[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void bubbleSort(Filme[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            for (int j = 0; j < filmes.length - 1 - i; j++) {
                if (filmes[j].compareTo(filmes[j + 1]) > 0) {
                    troca(filmes, j, j + 1);
                }
            }
        }
    }

    @Override
    public void selectionSort(Filme[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < filmes.length; j++) {
                if (filmes[j].compareTo(filmes[menor]) < 0) {
                    menor = j;
                }
            }
            troca(filmes, i, menor);
        }
    }

    private static void troca(Filme[] vetor, int p1, int p2) {
        Filme aux = vetor[p1];
        vetor[p1] = vetor[p2];
        vetor[p2] = aux;
    }

    @Override
    public void insertionSort(Filme[] vetor) {
        for (int j = 1; j < vetor.length; j++) {
            Filme chave = vetor[j];
            int i = j - 1;

            while (i >= 0 && vetor[i].compareTo(chave) > 0) {
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
        embaralhar(filmes);
        quickSort(filmes, 0, filmes.length - 1);
    }

    private void embaralhar(Filme[] filmes) {
        List<Filme> lista = Arrays.asList(filmes);
        Collections.shuffle(lista);
    }

    @Override
    public void mergeSort(Filme[] filmes) {
        int tam = filmes.length;
        if(tam <= 1)
            return;
        int meio = tam / 2;
        Filme[] left = new Filme[meio];
        Filme[] right = new Filme[tam - meio];
        int i = 0;
        int j = 0;
        for(; i < tam; i++){
            if(i < meio){
                left[i] = filmes[i];
            }
            else{
                right[j] = filmes[i];
                j++;
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, filmes);
    }

    public static void merge(Filme[] left, Filme[] right, Filme[] filmes){
        int leftSize = filmes.length / 2;
        int rightSize = filmes.length - leftSize;
        int i = 0,l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if(left[l].compareTo(right[r]) <= 0){
                filmes[i] = left[l];
                i++;
                l++;
            }else{
                filmes[i] = right[r];
                i++;
                r++;
            }
        }

        while(l < leftSize){
            filmes[i] = left[l];
            i++;
            l++;
        }

        while (r < rightSize){
            filmes[i] = right[r];
            i++;
            r++;
        }
    }

    @Override
    public void countingSort(Filme[] filmes) {
        int n = filmes.length;
        final int k = 5;

        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
        for (int j = 0; j < n; j++) {
            C[(int) filmes[j].getNota()]++;
        }

        for (int i = k - 1; i >= 0; i--) {
            C[i] += C[i + 1];
        }

        Filme[] B = new Filme[n];
        for (int j = n - 1; j >= 0; j--) {
            B[C[(int) filmes[j].getNota()] - 1] = filmes[j];
            C[(int) filmes[j].getNota()]--;
        }

        for (int i = 0; i < n; i++) {
            filmes[i] = B[i];
        }
    }
}
