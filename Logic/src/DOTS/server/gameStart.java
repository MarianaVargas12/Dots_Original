package DOTS.server;


import DOTS.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;

public class gameStart extends Thread{
    private  Player P1;
    private  Player P2;
    protected Socket socket;
    private Players players;
    private JSONManager manager = new JSONManager();
    private DoubleLinkedList<DoubleLinkedList<Integer>> malla;
    private Game game = new Game();
    private boolean ActiveGame=true;
    private boolean endGame=false;



    public gameStart() {
        this.malla = game.Malla;
        this.players= Players.getPlayers();
        this.P1 = new Player();
        this.P2 = new Player();
        P1.setColor(ThreadedEchoServer.queue.color());
        P1.setName(ThreadedEchoServer.queue.name());
        players.setP1(true);
        ThreadedEchoServer.queue.dequeue();
        P2.setColor(ThreadedEchoServer.queue.color());
        P2.setName(ThreadedEchoServer.queue.name());
        players.setP1(true);
        ThreadedEchoServer.queue.dequeue();
        players.setT1(true);
    }

    private boolean shape(){
        return true;
    }
    public void LogicLine(Node node1, Node node2) {
        node1.lineas.append(node2);
        node2.lineas.append(node1);
        Path path = new Path(node1);
    }

    private boolean CoordsToNode(String obj){
        JSONManager manager = new JSONManager();
        JSONObject xy = new JSONObject();
        try {
            xy = manager.getArg(obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int x1 = ((Long)xy.get("x1")).intValue();
        int y1 = ((Long)xy.get("y1")).intValue();
        int x2 = ((Long)xy.get("x2")).intValue();
        int y2 = ((Long)xy.get("y2")).intValue();
        int StartNode = (x1/81)-1;
        int FinishNode = (x2/81)-1;
        int StartList = (y1/81)-1;
        int FinishList = (y2/81)-1;
        Node Node1 = malla.getNode(StartList).getData().getNode(StartNode);
        System.out.println(Node1);
        Node Node2 = malla.getNode(FinishList).getData().getNode(FinishNode);

        if (Node2==Node1.getRight() || Node2==Node1.getDown() || Node2==Node1.getLeft() || Node2==Node1.getUp() || Node2==Node1.getDrd() || Node2==Node1.getDld() || Node2==Node1.getDlu() || Node2==Node1.getDru()){
            System.out.println("error");
            System.out.println(Node1.lineas);
            for (int i = 0; i < Node1.lineas.getSize(); i++) {
                if (Node2 == Node1.lineas.getNode(i).getData()) {
                    return false;
                }
            }
            LogicLine(Node1,Node2);
            return true;
        }
        else{
            return false;
        }
    }

    public void run() {
        InputStream inp;
        BufferedReader brinp;
        DataOutputStream out;
        String line;

        while (ActiveGame) {
            try {
                inp = socket.getInputStream();
                brinp = new BufferedReader(new InputStreamReader(inp));
                out = new DataOutputStream(socket.getOutputStream());
                if(players.isP1()==false && players.isP2()==false) {
                }
                if( Players.isT1()){
                    line = brinp.readLine();
                    System.out.println(line);
                    System.out.println("line1");
                    if(line == null){

                    }else {
                        if (CoordsToNode(line)) {
                            String message = manager.serverWrite(true, true);
                            out.writeBytes(message + "\n");
                            out.flush();
                            if(shape()){
                                //figura formada enviar vertices y asignar puntos al id del jugador
                                players.setT1(false);
                                players.setT2(true);
                            }
                            else{
                                players.setT1(false);
                                players.setT2(true);
                            }

                        } else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                            socket.close();
                            return;
                        } else {
                            out.writeBytes(manager.serverWrite(false, false) + "\n");
                            out.flush();
                        }
                    }
                }else if(Players.isT2()){

                    line = brinp.readLine();
                    System.out.println("line2");
                    if(line == null){

                    }else {
                        if (CoordsToNode(line)) {
                            String message = manager.serverWrite(true, true);
                            out.writeBytes(message + "\n");
                            out.flush();
                            if(shape()){
                                players.setT1(true);
                                players.setT2(false);
                            }else{
                                players.setT1(true);
                                players.setT2(false);
                            }

                        } else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                            socket.close();
                            return;
                        } else {
                            out.writeBytes(manager.serverWrite(false, false) + "\n");
                            out.flush();
                        }
                    }
                }else if(endGame){
                    if(P1.getScore()>P2.getScore()){
                        out.flush();
                    }
                    if(P1.getScore()<P2.getScore()){

                    }
                    if(P1.getScore()==P2.getScore()){

                    }
                }
            } catch (IOException e){
                e.printStackTrace();
                return;


            }
        }

    }

}
