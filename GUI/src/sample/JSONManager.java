package sample;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public class JSONManager {

    JSONManager() {}


    public String clientWrite(int x1, int y1, int x2, int y2, String id) {

        JSONObject obj = new JSONObject();

        obj.put("x1", x1);
        obj.put("y1", y1);
        obj.put("x2", x2);
        obj.put("y2", y2);
        obj.put("id", id);


        return obj.toString();


    }

    public String id(String id, String name,String color) {

        JSONObject obj = new JSONObject();

        obj.put("id", id);
        obj.put("name", name);
        obj.put("color", color);


        return obj.toString();


    }
    public String pull(String id){
        JSONObject obj = new JSONObject();

        obj.put("id", id);

        return obj.toString();
    }


    public JSONObject getArg(String arg) throws ParseException{
        JSONParser parser = new JSONParser();

        JSONObject obj = (JSONObject) parser.parse(arg);

        return obj;

    }
}
