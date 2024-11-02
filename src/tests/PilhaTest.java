package tests;

import entities.Filme;
import interfaces.Filme_IF;
import interfaces.Pilha_IF;
import org.junit.Before;
import org.junit.Test;
import structures.Pilha;

import static org.junit.Assert.*;

public class PilhaTest {

    private Pilha_IF pilha;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        pilha = new Pilha();
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 7, 2021, 2);
        filme3 = new Filme("Filme 3", 9, 2023, 3);
    }

    @Test
    public void testTop() throws Exception {
        pilha.push(filme1);
        pilha.push(filme2);

        assertEquals(filme2, pilha.top()); // verifica se o elemento no topo da pilha é o último inserido
    }

    @Test
    public void testPop() throws Exception {
        pilha.push(filme1);
        pilha.push(filme2);

        assertEquals(filme2, pilha.pop()); //
        assertEquals(filme1, pilha.top()); // verifica se o topo da pilha é atualizado após o pop
    }

    @Test
    public void testVazia() {
        assertTrue(pilha.isEmpty()); // verifica se a pilha está realmente vazia
    }

    @Test
    public void testNaoVazia() {
        pilha.push(filme1);
        assertFalse(pilha.isEmpty()); // verifica se a pilha não está vazia após a inserção
    }

    // deve lançar uma exceção ao usar o pop em uma pilha vazia
    @Test(expected = Exception.class)
    public void testPopVazia() throws Exception {
        pilha.pop();
    }

    // deve lançar uma exceção ao usar o top em uma pilha vazia
    @Test(expected = Exception.class)
    public void testTopVazia() throws Exception {
        pilha.top();
    }
}
