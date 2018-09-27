package DOTS;

public class SimpleLinkedListLines<T> {
    private ListNode<T> head;
    private int size;
    public T data;

    public SimpleLinkedListLines() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }



    public void append(T data) {
        ListNode<T> newNode = new ListNode<T>(data);
        ListNode<T> tmp = this.head;
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

    public ListNode<T> getListNode(int index){
        ListNode<T> current = head;
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
