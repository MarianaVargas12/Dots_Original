package DOTS;

/**
 * Clase que se tienen datos de ambos jugadores
 */
public class Players {
    private boolean p1= false;
    private boolean p2=false;
    private static boolean t1=false;
    private static boolean t2=true;
    private boolean end1=false;
    private boolean end2=false;
    private int score1=0;
    private int score2=0;


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

    public static boolean isT1() {
        return t1;
    }

    public static boolean isT2() {
        return t2;
    }



    public void setEnd1(boolean end1) {
        this.end1 = end1;
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


    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    public void setT2(boolean t2) {
        this.t2 = t2;
    }
}
