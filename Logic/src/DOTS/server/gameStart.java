package DOTS.server;


import DOTS.*;
import Queue.LinkedQueue;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.Socket;

public class gameStart extends Thread{
    private  Player P1= ThreadedEchoServer.getP1();
    private  Player P2=ThreadedEchoServer.getP2();
    protected Socket socket;
    private Players players=ThreadedEchoServer.getPlayers();
    private DoubleLinkedList<DoubleLinkedList<Integer>> malla =ThreadedEchoServer.getMalla();
    private boolean ActiveGame=true;
    private boolean endGame=false;
    private LinkedQueue queue= new LinkedQueue();



    public gameStart(Socket client) {
        this.socket=client;
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
        Node Node2 = malla.getNode(FinishList).getData().getNode(FinishNode);
        if (Node2==Node1.getRight() || Node2==Node1.getDown() || Node2==Node1.getLeft() || Node2==Node1.getUp() || Node2==Node1.getDrd() || Node2==Node1.getDld() || Node2==Node1.getDlu() || Node2==Node1.getDru()){
            System.out.println(Node1.lineas);
            for (int i = 0; i < Node1.lineas.getSize(); i++) {
                System.out.println("error");
                System.out.println(Node1.lineas);
                System.out.println(Node1.lineas.getNode(i));
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
        JSONManager manager = new JSONManager();
        JSONObject xy;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
            line = brinp.readLine();

        } catch (IOException e) {
            return;
        }
        while (ActiveGame) {
            try {
                xy = manager.getArg(line);
                String id = (String) xy.get("id");
                if (!players.isP1()) {
                    P1.setColor("ndwejn");
                    P1.setName("dnwj");
                    P1.setId(id);
                    players.setP1(true);
                    System.out.println(players.isP1());
                    String message = manager.Play(false,false,false);
                    out.writeBytes(message + "\n");
                    out.flush();
                    ActiveGame=false;
                }
                else if (!players.isP2() && !id.equals(P1.getId())) {
                    System.out.println(id);
                    System.out.println(P1.getId());
                    P2.setColor("ndwejn");
                    P2.setName("dnwj");
                    P2.setId(id);
                    players.setP2(true);
                    players.setT1(true);
                    String message = manager.Play(false,false,false);
                    out.writeBytes(message + "\n");
                    out.flush();
                    ActiveGame=false;
                    //enviar booleano para pasar de pantalla
                } else if (endGame) {
                    if (P1.getScore() > P2.getScore()) {
                        out.flush();
                    }
                    if (P1.getScore() < P2.getScore()) {

                    }
                    if (P1.getScore() == P2.getScore()) {

                    }
                } else if (players.isP1() && players.isP2()) {
                    if (id.equals(P1.getId()) || id.equals(P2.getId())) {
                        String message = manager.Play(true,true,false);
                        out.writeBytes(message + "\n");
                        out.flush();
                        if (Players.isT1() && id.equals(P1.getId())) {
                            if (line == null) {
                            }
                            else {
                                if (CoordsToNode(line)) {
                                    if (shape()) {
                                        players.setT1(false);
                                        players.setT2(true);
                                        String op = manager.serverWrite(true,false,false);
                                        out.writeBytes(op + "\n");
                                        out.flush();
                                        //figura formada enviar vertices y asignar puntos al id del jugador
                                        ActiveGame=false;
                                    } else {
                                        System.out.println("entroT1");
                                        String draw = manager.serverWrite( false,false,false);
                                        out.writeBytes(draw + "\n");
                                        out.flush();
                                        players.setT1(false);
                                        players.setT2(true);
                                        ActiveGame=false;
                                    }

                                } else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                                    socket.close();
                                    ActiveGame=false;
                                } else {
                                    out.writeBytes(manager.serverWrite(false,false,false) + "\n");
                                    out.flush();
                                    ActiveGame=false;
                                }
                                ActiveGame=false;
                            }
                        } else if (Players.isT2()&& id.equals(P2.getId())) {

                            if (line == null) {
                            }
                            else {

                                if (CoordsToNode(line)) {
                                    String draw = manager.serverWrite(true,false,false);
                                    out.writeBytes(draw + "\n");
                                    out.flush();
                                    if (shape()) {
                                        //figura formada enviar vertices y asignar puntos al id del jugador
                                        players.setT1(true);
                                        players.setT2(false);
                                        ActiveGame=false;
                                    } else {
                                        players.setT1(true);
                                        players.setT2(false);
                                        ActiveGame=false;
                                    }

                                } else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                                    socket.close();
                                    ActiveGame=false;
                                } else {
                                    out.writeBytes(manager.serverWrite(false,false,false) + "\n");
                                    out.flush();
                                    ActiveGame=false;
                                }
                            }
                        }else{
                            String draw = manager.Play(false,false,false);
                            out.writeBytes(draw + "\n");
                            out.flush();
                            ActiveGame=false;
                        }
                        ActiveGame=false;
                    }else {
                        String message = manager.Play(false, false, false);
                        out.writeBytes(message + "\n");
                        out.flush();
                        ActiveGame = false;
                    }
                    //else{

                      //  queue.enqueue(id,"ndjsa","jdn");

                    //}
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                return;
            }

        }
    }
}
