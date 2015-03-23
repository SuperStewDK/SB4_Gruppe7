import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Component.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.ArrayList;

/**
 * Created by Steffen on 20-03-2015.
 */

public class Viking implements IEntity {
    private int healthPool;
    private double speed;
    private double xPosition;
    private double yPosition;
    private boolean canAttack;
    private double facing;

    private String viking = "/Users/benjaminmlynek/Coding/IdeaProjects/SB4_Gruppe7/Projekt/src/img/helmet.gif";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private ArrayList axes;
    private final int VIKING_SIZE = 20;
    private int width;
    private int height;

    public Viking() {

        ImageIcon ii = new ImageIcon(viking);
        image = ii.getImage().getScaledInstance(77, 36, Image.SCALE_SMOOTH);

        axes = new ArrayList();
        x = 40;
        y = 60;

    }

    public void pickUp(Object obj) {

    }

    public void move(double deltaT) {

        x += dx;
        y += dy;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent keyEvent) {

        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            throwAxe();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }

    }


    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public void throwAxe() {

        axes.add(new Weapon(x + VIKING_SIZE, y + VIKING_SIZE/2));

    }

    public ArrayList getAxes() {
        return axes;
    }

    public void update(double deltaT) {

    }

    public void onHit() {

    }

    private boolean checkHealth(int health) {

        if (health == 0) {
            return false;
        }
        return true;
    }

}
