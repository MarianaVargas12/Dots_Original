package DOTS;

public class Node<T> {
    public Node prev;
    public Node next;
    private T data;
    private Node right;
    private Node left;
    private Node down;
    private Node up;
    private Node dru;
    private Node drd;
    private Node dlu;
    private Node dld;
    public SimpleLinkedListLines<T> lineas = new SimpleLinkedListLines<T>();

    public Node(T data) {
        this.next=null;
        this.data = data;
    }

    public SimpleLinkedListLines<T> getLineas() {
        return lineas;
    }

    public void setLineas(SimpleLinkedListLines<T> lineas) {
        this.lineas = lineas;
    }

    public Node<T> getDld() {
        return dld;
    }

    public Node<T> getDown() {
        return down;
    }

    public Node<T> getDlu() {
        return dlu;
    }

    public Node<T> getDrd() {
        return drd;
    }

    public Node<T> getDru() {
        return dru;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getUp() {
        return up;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setDld(Node dld) {
        this.dld = dld;
    }

    public void setDlu(Node dlu) {
        this.dlu = dlu;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public void setDrd(Node drd) {
        this.drd = drd;
    }

    public void setDru(Node dru) {
        this.dru = dru;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setUp(Node up) {
        this.up = up;
    }
}
