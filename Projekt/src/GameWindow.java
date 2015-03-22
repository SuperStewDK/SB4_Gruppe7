import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Steffen on 20-03-2015.
 */
public class GameWindow extends Application {

    private Integer width;
    private Integer height;
    private static String TITLE = "Viking Dodgeball";
    private Canvas canvas = new Canvas(800, 600);


    public void gameWindow(){


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 400, 600);
        root.getChildren().add(canvas);

        primaryStage.show();

    }

    public static void main(String args[]){
        launch(args);
    }

    /// THIS IS A TEST???
}
