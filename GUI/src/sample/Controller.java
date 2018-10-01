package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class Controller {
    private static boolean Play = false ;
    private static String id;
    private static String name;
    private static String color;
    public static NetworkClient client;
    @FXML
    private AnchorPane InicialPanel;
    @FXML
    private AnchorPane RegistroPanel;
    @FXML
    private AnchorPane EsperaPanel;
    @FXML
    private AnchorPane ContricantePanel;
    @FXML
    private JFXTextField IpField;
    @FXML
    private JFXTextField NombreField;

    public Controller() {
    }

    public void onExitButtonClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public static String getId() {
        return id;
    }

    public void onOkButtonClicked(MouseEvent event) {
        String response;
        JSONManager manager = new JSONManager();
        JSONObject bool;
        id = String.valueOf(UUID.randomUUID());
        System.out.println(id);
        name = NombreField.getText();
        color = IpField.getText();
        client = new NetworkClient();
        new clientPull(1,id);
        try {
            String message = manager.id(id, Controller.getName(), Controller.getColor());
            response=Controller.client.sendData(message);
            bool = manager.getArg(response);
            boolean connect = (bool.get("connect")).equals(true);
            System.out.println(connect);
            if(connect) {
                this.RegistroPanel.setVisible(false);
                this.InicialPanel.setVisible(false);
                this.EsperaPanel.setVisible(true);
                this.ContricantePanel.setVisible(false);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        //new clientPull(2,id);
        onReady();
    }
    public void onReady(){
        System.out.println("aqui");
        this.RegistroPanel.setVisible(false);
        this.InicialPanel.setVisible(false);
        this.EsperaPanel.setVisible(false);
        this.ContricantePanel.setVisible(true);

    }

    public void onPlayButtonClicked(MouseEvent event) {
        this.RegistroPanel.setVisible(true);
        this.InicialPanel.setVisible(false);
        this.EsperaPanel.setVisible(false);
        this.ContricantePanel.setVisible(false);
    }

    @FXML
    public void OnGame() throws IOException {
        Main.setScene("Game.fxml");
    }

    public static String getName() {
        return name;
    }

    public static String getColor() {
        return color;
    }

    public static void setPlay(boolean play) {
        Play = play;
    }

    public static boolean isPlay() {
        return Play;
    }
}