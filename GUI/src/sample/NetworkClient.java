package sample;

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

    public String sendData(String data) throws IOException {

        InetAddress address= InetAddress.getLocalHost();
        Socket s1=null;
        String line;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;
        String response=null;
        try {
            s1=new Socket(address, 1994); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os= new PrintWriter(s1.getOutputStream());
            line=data;
            os.println(line);
            os.flush();
            response=is.readLine();
            return response;
        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }

        finally{

            is.close();os.close();br.close();s1.close();

        }
        System.out.println("Client Address : "+address);
        System.out.println("Enter Data to echo Server ( Enter QUIT to end):");
        return response;
    }
}
