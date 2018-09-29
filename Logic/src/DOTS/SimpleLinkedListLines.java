package DOTS;

public class SimpleLinkedListLines<T> {
    private Node<T> head;
    private int size;
    public T data;

    public SimpleLinkedListLines() {
        this.head = null;
        this.size = 1;
    }

    public int getSize() {
        return size;
    }



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
