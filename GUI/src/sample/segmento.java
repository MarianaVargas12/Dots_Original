package sample;

import javafx.scene.shape.Line;
import org.json.simple.JSONObject;

import java.io.IOException;

public class segmento {
    private double startx;
    private double starty;
    private double endx;
    private double endy;
    private static Line line1;

    public segmento(double startx, double starty, double endx, double endy) throws IOException {
        this.starty=starty;
        this.startx=startx;
        this.endy=endy;
        this.endx=endx;
        int[][] vertices = new sample.Vertices().Vertices();
        this.line1=drawLine(startx,starty,endx,endy, vertices);


    }

    public static Line getLine1() {
        return line1;
    }

    public Line verif(boolean Free, int startx, int starty, int endx, int endy) {
        if (Free == true) {
            Line line1 = new Line(startx, starty, endx, endy);
            return line1;
        }
        return null;
    }

    public boolean servidor(){
        return true;
    }

    public Line endVali(int startX, int startY, double endX, double endY, int[][] vertices) throws IOException {
        int ind = 0;
        while (ind < 36) {
            if (vertices[ind][0] <= endX && endX<= vertices[ind][1] && vertices[ind][2] >= endY && endY >= vertices[ind][3]) {
                //JSONManager Manager= new JSONManager();
                //String message = Manager.clientWrite(startX,startY,vertices[ind][4],vertices[ind][5]);
                //NetworkClient client= new NetworkClient();
                //client.sendData(message);

                boolean Vali= true;
                return verif(Vali, startX, startY, vertices[ind][4], vertices[ind][5]);
            }
            ind++;
        }
        return null;
    }

    public Line drawLine(double startx, double starty, double endx, double endy, int[][] vertices) throws IOException {
        int ind = 0;
        int[] coord = new int[4];
        while (ind < 36) {
            if (vertices[ind][0] <= startx && startx <= vertices[ind][1] && vertices[ind][2] >= starty && starty >= vertices[ind][3]) {
                coord[0] = vertices[ind][4];
                coord[1] = vertices[ind][5];
                return endVali(coord[0],coord[1],endx,endy,vertices);
            }
            ind++;
        }
        return null;
    }
}
