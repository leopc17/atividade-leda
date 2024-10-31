package tests;

import entities.Filme;
import interfaces.BST_IF;
import interfaces.Filme_IF;
import org.junit.Before;
import org.junit.Test;
import structures.ABB;

import static org.junit.Assert.*;

// Suponha que a classe a ser testada seja chamada BST e implemente BST_IF
public class ABBTest {

    private BST_IF bst;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        bst = new ABB(); // Suponha que BST seja a classe que implementa BST_IF
        filme1 = new Filme("Filme 1", 8, 2022, 1);
        filme2 = new Filme("Filme 2", 9, 2021, 2);
        filme3 = new Filme("Filme 3", 7, 2023, 3);
    }

    @Test
    public void testInsertAndSearch() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);

        // Verifica se os elementos foram inseridos corretamente
        assertEquals(filme1, bst.search(1));
        assertEquals(filme2, bst.search(2));
    }

    @Test
    public void testRemove() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);

        // Remove o filme1 e verifica se ele é removido
        assertEquals(filme1, bst.remove(1));
        assertThrows(Exception.class, () -> bst.search(1)); // Deve lançar exceção ao buscar id removido
    }

    @Test
    public void testIsEmptyTrueWhenEmpty() {
        // Verifica se a árvore está vazia inicialmente
        assertTrue(bst.isEmpty());
    }

    @Test
    public void testIsEmptyFalseWhenNotEmpty() {
        // Insere um elemento e verifica se isEmpty retorna false
        bst.insert(filme1);
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testRoot() throws Exception {
        bst.insert(filme1);
        bst.insert(filme2);

        // O primeiro elemento inserido deve ser a raiz
        assertEquals(filme1, bst.root());
    }

    @Test
    public void testHeight() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Verifica a altura esperada da árvore após as inserções
        assertEquals(2, bst.height());
    }

    @Test
    public void testSize() {
        assertEquals(0, bst.size());

        bst.insert(filme1);
        bst.insert(filme2);

        // Verifica o tamanho da árvore após inserções
        assertEquals(2, bst.size());
    }

    @Test
    public void testIsComplete() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Este teste verifica se a árvore está completa, dependendo da implementação
        // A expectativa de resultado pode variar com o comportamento do BST
        assertFalse(bst.isComplete());
    }

    @Test
    public void testPreOrderTraversal() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Verifica se o percurso preOrder retorna os elementos na ordem correta
        Filme_IF[] expectedOrder = {filme1, filme2, filme3}; // Ajuste conforme a lógica de preOrder
        assertArrayEquals(expectedOrder, bst.preOrder());
    }

    @Test
    public void testOrderTraversal() {
        bst.insert(filme2);
        bst.insert(filme1);
        bst.insert(filme3);

        // Verifica se o percurso order retorna os elementos na ordem correta
        Filme_IF[] expectedOrder = {filme1, filme2, filme3}; // Ajuste conforme a lógica de order
        assertArrayEquals(expectedOrder, bst.order());
    }

    @Test
    public void testPostOrderTraversal() {
        bst.insert(filme1);
        bst.insert(filme2);
        bst.insert(filme3);

        // Verifica se o percurso postOrder retorna os elementos na ordem correta
        Filme_IF[] expectedOrder = {filme3, filme2, filme1}; // Ajuste conforme a lógica de postOrder
        assertArrayEquals(expectedOrder, bst.postOrder());
    }

    @Test(expected = Exception.class)
    public void testRemoveFromEmptyTree() throws Exception {
        // Testa se uma exceção é lançada ao tentar remover de uma árvore vazia
        bst.remove(1);
    }

    @Test(expected = Exception.class)
    public void testSearchInEmptyTree() throws Exception {
        // Testa se uma exceção é lançada ao tentar buscar em uma árvore vazia
        bst.search(1);
    }

    @Test(expected = Exception.class)
    public void testRootFromEmptyTree() throws Exception {
        // Testa se uma exceção é lançada ao tentar acessar a raiz de uma árvore vazia
        bst.root();
    }
}
