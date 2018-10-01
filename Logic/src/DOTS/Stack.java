package DOTS;

/**
 * clase pila para el recorrido de figuras
 * @param <T>
 */
class Stack<T>{
    protected Node top ;
    protected int size ;

    public Stack(){
        top = null;
        size = 0;
    }


    public boolean isEmpty(){
        return top == null;}


    public int getSize(){
        return size;}

    /**
     * agregar nodo
     * @param newNode
     */
    public void push(Node newNode){
        if (top == null)
            top = newNode;
        else
        {
            newNode.setPrev(top);
            top = newNode;
        }
        size++ ;
    }

    /**
     * elimina nodo
     * @return nodo
     */
    public Node<T> pop(){
        if (isEmpty()){
            return null;
        }
        Node<T> node = top;
        top = node.getPrev();
        size--;
        return node;
    }

    /**
     *
     * @return nodo
     */
    public Node<T> peek() {
        if (isEmpty()){
            return top;
        }
        return null;
    }


}
