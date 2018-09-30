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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class Controller {
    private static boolean Play = false ;
    private static String id;
    public String name;
    public String color;
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
        try {
            id = String.valueOf(UUID.randomUUID());
            System.out.println(id);
            name = NombreField.getText();
            color = IpField.getText();
            this.RegistroPanel.setVisible(false);
            this.InicialPanel.setVisible(false);
            this.EsperaPanel.setVisible(true);
            this.ContricantePanel.setVisible(false);
            client = new NetworkClient();
            JSONManager Manager = new JSONManager();
            String message = Manager.id(id, name, color);
            Play=client.sendData(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this.RegistroPanel.setVisible(true);
        //this.InicialPanel.setVisible(false);
        //this.EsperaPanel.setVisible(false);
        //this.ContricantePanel.setVisible(false);
    }

    public void onReadyButtonClicked(MouseEvent event) {
        if(Play) {
            this.RegistroPanel.setVisible(false);
            this.InicialPanel.setVisible(false);
            this.EsperaPanel.setVisible(false);
            this.ContricantePanel.setVisible(true);
        }
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
}