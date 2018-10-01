package sample;

import DOTS.SimpleLinkedListLines;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class clientPull extends Thread {
    private int data;
    private String id;
    private boolean Play;
    private int[] scores;
    private boolean clientActive=true;

    public clientPull(int Num,String id){
        this.data=Num;
        this.id=id;
    }

    /**
     * Thread para que el cliente realice pull cada n segundo y pueda actualizarse
     */
    public void run(){
        String response;
        JSONManager manager = new JSONManager();
        JSONObject bool;
        while(clientActive){
            //envia datos para la conxion
            //realiza pull hasta que pueda jugar
            if(data==2){
                try {
                    System.out.println("aqui2");
                    String message = manager.pull(id);
                    response = Controller.client.sendData(message);
                    bool = manager.getArg(response);
                    boolean playing = (bool.get("playing")).equals(true);
                    if(playing){
                        Thread.sleep(4000);
                        data=3;
                    }
                    Thread.sleep(4000);
                } catch (IOException | ParseException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // realiza un pull para saber su turno
            else if(data==3){
                try {
                    String message = manager.pull(id);
                    response=Controller.client.sendData(message);
                    bool = manager.getArg(response);
                    boolean turn = (bool.get("turn")).equals(true);
                    if(turn){
                        Controller.setPlay(turn);
                        Thread.sleep(4000);
                        data=5;
                    }
                    Thread.sleep(4000);
                } catch (IOException | ParseException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //realiza pull de las figuras formadad(actualizacion de la pantalla
            else if(data==6){
                try {
                    SimpleLinkedListLines vertices= new SimpleLinkedListLines();
                    String message = manager.pull(id);
                    response=Controller.client.sendData(message);
                    bool = manager.getArg(response);
                    boolean score = (bool.get("score")).equals(true);
                    boolean conscore = (bool.get("conscore")).equals(true);
                    for(int i=0;!(bool.get("x"+i)).equals(null);i++) {
                        boolean x = (bool.get("x"+i)).equals(true);
                        boolean y = (bool.get("y"+i)).equals(true);
                        vertices.append(x);

                    }
                    fill.polygon(vertices);
                    Thread.sleep(4000);
                    data=6;
                } catch (IOException | ParseException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //verifica que no haya terminado el juego
            else if(data==7){
                try {
                    String message = manager.pull(id);
                    response=Controller.client.sendData(message);
                    bool = manager.getArg(response);
                    boolean endGame = (bool.get("endGame")).equals(true);
                    if(endGame){
                        Controller.setPlay(endGame);
                        Thread.sleep(4000);
                        data=5;
                    }
                    Thread.sleep(4000);
                } catch (IOException | ParseException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}

