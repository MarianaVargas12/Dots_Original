package sample;

import javafx.scene.shape.Line;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class segmento {
    private boolean Vali =true ;
    private double startx;
    private double starty;
    private double endx;
    private double endy;
    private static Line line1;

    /**
     * Ingreso de datos
     * @param startx
     * @param starty
     * @param endx
     * @param endy
     * @throws IOException
     */
    public segmento(double startx, double starty, double endx, double endy) throws IOException {
        this.starty=starty;
        this.startx=startx;
        this.endy=endy;
        this.endx=endx;
        int[][] vertices = new sample.Vertices().Vertices();
        this.line1=drawLine(startx,starty,endx,endy, vertices);


    }

    /**
     *
     * @return linea por hacer
     */
    public static Line getLine1() {
        return line1;
    }

    /**
     * verifica que esa linea se pueda hacer
     * @param Free
     * @param startx
     * @param starty
     * @param endx
     * @param endy
     * @return
     */
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

    /**
     * valida y se comunica con el servidor
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param vertices
     * @return
     * @throws IOException
     */
    public Line endVali(int startX, int startY, double endX, double endY, int[][] vertices) throws IOException {
        int ind = 0;
        String response;
        JSONManager manager = new JSONManager();
        JSONObject bool;
        while (ind < 36) {
            if (vertices[ind][0] <= endX && endX<= vertices[ind][1] && vertices[ind][2] >= endY && endY >= vertices[ind][3]) {

                try {
                    String message = manager.clientWrite(startX,startY,vertices[ind][4],vertices[ind][5],Controller.getId());
                    System.out.println(message);
                    response=Controller.client.sendData(message);
                    bool = manager.getArg(response);
                    boolean line = (bool.get("line")).equals(true);
                    return verif(line, startX, startY, vertices[ind][4], vertices[ind][5]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            ind++;
        }
        return null;
    }

    /**
     * Acomoda los datos pra que puedan ser validads y verifica que no se pase de los limites
     * @param startx
     * @param starty
     * @param endx
     * @param endy
     * @param vertices
     * @return
     * @throws IOException
     */
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
