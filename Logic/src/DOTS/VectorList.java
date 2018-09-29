package DOTS;

public class VectorList<T> {
    private VectorNode<T> head;
    private int size;

    public VectorList(){
        this.head=null;
        this.size=0;
    }

    private boolean isEmpty(){
        return this.head==null;
    }

    public int size(){
        return this.size;
    }

    public void append(Node<T> nodei, Node<T> nodef, int dir) {
        VectorNode<T> newNode = new VectorNode<T>(nodei, nodef, dir);
        VectorNode<T> tmp = this.head;
        if (this.head == null) {
            this.head = newNode;
            this.size++;
        } else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
            newNode.setNext(null);
            this.size++;
        }
    }



    public  VectorNode<T> getVectorNode(int index){
        VectorNode<T> current=head;
        if (index<size){
            for (int j=0; j<size; j++){
                if (index==j){
                    return current;
                }
                else{
                    current=current.next;
                }
            }
        }
        return null;
    }
}
