package DOTS;

/**
 * Clase para id de jugador
 */
public class Player {
    private int score=0;
    private boolean turn= false;
    private String color="";
    private String name="";
    private SimpleLinkedListLines shapes;
    private String id="a";
    private int conscore=0;

    public Player() {

    }

    public int getScore() {
        return score;
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

    public void setScore(int score) {
        this.score = score;
    }

    public SimpleLinkedListLines getShapes() {
        return shapes;
    }

    public void setShapes(SimpleLinkedListLines shapes) {
        this.shapes = shapes;
    }

    public int getConscore() {
        return conscore;
    }

    public void setConscore(int conscore) {
        this.conscore = conscore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
