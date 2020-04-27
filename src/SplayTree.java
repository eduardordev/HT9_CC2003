/*
*
*Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
*
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*/

public class SplayTree<E extends Comparable<E>> {

    private E val;
    private SplayTree<E> parent;
    private SplayTree<E> left, right; 

    /**
     * Constructor sin parametros
     */
    public SplayTree(){
        val = null;
        parent = null; 
        left = right = null;
    }

    /**
     * Constructor que inicializa un BST
     * @param val
     */
    public SplayTree(E value){
        val = value;
        right = left = new SplayTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Elimina todos los elementos del BST
     */
    public void clear(){}

    /**
     * @return numero de elementos en el BST
     */
    public int size(){
        return 0;
    }

    /**
     * Agrega elementos de manera ordenada al BST
     * @param value
     */
    public void add(E newValue, SplayTree<E> tree){  
        int comp = tree.getValue().compareTo(newValue);

        if(comp>0 && tree.getLeft()==null){
            tree.setLeft(new SplayTree<E>());
            tree.getLeft().setValue(newValue);
            balancear(tree.getLeft());
        }else if(comp>0 && tree.getLeft()!=null){
            add(newValue, tree.getLeft());

        }if(comp<=0 && tree.getRight()==null){
            tree.setRight(new SplayTree<E>());
            tree.getRight().setValue(newValue);
            balancear(tree.getRight());
        }else if(comp<=0 && tree.getRight()!=null){
            add(newValue, tree.getRight());
        }
    }

    /**
     * @param value
     * @return true si value se encuentra en el BST
     */
    public boolean contains(SplayTree<E> node, E value){
        if (node.getValue().compareTo(value)==0) {
            return true;
        }
        boolean contains = false;
        if (node.getLeft() != null) {
            contains = contains(node.getLeft(), value);
        }
        if (!contains && node.getRight() != null) {
            contains = contains(node.getRight(), value);
        }
    
        return contains;
    }

    /**
     * @param value valor a buscar dentro del BST
     * @return valor del BST
     */
    public E get(SplayTree<E> node, E value){
        if (node.getValue().compareTo(value)==0) {
            return node.getValue();
        }
        E contains = null;
        if (node.getLeft() != null) {
            contains = get(node.getLeft(), value);
        }
        if (contains == null && node.getRight() != null) {
            contains = get(node.getRight(), value);
        }
    
        return contains;
    }

    /**
     * @param value valor que se quiere eliminar
     * @return el valor que recien se elimino
     */
    public E remove(E value){
        return value;
    }

        /**
     * Asigna un objeto hijo a la izquierda
     * @param newLeft
     */
    public void setLeft(SplayTree<E> newLeft){
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public boolean isEmpty() {
        return this.getValue() == null;
    }

    /**
     * Asigna un objeto hijo a la derecha
     * 
     * @param newRight
     */
    public void setRight(SplayTree<E> newRight){
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    /**
     * Asigna un objeto de asociado de mayor jerarquia
     * @param newParent
     */
    protected void setParent(SplayTree<E> newParent){
        if (!isEmpty()){
            parent = newParent;
        }
    }
    
    /**
     * @return the left
     */
    public SplayTree<E> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public SplayTree<E> getRight() {
        return right;
    }

    /**
     * @return the parent
     */
    public SplayTree<E> getParent() {
        return parent;
    }

    /**
     * 
     * @return
     */
    public E getValue(){
        return val;
    }

    /**
     * 
     * @param value
     */
    public void setValue(E value){
        val = value;
    }

    /**
     * Metodo para balancear el arbol con algortimo splay tree
     * @param tree arbol que se movera a la raiz
     */
    private void balancear(SplayTree<E> tree){
        //Repetir los movimientos hasta llegar a la raiz
        while(tree.parent != null){
            //Si el arbol esta a la izquierda del padre hacer zig
            if(tree.getValue().compareTo(tree.getParent().getValue()) < 0){
                zig(tree);
            //Si esta a la derecha del padre hacer zag
            }else{
                zag(tree);
            }
        }
    }

    /**
     * Rotacion del arbol zig
     * @param tree Arbol que se va a rotar
     */
    private void zig(SplayTree<E> tree){
        tree.getRight().setParent(tree.getParent());
        tree.getParent().setLeft(tree.getRight());

        tree.setRight(tree.getParent());
        tree.setParent(tree.getRight().getParent());
        tree.getRight().setParent(tree);
    }

    /**
     * Rotacion del arbol zag
     * @param tree Arbol que se va a rotar
     */
    private void zag(SplayTree<E> tree){
        tree.getLeft().setParent(tree.getParent());
        tree.getParent().setRight(tree.getLeft());

        tree.setLeft(tree.getParent());
        tree.setParent(tree.getLeft().getParent());
        tree.getLeft().setParent(tree);
    }

    public void inOrder(SplayTree<E> node) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }else{
            System.out.println(node.getValue().toString());
            if (node.getRight() != null) {
                inOrder(node.getRight());
            }
        }
    }
    
}