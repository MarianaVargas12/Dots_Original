package DOTS;

public class SimpleLinkedListLines<T> {
    private Node<T> head;
    private int size;
    public T data;

    public SimpleLinkedListLines() {
        this.head = null;
<<<<<<< HEAD
        this.size = 1;
=======
        this.size = 0;
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
    }

    public int getSize() {
        return size;
    }



<<<<<<< HEAD
    public void append(Node newNode){
        Node<T> tmp=this.head;
        if (this.head==null){
            this.head=newNode;
            this.size++;
        }
        else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
            newNode.setNext(null);
            this.size++;
        }
    }

    public Node<T> getNode(int index){
=======
    public SimpleLinkedListLines append(Node node) {
        Node<T> tmp = this.head;
        if (this.head == null) {
            this.head = node;
            this.size++;
        } else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
            node.setNext(null);
            this.size++;
        }
        return null;
    }

    public Node<T> getListNode(int index){
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
        Node<T> current = head;
        if (index < size) {
            for (int j = 0; j < size; j++) {
                if (index == j) {
                    return current;
                } else {
                    current = current.next;
                }
            }
        }
        return null;
    }
}
