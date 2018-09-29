package Queue;
<<<<<<< HEAD

=======
import java.net.Socket;
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
public class LinkedQueue {

    class Node {
        Object elem;
<<<<<<< HEAD
        Node Next;

        public Node(Object o) {
            elem = o;
=======
        String name;
        String color;

        Node Next;

        public Node(Object o, String Name,String Color) {
            elem = o;
            name=Name;
            color=Color;
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
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

<<<<<<< HEAD
    public void enqueue(Object o) {
        Node new_node = new Node(o);
=======
    public void enqueue(Socket o, String name, String color) {
        Node new_node = new Node(o,name,color);
        System.out.println("enqueue");
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
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

<<<<<<< HEAD
    public Object peek() {
        if (first == null)
            return null;
        else
            System.out.println(first.elem);
        return first.elem;
    }
=======
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

>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
    public void all(){
        Node current= first;
        while(current!=null){
            System.out.println(current.elem);
            current=current.Next;
        }
    }

}
