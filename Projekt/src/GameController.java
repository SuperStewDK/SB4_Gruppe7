import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

/**
 * Created by Steffen on 20-03-2015.
 */
public class GameController {

    int frameRate;
    long time;
    ArrayList<Entity> entityList;
    private static GameController instance;

    private GameController() {
        entityList = new ArrayList<Entity>();
        frameRate = 1;
        System.out.println("Hi!");


    }

    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();

        return instance;

    }

    public long getDelta() {
        return 0;
    }

    public void makeViking(int x, int y) {
        entityList.add(new Viking(x, y));

    }

    public void update() {


    }

    public void redraw(GraphicsContext gc) {

    }
}
