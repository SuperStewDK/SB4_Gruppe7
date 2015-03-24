import javax.swing.*;
import java.awt.*;

/**
 * Created by Steffen on 20-03-2015.
 */
public class Weapon implements IEntity {

    private double speed;
    private double xPosition;
    private double yPosition;
    public double facing;

    private boolean visible;
    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 15;
    private Image image;
    private int x,y;
    public int width, height;

    private String axe = "/Users/Steffen/IdeaProjects/SB4_Gruppe7/Projekt/src/img/throwingaxe.png";

    public Weapon(int x, int y) {
        width = 40;
        height = 30;
        ImageIcon ii = new ImageIcon(axe);
        image = ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        visible = true;
        this.x = x;
        this.y = y;
    }

    public void onHit() {
    }

    public void update(double deltaT) {
    }


    public void setFacing(double facing) {
        this.facing = facing;
    }

    public void move(double deltaT) {
        double angle = Math.toRadians( facing );
        x += (int) Math.round( Math.cos(angle) * MISSILE_SPEED);
        y += (int) Math.round( Math.sin(angle) * MISSILE_SPEED);
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
