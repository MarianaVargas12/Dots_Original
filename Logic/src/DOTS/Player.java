package DOTS;

public class Player {
    private int score=0;
    private boolean turn= false;
    private String color="";
    private String name="";
    private String shapes="";
    private int conscore=0;
    private static Socket client;

    public Player() {

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
    }
}
