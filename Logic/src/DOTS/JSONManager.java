package DOTS;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

    public JSONManager() {}

    public String Play(boolean playing, boolean draw, boolean pull) {

        JSONObject obj = new JSONObject();

        obj.put("playing", playing);
        obj.put("draw", draw);
        obj.put("pull", pull);

        return obj.toString();
    }

    public String serverWrite(boolean draw,boolean playing, boolean pull) {

        JSONObject obj = new JSONObject();

        obj.put("draw", draw);
        obj.put("playing", playing);
        obj.put("pull", pull);

        return obj.toString();
    }


    public JSONObject getArg(String arg) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(arg);
        return obj;

    }
}
