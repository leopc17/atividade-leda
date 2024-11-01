package tests;

import entities.Filme;
import interfaces.BST_IF;
import interfaces.Filme_IF;
import org.junit.Before;
import org.junit.Test;
import structures.ABB;

import static org.junit.Assert.*;

public class ABBTest {

    private BST_IF bst;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        bst = new ABB();
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 9, 2021, 2);
        filme3 = new Filme("Filme 3", 7, 2023, 3);
    }

    // verifica se a inserção funciona corretamente
    @Test
    public void testInsercao() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);

        assertEquals(filme1, bst.search(1));
        assertEquals(filme2, bst.search(2));
    }

    // verifica se a remoção funciona corretamente
    @Test
    public void testRemove() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);

        assertEquals(filme1, bst.remove(1)); // verifica se o retorno do filme removido é correto
        assertThrows(Exception.class, () -> bst.search(1)); // verifica se o filme realmente foi removido
    }


    @Test
    public void testVazio() {
        assertTrue(bst.isEmpty()); // verifica se realmente está vazio
    }

    @Test
    public void testNaoVazio() {
        bst.insert(filme1);
        assertFalse(bst.isEmpty()); // verifica se realmente não está vazio
    }

    @Test
    public void testRaiz() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);
        assertEquals(filme1, bst.root()); // verifica se o primeiro elemento é realmente a raíz
    }

    @Test
    public void testAltura() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        assertEquals(2, bst.height()); // verifica se a altura da árvore é correta
    }

    @Test
    public void testTam() {
        assertEquals(0, bst.size()); // verifica se o tamanho da árvore vazia é realmente zero
        bst.insert(filme1);
        bst.insert(filme2);
        assertEquals(2, bst.size()); // verifica se o tamanho da árvore é realmente dois
    }

    @Test
    public void testEhCompleta() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);
        assertFalse(bst.isComplete()); // verifica se a árvore é realmente completa
    }

    @Test
    public void testPreOrder() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF[] expectedOrder = {filme1, filme2, filme3};
        assertArrayEquals(expectedOrder, bst.preOrder()); // verifica se o PreOrder está funcionando
    }

    @Test
    public void testOrder() {
        bst.insert(filme2);
        bst.insert(filme1);
        bst.insert(filme3);

        Filme_IF[] expectedOrder = {filme1, filme2, filme3};
        assertArrayEquals(expectedOrder, bst.order()); // verifica se o Order está funcionando
    }

    @Test
    public void testPostOrder() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        Filme_IF[] expectedOrder = {filme3, filme2, filme1};
        assertArrayEquals(expectedOrder, bst.postOrder());  // verifica se o PostOrder está funcionando
    }

    // deve lançar exceção caso seja removido elementos de uma árvore vazia
    @Test(expected = Exception.class)
    public void testRemoverArvoreVazia() throws Exception {
        bst.remove(1);
    }

    // deve lançar exceção caso seja usado busca em uma árvore vazia
    @Test(expected = Exception.class)
    public void testBuscaArvoreVazia() throws Exception {
        bst.search(1);
    }

    // deve lançar exceção caso a raíz da árvore vazia seja acessada
    @Test(expected = Exception.class)
    public void testRaizArvoreVazia() throws Exception {
        bst.root();
    }
}
