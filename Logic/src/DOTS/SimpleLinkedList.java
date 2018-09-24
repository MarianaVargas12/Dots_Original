package DOTS;

public class SimpleLinkedList<T> {
    private Node<T> head;
    private int size;

    public SimpleLinkedList(){
        this.head=null;
        this.size=0;
    }

    private boolean isEmpty(){
        return this.head==null;
    }

    public int size(){
        return this.size;
    }

    public void insert(T Lista){
        Node<T> Line =new Node<T>(Lista);
        Node<T> tmp=this.head;
        if (this.head==null){
            this.head=Line;
        }
        else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(Line);
            Line.setNext(null);
            this.size++;
        }
    }

    public Node<T> find(Object searchValue){
        Node current =this.head;
        while (current != null){
            if (current.getData().equals(searchValue)) {
                return current;
            }else {
                current = current.getNext();
            }
        }
        return null;
    }

    public void display(){
        Node<T> current = this.head;
        while (current!=null){
            System.out.println(current.getData());
            current = current.getNext();
        }}

    public  Node<T> getNode(int index){
        Node<T> current=head;
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
