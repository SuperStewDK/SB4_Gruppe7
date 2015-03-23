import javax.swing.*;
import java.awt.*;

/**
 * Created by Steffen on 20-03-2015.
 */
public class Weapon implements IEntity {

    private double speed;
    private double xPosition;
    private double yPosition;
    private double facing;

    private boolean visible;
    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 20;
    private Image image;
    private int x,y;

    private String axe = "/Users/benjaminmlynek/Coding/IdeaProjects/SB4_Gruppe7/Projekt/src/img/throwingaxe.jpg";

    public Weapon(int x, int y) {
        ImageIcon ii = new ImageIcon(axe);
        image = ii.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        visible = true;
        this.x = x;
        this.y = y;
    }

    public void onHit() {
    }

    public void update(double deltaT) {
    }

    public void move(double deltaT) {

        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH){
            visible = false;
        }

    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }
}
