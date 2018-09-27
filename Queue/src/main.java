public class main {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(23);
        queue.enqueue(54);
        queue.peek();
        System.out.println("hola");
        queue.all();
        queue.dequeue();
        queue.enqueue(38);
        System.out.println("hola");
        queue.peek();
        System.out.println("hola");
        queue.all();
    }
}
