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

        // Testa se o primeiro elemento enfileirado é removido primeiro (FIFO)
        assertEquals(filme1, fila.dequeue());
        assertEquals(filme2, fila.dequeue());
    }

    @Test
    public void testIsEmpty() {
        // Testa se a fila está vazia após a criação
        assertTrue(fila.isEmpty());
    }

    @Test
    public void testNaoIsEmpty() {
        // Adiciona um elemento e verifica se isEmpty retorna false
        fila.enqueue(filme1);
        assertFalse(fila.isEmpty());
    }

    @Test
    public void testHead() throws Exception {
        // Testa se o head retorna o elemento no início da fila sem removê-lo
        fila.enqueue(filme1);
        fila.enqueue(filme2);

        assertEquals(filme1, fila.head());
        assertEquals(filme1, fila.dequeue()); // Confirma que o head não remove o elemento
    }

    @Test(expected = Exception.class)
    public void testDequeueFromEmptyQueue() throws Exception {
        // Testa se dequeue lança exceção quando a fila está vazia
        fila.dequeue();
    }

    @Test(expected = Exception.class)
    public void testHeadFromEmptyQueue() throws Exception {
        // Testa se head lança exceção quando a fila está vazia
        fila.head();
    }
}
