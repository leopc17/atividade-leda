package tests;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.Lista_IF;
import org.junit.Before;
import org.junit.Test;
import structures.ListaEncadeada;

import static org.junit.Assert.*;

public class ListaTest {

    private Lista_IF lista;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        lista = new ListaEncadeada();
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 9, 2021, 2);
        filme3 = new Filme("Filme 3", 7, 2023, 3);
    }

    @Test
    public void testInsercaoEBusca() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);

        // verifica se os elementos foram de fato inseridos
        assertEquals(filme1, lista.search(1));
        assertEquals(filme2, lista.search(2));
    }

    @Test
    public void testRemove() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);

        assertEquals(filme1, lista.remove(1)); // verifica se o elemento removido é o correto
        assertThrows(Exception.class, () -> lista.search(1)); // deve lançar exceção ao tentar remover um elemento que não existe
    }

    @Test
    public void testVazia() {
        assertTrue(lista.isEmpty()); // verifica se a fila está realmente vazia
    }

    @Test
    public void testNaoVazia() {
        lista.insert(filme1);
        assertFalse(lista.isEmpty()); // verifica se a fila não está vazia após a inserção
    }

    @Test
    public void testHead() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);

        assertEquals(filme1, lista.head()); // verifica se a cabeça da lista é o primeiro elemento inserido
    }

    @Test
    public void testTail() throws Exception {
        lista.insert(filme1);
        lista.insert(filme2);
        lista.insert(filme3);

        assertEquals(filme3, lista.tail()); // verifica se a cauda da lista é o primeiro elemento inserido
    }

    @Test
    public void testSize() {
        assertEquals(0, lista.size());

        lista.insert(filme1);
        lista.insert(filme2);

        assertEquals(2, lista.size()); // verifica se o tamanho da lista está correto após inserção
    }

    // deve lançar uma exceção caso
    @Test(expected = Exception.class)
    public void testRemoveFromEmptyList() throws Exception {
        lista.remove(1);
    }

    // deve lançar exceção ao fazer uma busca em uma lista vazia
    @Test(expected = Exception.class)
    public void testBuscaVazia() throws Exception {
        lista.search(1);
    }

    // deve lançar exceção ao acessar o head em uma lista vazia
    @Test(expected = Exception.class)
    public void testHeadVazia() throws Exception {
        lista.head();
    }

    // deve lançar exceção ao acessar a cauda de uma lista vazia
    @Test(expected = Exception.class)
    public void testTailFromEmptyList() throws Exception {
        lista.tail();
    }
}
