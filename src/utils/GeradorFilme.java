package utils;

import entities.Filme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeradorFilme {

    public static Filme[] gerarFilmes(int qtdFilmes) {
        String caminho = "./src/filmes.csv";
        
        Filme[] filmes = new Filme[qtdFilmes];  // Vetor com a quantidade desejada de filmes
        Filme[] filmesAux = new Filme[qtdFilmes];  // Vetor temporário para armazenar os filmes lidos do arquivo
        int countFilmes = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null && countFilmes < qtdFilmes) {
                filmesAux[countFilmes] = separarLinha(linha);
                countFilmes++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Se a quantidade de filmes no arquivo for menor que o solicitado, repete os filmes
        for (int i = 0; i < qtdFilmes; i++) {
            filmes[i] = filmesAux[i % countFilmes];
        }

        return filmes;
    }

    private static Filme separarLinha(String linha) throws NumberFormatException {
        // Remove as aspas do nome do filme e faz o split corretamente, considerando as vírgulas dentro de aspas
        String[] partes = linha.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        // Extrai o nome removendo as aspas
        String nome = partes[0].replace("\"", "");
        int nota = Integer.parseInt(partes[1]);

        // Pega apenas o ano da data (primeiros 4 caracteres)
        String data = partes[2];
        int ano = Integer.parseInt(data.split("-")[0]);

        return new Filme(nome, nota, ano);
    }
}
