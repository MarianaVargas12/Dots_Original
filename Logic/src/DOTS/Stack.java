package DOTS;

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


    /*  Function to push an element to the stack */
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


    public Node<T> pop(){
        if (isEmpty()){
            return null;
        }
        Node<T> node = top;
        top = node.getPrev();
        size--;
        return node;
    }


    public Node<T> peek() {
        if (isEmpty()){
            return top;
        }
        return null;
    }


    public void display(){
        System.out.print("\nStack = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node node = top;
        while (node != null)
        {
            System.out.print(node+" ");
            node = node.getPrev();
        }
    }
}
