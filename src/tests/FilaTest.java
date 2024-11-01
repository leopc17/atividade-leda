package tests;

import entities.Filme;
import interfaces.Fila_IF;
import interfaces.Filme_IF;
import org.junit.Before;
import org.junit.Test;
import structures.Fila;

import static org.junit.Assert.*;

public class FilaTest {

    private Fila_IF fila;
    private Filme_IF filme1;
    private Filme_IF filme2;

    @Before
    public void setUp() {
        fila = new Fila();
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 9, 2021, 2);
    }

    @Test
    public void testEnqueueEDequeue() throws Exception {
        fila.enqueue(filme1);
        fila.enqueue(filme2);

        // testa a lógica do FIFO
        assertEquals(filme1, fila.dequeue());
        assertEquals(filme2, fila.dequeue());
    }

    @Test
    public void testVazia() {
        assertTrue(fila.isEmpty()); // testa se a fila está vazia
    }

    @Test
    public void testNaoVazia() {
        fila.enqueue(filme1);
        assertFalse(fila.isEmpty()); // testa se a fila não é vazia após a inserção
    }

    @Test
    public void testHead() throws Exception {
        fila.enqueue(filme1);
        fila.enqueue(filme2);

        assertEquals(filme1, fila.head());
        assertEquals(filme1, fila.dequeue()); // verifica se o head apenas retorna o elemento sem removê-lo
    }

    // deve lançar exceção caso a fila esteja vazia
    @Test(expected = Exception.class)
    public void testDequeueFilaVazia() throws Exception {
        fila.dequeue();
    }

    // deve lançar exceção caso o head da fila vazia seja acessado
    @Test(expected = Exception.class)
    public void testHeadFromEmptyQueue() throws Exception {
        fila.head();
    }
}
