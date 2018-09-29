package Queue;
import java.net.Socket;
public class LinkedQueue {

    class Node {
        Object elem;
        String name;
        String color;
        Node Next;

        public Node(Object o, String Name,String Color) {
            elem = o;
            name=Name;
            color=Color;
            Next = null;
        }
    }

    Node first;
    Node end;
    int size;

    public LinkedQueue() {
        end = null;
        size = 0;
    }

    public void enqueue(Socket o, String name, String color) {
        Node new_node = new Node(o,name,color);
        System.out.println("enqueue");
        if (first == null) {
            first = new_node;
            end = new_node;
        } else {
            end.Next = new_node;
            end = new_node;
        }
        size++;
    }

    public Object dequeue() {
        if (first == null)
            return null;
        Object o = first.elem;
        first = first.Next;
        size--;
        return o;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public Socket peek() {
        if (first == null) {
            return null;
        }
        else {
            return (Socket) first.elem;
        }
    }

    public String name() {
        if (first == null) {
            return null;
        } else {
            return first.name;
        }
    }

    public String color() {
        if (first == null) {
            return null;
        } else {
            return first.color;
        }
    }

    public void all(){
        Node current= first;
        while(current!=null){
            System.out.println(current.elem);
            current=current.Next;
        }
    }

}
