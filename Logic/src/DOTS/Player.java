package DOTS;

public class Player {
    private int score=0;
    private boolean turn= false;
    private String color="";
    private String name="";
    private String shapes="";
    private int conscore=0;

    public Player() {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShapes() {
        return shapes;
    }

    public void setShapes(String shapes) {
        this.shapes = shapes;
    }

    public int getConscore() {
        return conscore;
    }

    public void setConscore(int conscore) {
        this.conscore = conscore;
    }
}
