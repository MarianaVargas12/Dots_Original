package DOTS;

<<<<<<< HEAD
public class Player {
    private static Player players= new Player();
    private boolean p1= false;
    private boolean p2=false;
    private boolean t1=false;
    private boolean t2=true;
    private boolean end1=false;
    private boolean end2=false;
    private int score1=0;
    private int socre2=0;
    

    public static void restart(){players= new Player();}

    public boolean isEnd1() {
        return end1;
    }

    public boolean isEnd2() {
        return end2;
    }

    public boolean isP1() {
        return p1;
    }

    public boolean isP2() {
        return p2;
    }

    public boolean isT1() {
        return t1;
    }

    public boolean isT2() {
        return t2;
    }

    public int getScore1() {
        return score1;
    }

    public static Player getPlayers() {
        return players;
    }

    public void setEnd1(boolean end1) {
        this.end1 = end1;
    }

    public int getSocre2() {
        return socre2;
    }

    public void setEnd2(boolean end2) {
        this.end2 = end2;
    }

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public void setP2(boolean p2) {
        this.p2 = p2;
    }

    public static void setPlayers(Player players) {
        Player.players = players;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setSocre2(int socre2) {
        this.socre2 = socre2;
    }

    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    public void setT2(boolean t2) {
        this.t2 = t2;
=======
import java.net.Socket;

public class Player {
    private static Player player=new Player();
    private int score=0;
    private boolean turn= false;
    private String color="";
    private String name="";
    private String shapes="";
    private int conscore=0;
    private static Socket client;

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    public static Player getPlayer() {
        return player;
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
>>>>>>> 52ada341f780f4a34268bc7e16f2d58d0ded84dc
    }
}
