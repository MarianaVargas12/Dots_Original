package DOTS;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private int size;
    public Node<T> next;
    public Node<T> prev;
    public int counter=1;

    public DoubleLinkedList(){
        this.head=null;
        this.size=0;

    }

    public int getSize() {
        return size;
    }

    public void append(T data){
        Node<T> newNode=new Node<T>(data);
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
            newNode.setPrev(tmp);
            newNode.setNext(null);
            this.size++;
            counter++;
        }
    }

    public Node<T> find(T value){
        Node<T> current=this.head;
        while(current!=null){
            if(current.getData().equals(value)){
                System.out.println("found it");
                return current;
            }
            else{
                current = current.getNext();
            }
        }
        return null;
    }

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

    public void display(){
        Node<T> current = this.head;
        while (current!=null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public Node<T> show(Object Data){
        Node<T> current =this.head;
        if (current.getData()==Data){
            System.out.println(current.getData());
            return current;
        }
        else{
            current = current.next;
        }
        return current;
    }

}
