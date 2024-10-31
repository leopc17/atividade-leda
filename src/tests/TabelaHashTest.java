package tests;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.TabelaHash_IF;
import org.junit.Before;
import org.junit.Test;
import structures.TabelaHash;

import static org.junit.Assert.*;

// Suponha que a classe a ser testada seja chamada TabelaHash e implemente TabelaHash_IF
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
    public void testInsertAndSearch() throws Exception {
        tabelaHash.insert(filme1);
        tabelaHash.insert(filme2);

        // Verifica se os elementos foram inseridos e podem ser encontrados
        assertEquals(filme1, tabelaHash.search(1));
        assertEquals(filme2, tabelaHash.search(10));
    }

    @Test
    public void testRemove() throws Exception {
        tabelaHash.insert(filme1);
        tabelaHash.insert(filme2);

        // Remove filme1 e verifica se ele foi removido
        assertEquals(filme1, tabelaHash.remove(1));
        assertThrows(Exception.class, () -> tabelaHash.search(1)); // Deve lançar exceção ao buscar ID removido
    }

    @Test
    public void testIsEmptyTrueWhenEmpty() {
        // Verifica se a tabela está vazia inicialmente
        assertTrue(tabelaHash.isEmpty());
    }

    @Test
    public void testIsEmptyFalseWhenNotEmpty() {
        // Insere um elemento e verifica se isEmpty retorna false
        tabelaHash.insert(filme1);
        assertFalse(tabelaHash.isEmpty());
    }

    @Test
    public void testPrint() {
        // Insere os filmes em posições específicas da tabela
        tabelaHash.insert(filme1); // ID 1
        tabelaHash.insert(filme2); // ID 10
        tabelaHash.insert(filme3); // ID 3
        tabelaHash.insert(filme4); // ID 15

        // Com base na função hash ID % 8, temos as seguintes posições esperadas:
        // filme1 (ID 1) -> posição 1
        // filme2 (ID 10) -> posição 2
        // filme3 (ID 3) -> posição 3
        // filme4 (ID 15) -> posição 7
        String expectedPrint =
                "0: \n" +
                        "1: Filme 1 (2022) [8] {1}\n" +
                        "2: Filme 2 (2021) [7] {10}\n" +
                        "3: Filme 3 (2023) [9] {3}\n" +
                        "4: \n" +
                        "5: \n" +
                        "6: \n" +
                        "7: Filme 4 (2022) [6] {15}\n";

        assertEquals(expectedPrint, tabelaHash.print());
    }

    @Test(expected = Exception.class)
    public void testRemoveFromEmptyTable() throws Exception {
        // Testa se uma exceção é lançada ao tentar remover de uma tabela vazia
        tabelaHash.remove(1);
    }

    @Test(expected = Exception.class)
    public void testSearchInEmptyTable() throws Exception {
        // Testa se uma exceção é lançada ao tentar buscar em uma tabela vazia
        tabelaHash.search(1);
    }
}
