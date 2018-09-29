package DOTS;

public class VectorNode<T> {
    Node<T> i;
    Node<T> f;
    int dir;
    VectorNode<T> next;

    public VectorNode(Node<T> i, Node<T> f, int dir) {
        this.i = i;
        this.f = f;
        this.dir = dir;
        this.next=null;
    }

    public Node<T> getI() {
        return i;
    }

    public void setI(Node<T> i) {
        this.i = i;
    }

    public Node<T> getF() {
        return f;
    }

    public void setF(Node<T> f) {
        this.f = f;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public VectorNode<T> getNext() {
        return next;
    }

    public void setNext(VectorNode<T> next) {
        this.next = next;
    }
}
