package utils;

import entities.Filme;
import interfaces.Busca_IF;

public class Busca implements Busca_IF {

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
    public Filme buscaLinear_iterativa(Filme[] filmes, int nota) throws Exception {
        if (nota < 0) {
            throw new Exception("Nota Negativa");
        }

        for (Filme filme : filmes) {
            if (filme.getNota() == nota) {
                return filme;
            }
        }

        return null;
    }

    @Override
    public Filme buscaLinear_recursiva(Filme[] filmes, int nota) throws Exception {
        return buscaLinear_recursiva(filmes, nota, 0);
    }

    private Filme buscaLinear_recursiva(Filme[] filmes, int nota, int index) throws Exception {
        if (index >= filmes.length) {
            throw new Exception("Filme não encontrado");
        }
        if (filmes[index].getNota() == nota) {
            return filmes[index];
        }
        return buscaLinear_recursiva(filmes, nota, index + 1);
    }

    @Override
    public Filme buscaBinaria_iterativa(Filme[] filmes, int nota) throws Exception {
        if (nota < 0) {
            throw new Exception("Nota Negativa");
        }

        int inicio = 0;
        int fim = filmes.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (filmes[meio].getNota() == nota) {
                return filmes[meio];
            } else if (filmes[meio].getNota() < nota) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return null;
    }

    @Override
    public Filme buscaBinaria_recursiva(Filme[] filmes, int nota) throws Exception {
        if (nota < 0) {
            throw new Exception("Nota Negativa");
        }

        return buscaBinaria_recursiva(filmes, nota, 0, filmes.length - 1);
    }

    private Filme buscaBinaria_recursiva(Filme[] filmes, int nota, int inicio, int fim) throws Exception {
        if (nota < 0) {
            throw new Exception("Nota Negativa");
        }

        if (inicio > fim) {
            return null;
        }
        int meio = (inicio + fim) / 2;
        if (filmes[meio].getNota() == nota) {
            return filmes[meio];
        } else if (filmes[meio].getNota() < nota) {
            return buscaBinaria_recursiva(filmes, nota, meio + 1, fim);
        } else {
            return buscaBinaria_recursiva(filmes, nota, inicio, meio - 1);
        }
    }

    @Override
    public Filme buscaLinear_iterativa_duasPontas(Filme[] filmes, int nota) throws Exception {
        if (nota < 0) {
            throw new Exception("Filme não encontrado");
        }

        int inicio = 0;
        int fim = filmes.length - 1;

        while (inicio <= fim) {
            if (filmes[inicio].getNota() == nota) {
                return filmes[inicio];
            }
            if (filmes[fim].getNota() == nota) {
                return filmes[fim];
            }
            inicio++;
            fim--;
        }

        return null;
    }
}