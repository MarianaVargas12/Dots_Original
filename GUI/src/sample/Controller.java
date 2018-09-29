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

public class Controller implements Initializable {
    public static String name;
    public static String color;
    public static  NetworkClient client;
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
    private boolean willConsume = false;
    public Controller() {
    }

    public void onExitButtonClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void onOkButtonClicked(MouseEvent event) {
        this.RegistroPanel.setVisible(true);
        this.InicialPanel.setVisible(false);
        this.EsperaPanel.setVisible(false);
        this.ContricantePanel.setVisible(false);
    }

    public void onReadyButtonClicked(MouseEvent event) {
        name=NombreField.getText();
        color= IpField.getText();
        System.out.println(NombreField.getText());
        System.out.println(IpField.getText());
        this.RegistroPanel.setVisible(false);
        this.InicialPanel.setVisible(false);
        this.EsperaPanel.setVisible(false);
        this.ContricantePanel.setVisible(true);
        client= new NetworkClient();
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
    EventHandler<KeyEvent> handlerLetters= new EventHandler<KeyEvent>() {
        private boolean willConsume=true;
        @Override
        public void handle(KeyEvent event) {
            Object temp0 = event.getSource();
            if (willConsume) {
                event.consume();
            }

            String temp = event.getCode().toString();
            if (!event.getCode().toString().matches("[a-zA-Z]") && event.getCode() != KeyCode.BACK_SPACE && event.getCode() != KeyCode.SHIFT) {
                if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    this.willConsume = true;
                } else if (event.getEventType() == KeyEvent.KEY_PRESSED) {
                    this.willConsume = false;
                }
            }
        }
    };
    EventHandler<KeyEvent> handlerNumbers= new EventHandler<KeyEvent>() {
        private boolean willConsume=false;
        private int maxLenght=10;

        @Override
        public void handle(KeyEvent event) {
            JFXTextField temp=(JFXTextField) event.getSource();
            if(willConsume){
                event.consume();
            }
            if(!event.getText().matches("[0-9]") && event.getCode()!=KeyCode.BACK_SPACE){
                if(event.getEventType()==KeyEvent.KEY_PRESSED){
                    willConsume=true;
                }else if(event.getEventType()==KeyEvent.KEY_RELEASED){
                    willConsume=false;
                }
            }
            if(temp.getText().length()>maxLenght-1){
                if(event.getEventType()==KeyEvent.KEY_PRESSED){
                    willConsume=true;
                }else if(event.getEventType()==KeyEvent.KEY_RELEASED){
                    willConsume=false;
                }
            }

        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //NombreField.addEventFilter(<handlerLetters>);
        //IpField.addEventFilter(KeyEvent.ANY.handlerNumbers);
    }
}