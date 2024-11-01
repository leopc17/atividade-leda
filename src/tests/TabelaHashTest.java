package tests;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;
import org.junit.Before;
import org.junit.Test;
import structures.TabelaHash;

import static org.junit.Assert.*;

public class TabelaHashTest {

    private TabelaHash_IF tabelaHash;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;
    private Filme_IF filme4;

    @Before
    public void setUp() {
        tabelaHash = new TabelaHash(8); // Suponha que a tabela de hash tem 8 posições
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 7, 2021, 10);
        filme3 = new Filme("Filme 3", 9, 2023, 3);
        filme4 = new Filme("Filme 4", 6, 2022, 15);
    }

    @Test
    public void testInsercaoEBusca() throws Exception {
        tabelaHash.insert(filme1);
        tabelaHash.insert(filme2);

        // verifica se os elementos inseridos podem ser encontrados
        assertEquals(filme1, tabelaHash.search(1));
        assertEquals(filme2, tabelaHash.search(10));
    }

    @Test
    public void testRemove() throws Exception {
        tabelaHash.insert(filme1);
        tabelaHash.insert(filme2);

        // remove o filme1 e verifica se ele foi removido
        assertEquals(filme1, tabelaHash.remove(1));
        assertThrows(Exception.class, () -> tabelaHash.search(1)); // deve lançar exceção ao buscar um id que não existe
    }

    @Test
    public void testVazia() {
        assertTrue(tabelaHash.isEmpty()); // verifica se a tabela está vazia
    }

    @Test
    public void testNaoVazia() {
        tabelaHash.insert(filme1);
        assertFalse(tabelaHash.isEmpty()); // verifica se não está vazia após uma inserção
    }

    @Test
    public void testPrint() {
        tabelaHash.insert(filme1); // id = 1
        tabelaHash.insert(filme2); // id = 10
        tabelaHash.insert(filme3); // id = 3
        tabelaHash.insert(filme4); // id = 15

        // Com base na função hash (id % t.lenght), temos as seguintes posições esperadas:
        // filme1 (id = 1) -> posição 1
        // filme2 (id = 10) -> posição 2
        // filme3 (id = 3) -> posição 3
        // filme4 (id = 15) -> posição 7
        String str =
                "0: \n" +
                        "1: Filme 1 (2022) [8] {1}\n" +
                        "2: Filme 2 (2021) [7] {10}\n" +
                        "3: Filme 3 (2023) [9] {3}\n" +
                        "4: \n" +
                        "5: \n" +
                        "6: \n" +
                        "7: Filme 4 (2022) [6] {15}\n";

        assertEquals(str, tabelaHash.print());
    }

    // deve lançar uma exceção ao tentar remover de uma tabela vazia
    @Test(expected = Exception.class)
    public void testRemoveVazio() throws Exception {
        tabelaHash.remove(1);
    }

    // deve lançar uma exceção ao tentar buscar em uma tabela vazia
    @Test(expected = Exception.class)
    public void testBuscaVazio() throws Exception {
        tabelaHash.search(1);
    }
}
