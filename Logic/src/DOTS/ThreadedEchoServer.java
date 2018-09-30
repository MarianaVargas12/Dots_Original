package DOTS;

import DOTS.server.gameStart;
import Queue.LinkedQueue;
import sample.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer {
    public static LinkedQueue queue= new LinkedQueue();
    private static boolean newGame=true;
    static final int PORT = 1978;

    public static void main(String args[]) {
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
            queue.enqueue(socket, Controller.name, Controller.color);
            System.out.println("hola");
            if (queue.size() > 1 && newGame) {
                new gameStart().start();
            }
            //new EchoThread(socket).start();
        }
    }
}

