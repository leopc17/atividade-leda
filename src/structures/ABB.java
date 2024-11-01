package structures;

import interfaces.BST_IF;
import interfaces.Filme_IF;

public class ABB implements BST_IF {

    private NoABB raiz;

    public ABB() {
        this.raiz = new NoABB();
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        // z = aux1, y = aux2, x = aux3

        NoABB aux1 = searchNode(id);
        NoABB aux2, aux3;

        if (aux1.getEsq().isNIL() || aux1.getDir().isNIL()) {
            aux2 = aux1;
        } else {
            aux2 = successor(aux1);
        }

        if (!aux2.getEsq().isNIL()) {
            aux3 = aux2.getEsq();
        } else {
            aux3 = aux2.getDir();
        }

        if (!aux3.isNIL()) {
            aux3.setPai(aux2.getPai());
        }

        if (aux2.getPai().isNIL()) {
            raiz = aux3;
        } else if (aux2 == aux2.getPai().getEsq()) {
            aux2.getPai().setEsq(aux3);
        } else {
            aux2.getPai().setDir(aux3);
        }

        if (aux2 != aux1) {
            aux1.getDado().setID(aux2.getDado().getID());
        }

        return aux2.getDado();
    }

    @Override
    public void insert(Filme_IF elemento) {
        NoABB pai = new NoABB();
        NoABB aux = raiz;

        while (!(aux.isNIL())) {
            pai = aux;
            if (elemento.getID() < aux.getDado().getID()) {
                aux = aux.getEsq();
            } else {
                aux = aux.getDir();
            }
        }

        if (pai.isNIL()) {
            raiz = new NoABB(elemento);
        } else if (elemento.getID() < pai.getDado().getID()) {
            pai.setEsq(new NoABB(elemento, pai));
        } else {
            pai.setDir(new NoABB(elemento, pai));
        }
    }

    @Override
    public boolean isEmpty() {
        return raiz.isNIL();
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Árvore vazia");
        }

        return search(id, raiz);
    }

    private Filme_IF search(long id, NoABB no) throws Exception {
        if (no.isNIL()) {
            throw new Exception("ID não encontrado");
        }

        if (id == no.getDado().getID()) {
            return no.getDado();
        }

        if (id < no.getDado().getID()) {
            return search(id, no.getEsq());
        } else {
            return search(id, no.getDir());
        }
    }

    private NoABB searchNode(long id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Árvore vazia");
        }

        return searchNode(id, raiz);
    }

    private NoABB searchNode(long id, NoABB no) throws Exception {
        if (no.isNIL()) {
            throw new Exception("ID não encontrado");
        }

        if (id == no.getDado().getID()) {
            return no;
        }

        if (id < no.getDado().getID()) {
            return searchNode(id, no.getEsq());
        } else {
            return searchNode(id, no.getDir());
        }
    }

    @Override
    public Filme_IF root() throws Exception {
        if (isEmpty()) {
            throw new Exception("Árvore vazia");
        }

        return raiz.getDado();
    }

    @Override
    public int height() {
        return height(raiz);
    }

    private int height(NoABB no) {
        if (no.isNIL()) {
            return -1;
        }

        int alturaE = height(no.getEsq());
        int alturaD = height(no.getDir());

        if (alturaE > alturaD) {
            return 1 + alturaE;
        } else {
            return 1 + alturaD;
        }
    }

    @Override
    public int size() {
        return size(raiz);
    }

    private int size(NoABB no) {
        if (no.isNIL()) {
            return 0;
        } else {
            return 1 + size(no.getEsq()) + size(no.getDir());
        }
    }

    @Override
    public boolean isComplete() {
        int nos = (int) Math.pow(2, height(raiz) + 1) - 1; // equação: 2^(h+1) - 1
        return size() == nos;
    }

    @Override
    public Filme_IF[] preOrder() {
        ListaEncadeada lista = new ListaEncadeada();
        preOrder(raiz, lista);
        return lista.toArray();
    }

    private void preOrder(NoABB no, ListaEncadeada lista) {
        if (!no.isNIL()) {
            lista.insert(no.getDado());
            preOrder(no.getEsq(), lista);
            preOrder(no.getDir(), lista);
        }
    }

    @Override
    public Filme_IF[] order() {
        ListaEncadeada lista = new ListaEncadeada();
        order(raiz, lista);
        return lista.toArray();
    }

    private void order(NoABB no, ListaEncadeada lista) {
        if (!no.isNIL()) {
            preOrder(no.getEsq(), lista);
            lista.insert(no.getDado());
            preOrder(no.getDir(), lista);
        }
    }

    @Override
    public Filme_IF[] postOrder() {
        ListaEncadeada lista = new ListaEncadeada();
        postOrder(raiz, lista);
        return lista.toArray();
    }

    private void postOrder(NoABB no, ListaEncadeada lista) {
        if (!no.isNIL()) {
            postOrder(no.getEsq(), lista);
            postOrder(no.getDir(), lista);
            lista.insert(no.getDado());
        }
    }

    private NoABB treeMinimum(NoABB no) {
        while (!no.getEsq().isNIL()) {
            no = no.getEsq();
        }

        return no;
    }

    private NoABB treeMaximum(NoABB no) {
        while (!no.getDir().isNIL()) {
            no = no.getDir();
        }

        return no;
    }

    private NoABB successor(NoABB no) {
        if (!no.getDir().isNIL()) {
            return treeMaximum(no.getDir());
        }
        NoABB aux = no.getPai();
        while (!(aux.isNIL()) && no == aux.getDir()) {
            no = aux;
            aux = aux.getPai();
        }

        return aux;
    }
}