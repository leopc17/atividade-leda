import entities.Filme;
import utils.Ordenacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static tests.TempoExecucao.*;
import static utils.GeradorFilme.*;

public class Main {

    static String caminho = "";

    public static void main(String[] args) {
        Ordenacao o = new Ordenacao();

        Filme[] v1 = gerarFilmes(10_000);
        Filme[] v2 = gerarFilmes(20_000);
        Filme[] v3 = gerarFilmes(50_000);
        Filme[] v4 = gerarFilmes(100_000);
        Filme[] v5 = gerarFilmes(200_000);

        // teste com vetor em ordem aleatória

        caminho = "./src/ordem-aleatoria.csv";

        o.embaralhar(v1);
        o.embaralhar(v2);
        o.embaralhar(v3);
        o.embaralhar(v4);
        o.embaralhar(v5);

        Filme[][] aux = {v1.clone(),v2.clone(),v3.clone(),v4.clone(),v5.clone()};
        iniciarTestes(aux);

        // teste com vetor ordenado

        caminho = "./src/ordenado.csv";

        o.quickSort(v1);
        o.quickSort(v2);
        o.quickSort(v3);
        o.quickSort(v4);
        o.quickSort(v5);

        aux[0] = v1.clone();
        aux[1] = v2.clone();
        aux[2] = v3.clone();
        aux[3] = v4.clone();
        aux[4] = v5.clone();
        iniciarTestes(aux);

        // teste com vetor ordem inversa

        caminho = "./src/ordem-inversa.csv";

        System.out.println(o.checaVetorOrdenado(v1));
        System.out.println(o.checaVetorOrdenado(v2));
        System.out.println(o.checaVetorOrdenado(v3));
        System.out.println(o.checaVetorOrdenado(v4));
        System.out.println(o.checaVetorOrdenado(v5));

        o.quickSort(v1);
        o.quickSort(v2);
        o.quickSort(v3);
        o.quickSort(v4);
        o.quickSort(v5);

        System.out.println(o.checaVetorOrdenado(v1));
        System.out.println(o.checaVetorOrdenado(v2));
        System.out.println(o.checaVetorOrdenado(v3));
        System.out.println(o.checaVetorOrdenado(v4));
        System.out.println(o.checaVetorOrdenado(v5));

        o.inverterVetor(v1);
        o.inverterVetor(v2);
        o.inverterVetor(v3);
        o.inverterVetor(v4);
        o.inverterVetor(v5);

        System.out.println(o.checaVetorOrdenado(v1));
        System.out.println(o.checaVetorOrdenado(v2));
        System.out.println(o.checaVetorOrdenado(v3));
        System.out.println(o.checaVetorOrdenado(v4));
        System.out.println(o.checaVetorOrdenado(v5));
        
        aux[0] = v1.clone();
        aux[1] = v2.clone();
        aux[2] = v3.clone();
        aux[3] = v4.clone();
        aux[4] = v5.clone();
        iniciarTestes(aux);
    }

    public static void escreverArquivo(long[] resultados, String nome) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {
            bw.write(nome + ";");
            for (long r : resultados) {
                bw.write(r + ";");
            }
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void iniciarTestes(Filme[][] aux) {
        Filme[] v1 = aux[0];
        Filme[] v2 = aux[1];
        Filme[] v3 = aux[2];
        Filme[] v4 = aux[3];
        Filme[] v5 = aux[4];

        long[] resultados = new long[5];
        resultados[0] = testeBubble(v1.clone());
        resultados[1] = testeBubble(v2.clone());
        resultados[2] = testeBubble(v3.clone());
        resultados[3] = testeBubble(v4.clone());
        resultados[4] = testeBubble(v5.clone());
        escreverArquivo(resultados, "BubbleSort");

        resultados[0] = testeSelection(v1.clone());
        resultados[1] = testeSelection(v2.clone());
        resultados[2] = testeSelection(v3.clone());
        resultados[3] = testeSelection(v4.clone());
        resultados[4] = testeSelection(v5.clone());
        escreverArquivo(resultados, "SelectionSort");

        resultados[0] = testeInsertion(v1.clone());
        resultados[1] = testeInsertion(v2.clone());
        resultados[2] = testeInsertion(v3.clone());
        resultados[3] = testeInsertion(v4.clone());
        resultados[4] = testeInsertion(v5.clone());
        escreverArquivo(resultados, "InsertionSort");

        resultados[0] = testeQuick(v1.clone());
        resultados[1] = testeQuick(v2.clone());
        resultados[2] = testeQuick(v3.clone());
        resultados[3] = testeQuick(v4.clone());
        resultados[4] = testeQuick(v5.clone());
        escreverArquivo(resultados, "QuickSort");

        resultados[0] = testeQuickRandom(v1.clone());
        resultados[1] = testeQuickRandom(v2.clone());
        resultados[2] = testeQuickRandom(v3.clone());
        resultados[3] = testeQuickRandom(v4.clone());
        resultados[4] = testeQuickRandom(v5.clone());
        escreverArquivo(resultados, "QuickSortRandom");

        resultados[0] = testeMerge(v1.clone());
        resultados[1] = testeMerge(v2.clone());
        resultados[2] = testeMerge(v3.clone());
        resultados[3] = testeMerge(v4.clone());
        resultados[4] = testeMerge(v5.clone());
        escreverArquivo(resultados, "MergeSort");

        resultados[0] = testeCounting(v1.clone());
        resultados[1] = testeCounting(v2.clone());
        resultados[2] = testeCounting(v3.clone());
        resultados[3] = testeCounting(v4.clone());
        resultados[4] = testeCounting(v5.clone());
        escreverArquivo(resultados, "CountingSort");
    }
}