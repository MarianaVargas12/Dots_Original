package DOTS;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

    public JSONManager() {}

    /**
     * envio de datos de acuerdo a la conexion
     * @param connect
     * @return booleano de acuerdo a su conexion
     */
    public String Connect (boolean connect) {

        JSONObject obj = new JSONObject();

        obj.put("connect", connect);

        return obj.toString();
    }

    /**
     * funcion que inidica si podra jugar
     * @param playing
     * @return string plaiyng
     */
    public String Play(boolean playing) {

        JSONObject obj = new JSONObject();

        obj.put("playing", playing);

        return obj.toString();
    }

    /**
     * indica si es el turno de el o no
     * @param turn
     * @return string turn
     */
    public String Turn(boolean turn) {

        JSONObject obj = new JSONObject();

        obj.put("turn", turn);

        return obj.toString();
    }

    /**
     * Envia si se puede realizar una linea
     * @param line
     * @return string line
     */
    public String line(boolean line) {

        JSONObject obj = new JSONObject();

        obj.put("line", line);

        return obj.toString();
    }

    /**
     * Metodo que envia datos para actualizacion de pantalla
     * @param turn
     * @param score
     * @param conscore
     * @param vertices
     * @return string turn,score,conscore,vertices
     */
    public String update(boolean turn,int score, int conscore, SimpleLinkedListLines vertices){
        JSONObject obj = new JSONObject();
        obj.put("turn", turn);
        obj.put("score", score);
        obj.put("conscore", conscore);
        //for(int i=0; vertices.getNode(i).getData()!=null && vertices.getSize()>0;i++){

          //  obj.put("x"+1, vertices.getNode(i).getX());
            //obj.put("x"+2, vertices.getNode(i).getY());

       // }

        return obj.toString();
    }

    /**
     * Metodo indicador de finalzacion
     * @param endGame
     * @return String endGame
     */
    public String end(boolean endGame) {

        JSONObject obj = new JSONObject();
        obj.put("endGame", endGame);

        return obj.toString();
    }


    /**
     * Convierte datos
     * @param arg
     * @return objeto JSON
     * @throws ParseException
     */
    public JSONObject getArg(String arg) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(arg);
        return obj;

    }
}
