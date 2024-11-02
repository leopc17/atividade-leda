package utils;

import entities.Filme;
import interfaces.Filme_IF;

import java.util.*;

public class Ordenacao {

    public static boolean checaVetorOrdenado(Filme_IF[] filmes) {
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

    private Random r = new Random();
    public void embaralhar(Filme_IF[] filmes) {
        for (int i = 0; i < filmes.length; i++) {
            int n = r.nextInt(filmes.length);
            troca(filmes, i, n);
        }
    }

    private void troca(Filme_IF[] vetor, int p1, int p2) {
        Filme_IF aux = vetor[p1];
        vetor[p1] = vetor[p2];
        vetor[p2] = aux;
    }

    public static void mergeSort(Filme_IF[] filmes) {
        int tam = filmes.length;
        if(tam <= 1)
            return;
        int meio = tam / 2;
        Filme_IF[] left = new Filme[meio];
        Filme_IF[] right = new Filme[tam - meio];
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

    private static void merge(Filme_IF[] left, Filme_IF[] right, Filme_IF[] filmes){
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
}