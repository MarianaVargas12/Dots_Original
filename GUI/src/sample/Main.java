package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private double xOffset;
    private double yOffset;
    static Stage game;


    public Main() {
    }

    public void start(final Stage primaryStage) throws Exception {
        Main.game=primaryStage;
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Main.this.xOffset = event.getSceneX();
                Main.this.yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX());
                primaryStage.setY(event.getScreenY());
            }
        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Dots");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    static void setScene(String scene_route) throws IOException{
        Parent root= FXMLLoader.load(Main.class.getResource(scene_route));
        Scene scene = new Scene(root);
        game.setScene(scene);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
