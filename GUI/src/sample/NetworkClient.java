package sample;

import DOTS.JSONManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {

    public static void main(String args[])  throws IOException{

        NetworkClient nC = new NetworkClient();

        nC.sendData("123");

    }

    public boolean sendData(String data) throws IOException {


        InetAddress address= InetAddress.getLocalHost();
        Socket s1=null;
        String line=null;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;
        JSONManager manager = new JSONManager();
        JSONObject bool;

        try {
            s1=new Socket(address, 1818); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os= new PrintWriter(s1.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }

        System.out.println("Client Address : "+address);
        System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

        String response=null;
        try{

            line=data;
            os.println(line);
            os.flush();
            response=is.readLine();
            bool = manager.getArg(response);
            System.err.print(bool);
            boolean playing = (bool.get("playing")).equals(true);
            boolean draw= (bool.get("draw")).equals(true);
            boolean pull= (bool.get("pull")).equals(true);

            if(pull){
                return false;
            }
            else if(playing && draw){
                return true;
            }

            else if(draw){
                return true;

            }
            else{
                System.out.println("else");
                return false;
            }

        }
        catch(IOException | ParseException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }
        finally{

            is.close();os.close();br.close();s1.close();

        }
        return false;

    }
}
