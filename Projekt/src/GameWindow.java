import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameWindow extends Application {
    private Integer width;
    private Integer height;
    private static String TITLE = "Viking Dodgeball";
    private Canvas canvas = new Canvas(800, 600);
    private Timeline timeline;
    private KeyFrame keyframe;
    private GraphicsContext gc;


    public GameWindow(){
        GameController.getInstance().makeViking(10, 10);
        gameLoop();
        System.out.println("Why!");
    }


    public static void main(String[] args) {
        launch();

    }


    public void gameLoop(){
        System.out.println("testing...");
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);

        keyframe = new KeyFrame(Duration.millis(1000 / GameController.getInstance().frameRate), new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                GameController.getInstance().update();
                GameController.getInstance().redraw(gc);
            }

        });
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);

        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(0, 0, 400, 600);
        root.getChildren().add(canvas);
        primaryStage.show();

    }
}
