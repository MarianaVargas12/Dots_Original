package DOTS;

import java.net.Socket;

public class Player {
    private int score=0;
    private boolean turn= false;
    private String color="";
    private String name="";
    private String shapes="";
    private int conscore=0;
    private static Socket client;

    public Player(){

    }

    public boolean isTurn() {
        return turn;
    }

    public int getScore() {
        return score;
    }

    public String getColor() {
        return color;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getConscore() {
        return conscore;
    }

    public String getName() {
        return name;
    }

    public String getShapes() {
        return shapes;
    }

    public void setConscore(int conscore) {
        this.conscore = conscore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShapes(String shapes) {
        this.shapes = shapes;
    }

    public static Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }
}
