package DOTS;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import DOTS.server.gameStart;
import sample.ListID.ListID;
import sample.Queue.LinkedQueue;

public class ThreadedEchoServer {

    static final int PORT = 1818;
    private static Players players;
    private static Player P1;
    private static Player P2;
    private static DoubleLinkedList<DoubleLinkedList<Integer>> malla;
    private static Game game = new Game();
    private static LinkedQueue queue;
    private static ListID listID;

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            System.out.println(PORT);
            serverSocket = new ServerSocket(PORT);
            players = new Players();
            P1 = new Player();
            P2 = new Player();
            malla = game.Malla;
            queue= new LinkedQueue();
            listID= new ListID();
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(PORT);
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            new gameStart(socket).run();
        }
    }

    public static DoubleLinkedList<DoubleLinkedList<Integer>> getMalla() {
        return malla;
    }

    public static Players getPlayers() {
        return players;
    }

    public static Player getP1() {
        return P1;
    }

    public static Player getP2() {
        return P2;
    }
    public static LinkedQueue getQueue(){
        return queue;
    }

    public static ListID getListID() {
        return listID;
    }
}

