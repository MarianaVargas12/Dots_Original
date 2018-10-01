package DOTS;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

    public JSONManager() {}
    public String Connect (boolean connect) {

        JSONObject obj = new JSONObject();

        obj.put("connect", connect);

        return obj.toString();
    }

    public String Play(boolean playing) {

        JSONObject obj = new JSONObject();

        obj.put("playing", playing);

        return obj.toString();
    }

    public String Turn(boolean turn) {

        JSONObject obj = new JSONObject();

        obj.put("turn", turn);

        return obj.toString();
    }

    public String line(boolean line) {

        JSONObject obj = new JSONObject();

        obj.put("line", line);

        return obj.toString();
    }

    public String score (int score, int conscore) {

        JSONObject obj = new JSONObject();

        obj.put("score", score);
        obj.put("conscore", conscore);

        return obj.toString();
    }
    //public String shape (List list) {

        //JSONObject obj = new JSONObject();
        //for(int i=0; current==null; i++) {

          //  obj.put("x"+i, current.getx());
            //obj.put("y"+i, current.gety());
        //}
        //return obj.toString();
    //}
    public String end(boolean endGame) {

        JSONObject obj = new JSONObject();
        obj.put("endGame", endGame);

        return obj.toString();
    }


    public JSONObject getArg(String arg) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(arg);
        return obj;

    }
}
