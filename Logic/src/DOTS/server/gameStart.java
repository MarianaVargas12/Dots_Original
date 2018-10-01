
package DOTS.server;


import DOTS.*;
import sample.ListID.ListID;
import sample.Queue.LinkedQueue;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.Socket;

public class gameStart extends Thread{;
    private  static Player P1= ThreadedEchoServer.getP1();
    private  static Player P2=ThreadedEchoServer.getP2();
    protected Socket socket;
    private Players players=ThreadedEchoServer.getPlayers();
    private DoubleLinkedList<DoubleLinkedList<Integer>> malla =ThreadedEchoServer.getMalla();
    private boolean ActiveGame=true;
    private boolean endGame=false;
    private LinkedQueue queue= ThreadedEchoServer.getQueue();
    private ListID listID= ThreadedEchoServer.getListID();
    private boolean figura;
    private static int Score;



    public gameStart(Socket client) {
        this.socket=client;
    }

    public static Player getP1() {
        return P1;
    }

    public static Player getP2() {
        return P2;
    }

    public static void setScore(int score) {
        Score = score;
    }

    public void LogicLine(Node node1, Node node2) {
        node1.lineas.append(node2);
        node2.lineas.append(node1);
        Path path = new Path(node1);
        figura=path.Vertices(node1);
    }
    public boolean EndGame(){
        if (P1.getScore()+30 > P2.getScore() || P1.getScore() < P2.getScore()+30 || endGame){
            return true;
        }else{
            return false;
        }
    }
    private boolean CoordsToNode(String obj){
        JSONManager manager = new JSONManager();
        JSONObject xy = new JSONObject();
        try {
            xy = manager.getArg(obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(xy);
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

            for (int i = 0; i < Node1.lineas.getSize(); i++) {
                System.out.println(Node1.lineas.getNode(i).getData());
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
    public boolean checkID(String id){
        if(listID.getSize()==0){
            listID.add(id);
            return true;
        }
        else if(!listID.search(id)){
            return true;
        }
        return false;

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
                    P1.setColor(queue.color());
                    P1.setName(queue.name());
                    P1.setId(id);
                    players.setP1(true);
                    System.out.println(players.isP1());
                    String message = manager.Connect(true);
                    out.writeBytes(message + "\n");
                    out.flush();
                    ActiveGame=false;
                }
                else if (!players.isP2() && !id.equals(P1.getId())) {
                    P2.setColor(queue.color());
                    P2.setName(queue.name());
                    P2.setId(id);
                    players.setP2(true);
                    String message = manager.Connect(true);
                    out.writeBytes(message + "\n");
                    out.flush();
                    ActiveGame=false;
                    //enviar booleano para pasar de pantalla
                } else if (players.isP1() && players.isP2()) {
                    if (id.equals(P1.getId()) || id.equals(P2.getId())) {
                         if (EndGame()) {
                            if (P1.getScore() > P2.getScore()) {
                                if(id.equals(P1.getId())) {
                                    players.setP1(false);
                                    players.setP2(false);
                                    String message = manager.end(true);
                                    out.writeBytes(message + "\n");
                                    out.flush();
                                }else{
                                    players.setP1(false);
                                    players.setP2(false);
                                    String message = manager.end(true);
                                    out.writeBytes(message + "\n");
                                    out.flush();
                                } }
                            if (P1.getScore() == P2.getScore()) {
                                if (id.equals(P1.getId())) {
                                    players.setP1(false);
                                    players.setP2(false);
                                    String message = manager.end(true);
                                    out.writeBytes(message + "\n");
                                    out.flush();
                                } else {
                                    players.setP1(false);
                                    players.setP2(false);
                                    String message = manager.end(true);
                                    out.writeBytes(message + "\n");
                                    out.flush();
                                }

                                if (P1.getScore() < P2.getScore()) {
                                    if (id.equals(P1.getId())) {
                                        players.setP1(false);
                                        players.setP2(false);
                                        String message = manager.end(false);
                                        out.writeBytes(message + "\n");
                                        out.flush();
                                    } else {
                                        players.setP1(false);
                                        players.setP2(false);
                                        String message = manager.end(true);
                                        out.writeBytes(message + "\n");
                                        out.flush();
                                    }
                                }
                            }}
                        if(players.isEnd1() || players.isEnd2()){
                            if(id.equals(P1.getId())){
                                String op = manager.Play(true);
                                out.writeBytes(op + "\n");
                                out.flush();
                                players.setEnd1(false);
                                ActiveGame=false;
                            }else if(id.equals(P2.getId())){
                                String op = manager.Play(true);
                                out.writeBytes(op + "\n");
                                out.flush();
                                players.setT1(true);
                                players.setEnd2(false);
                                ActiveGame=false;
                            }else{
                                String op = manager.Turn(false);
                                out.writeBytes(op + "\n");
                                out.flush();
                                ActiveGame=false;
                            }
                        }
                        if (Players.isT1() && id.equals(P1.getId())) {
                            if (line == null) {
                            }
                            else {
                                if (CoordsToNode(line)) {
                                    if (figura) {
                                        P1.setScore(P1.getScore()+Score);
                                        P2.setConscore(P1.getScore()+Score);
                                        players.setT1(false);
                                        players.setT2(true);
                                        System.out.println("yeei");
                                        players.setT1(false);
                                        players.setT2(true);
                                        String op = manager.line(true);
                                        out.writeBytes(op + "\n");
                                        out.flush();
                                        //figura formada enviar vertices y asignar puntos al id del jugador
                                        ActiveGame=false;
                                    } else {
                                        String draw = manager.line(true);
                                        out.writeBytes(draw + "\n");
                                        out.flush();
                                        players.setT1(false);
                                        players.setT2(true);
                                        ActiveGame=false;
                                    }

                                }
                                else if(!CoordsToNode(line)){
                                    String draw = manager.line( false);
                                    out.writeBytes(draw + "\n");
                                    out.flush();
                                    players.setT1(true);
                                    players.setT2(false);
                                    ActiveGame=false;
                                }
                                else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                                    socket.close();
                                    ActiveGame=false;
                                } else {
                                    out.writeBytes(manager.line(false) + "\n");
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
                                    if (figura) {
                                        P2.setScore(P2.getScore()+Score);
                                        P1.setConscore(P2.getScore()+Score);
                                        System.out.println("yeei");
                                        String draw = manager.line(true);
                                        out.writeBytes(draw + "\n");
                                        out.flush();
                                        //figura formada enviar vertices y asignar puntos al id del jugador
                                        players.setT1(true);
                                        players.setT2(false);
                                        ActiveGame=false;
                                    } else {
                                        String draw = manager.line(true);
                                        out.writeBytes(draw + "\n");
                                        out.flush();
                                        players.setT1(true);
                                        players.setT2(false);
                                        ActiveGame=false;
                                    }

                                }
                                else if(!CoordsToNode(line)){
                                    String draw = manager.line( false);
                                    out.writeBytes(draw + "\n");
                                    out.flush();
                                    players.setT1(false);
                                    players.setT2(true);
                                    ActiveGame=false;
                                }
                                else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                                    socket.close();
                                    ActiveGame=false;
                                } else {
                                    out.writeBytes(manager.line(false) + "\n");
                                    out.flush();
                                    ActiveGame=false;
                                }
                            }
                        }else if(id.equals(P1.getId())){
                            String draw = manager.update(false,P1.getScore(),P1.getConscore(),P1.getShapes());
                            out.writeBytes(draw + "\n");
                            out.flush();
                            ActiveGame=false;
                        }
                        else if(id.equals(P2.getId())){
                            String draw = manager.update(false,P2.getScore(),P2.getConscore(),P2.getShapes());
                            out.writeBytes(draw + "\n");
                            out.flush();
                            ActiveGame=false;
                        }
                        ActiveGame=false;
                    }else {
                        if(checkID(id)) {
                            String name = (String) xy.get("name");
                            String color = (String) xy.get("color");
                            queue.enqueue(id, name, color);
                            String draw = manager.Play(false);
                            out.writeBytes(draw + "\n");
                            out.flush();
                            ActiveGame=false;
                        }else{
                            String draw = manager.Play(false);
                            out.writeBytes(draw + "\n");
                            out.flush();
                            ActiveGame=false;
                        }
                    }
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                return;
            }

        }
    }
}