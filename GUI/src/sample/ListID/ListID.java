package sample.ListID;

public class ListID {
    private Node head;
    private int size;
    class Node {
        private String id;
        private Node Next;
        private Node previous;

        public Node(String ID) {
            this.Next= null;
            this.id = ID;
        }

        public String getId() {
            return id;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node next) {
            Next = next;
        }
        public void setPrevious(Node Previous) {
            Previous = Previous;
        }

        public Node getPrevious() {
            return previous;
        }
    }

    public ListID() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }



    public void add(String id) {
        Node newNode= new Node(id);
        newNode.setNext(this.head);
        newNode.setPrevious(null);
        this.head=newNode;
        this.size++;
    }

    public boolean search(String id){
        Node current= this.head;
        while(current!=null){
            if(current.getId().equals(id)){
                return true;
            }
            else{
                current= current.getNext();
            }
        }
        return false;
    }
    public boolean delete(String id) {
        Node current = this.head;
        Node previous = this.head;
        while (current != null) {
            if (current.getId().equals(id)) {
                if (current.equals(this.head)) {
                    this.head = head.getNext();
                    return true;
                } else {
                    previous.setNext(current.getNext());
                    return true;
                }
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return true;
    }

}
