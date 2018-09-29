package DOTS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

<<<<<<< HEAD
public class ThreadedEchoServer {


    static final int PORT = 1978;

    public static void main(String args[]) {
=======
import DOTS.server.gameStart;
import Queue.LinkedQueue;
import sample.Controller;

public class ThreadedEchoServer {

    public static LinkedQueue queue= new LinkedQueue();
    private static boolean newGame=true;
    static final int PORT = 1978;

    public static void main(String args[]) throws InterruptedException {
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
<<<<<<< HEAD
            new EchoThread(socket).start();
=======
            queue.enqueue(socket,Controller.name,Controller.color);
            System.out.println("hola");
            if(queue.size()>1 && newGame){
                new gameStart().start();
            }
            //new EchoThread(socket).start();
        }
    }
    public static void connect() throws InterruptedException {
        while(newGame){
            System.out.println("aqui");
            if(queue.size()>1 && newGame){
                System.out.println("hola");
                new gameStart().start();
                //Socket P1=queue.peek();
                //new EchoThread(P1).start();

                //queue.dequeue();
                //Socket P2=queue.peek();
                //new EchoThread(P2).start();
                //queue.dequeue();
                //newGame=false;
                //Thread.sleep(5000);
            }
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
        }
    }
}

