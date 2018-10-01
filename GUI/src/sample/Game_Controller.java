package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class Game_Controller{
    @FXML
    private AnchorPane Game;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private boolean Flag;
    private int Score=0;
    private int Conscore=0;
    private boolean Turno;


    public Game_Controller(){
        this.startX=0;
        this.startY=0;
        this.endX=0;
        this.endY=0;
        this.Flag=false;
    }


    public void onExitButton(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }


    public void coordinate(MouseEvent event){
        if(Flag==false){
            this.startX=event.getX();
            this.startY=event.getY();
            this.Flag=true;
        }else{
            try {
                this.endY = event.getY();
                this.endX = event.getX();
                segmento line1 = new segmento(startX, startY, endX, endY);
                Game.getChildren().addAll(segmento.getLine1());
                this.Flag = false;
            }catch (Exception e){
                return;
            }

        }
    }

    public static void Score(int Score){

    }
    public static void Conscore(int conScore){

    }
    public void turno(boolean Turno){
        if(Turno){
            System.out.println("sii");
        }
    }
}