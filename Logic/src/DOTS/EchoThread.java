package DOTS;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.net.ssl.*;
import javax.net.*;
import java.io.*;
import java.net.*;


public class EchoThread extends Thread {
    protected Socket socket;
    private JSONManager manager = new JSONManager();
    public DoubleLinkedList<DoubleLinkedList<Integer>> malla;
    Game game = new Game();



    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
        this.malla = game.Malla;
    }

    public void LogicLine(Node node1, Node node2) {
        node1.lineas.append(node2);
        node2.lineas.append(node1);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        Path path = new Path(node1);
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
>>>>>>> 950015c5858e881d2c3941b89560ff933348029b
    }

    public boolean CoordsToNode(String obj){
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
            for (int i = 0; i < Node1.lineas.getSize(); i++) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 950015c5858e881d2c3941b89560ff933348029b
                if (Node2 == Node1.lineas.getNode(i).getData()) {
                    return false;
                }
            }
            LogicLine(Node1, Node2);
<<<<<<< HEAD
=======
=======
                if (Node1 == Node2.lineas.getListNode(i).getData()) {
                    return false;
                }
            }
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
>>>>>>> 950015c5858e881d2c3941b89560ff933348029b
            return true;
        }
        else{
            return false;
        }
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));

            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();

                if(line == null){



                }else{
                    if (CoordsToNode(line)){
                        String message = manager.serverWrite(true, true);
                        out.writeBytes( message+ "\n");
                        out.flush();

                    }
                    else if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                        socket.close();
                        return;
                    }
                    else {
                        out.writeBytes( manager.serverWrite(false, false)+ "\n");
                        out.flush();
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
                return;


            }
        }

    }
    public void patito(){
<<<<<<< HEAD
        Player player= Player.getPlayers();
=======
<<<<<<< HEAD
        Player player= Player.getPlayers();
=======
        Players player= Players.getPlayers();
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
>>>>>>> 950015c5858e881d2c3941b89560ff933348029b
        if (!player.isP1()){
            //cerrar clientes y servidores
            player.setP1(true);
        }
        else if(!player.isP2()){
            //cerrar cliente y servidor
            player.setP2(true);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
            player.setT1(true);
            player.setT2(false);
            if(player.isT1()){
            }
            if(player.isT2()){

            }
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
>>>>>>> 950015c5858e881d2c3941b89560ff933348029b

        }
    }
}
