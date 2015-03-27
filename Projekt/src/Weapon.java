import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

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

    public Weapon(){
        ImageIcon icon = new ImageIcon(axe);
        image = icon.getImage();
        visible = true;
        x = 480;
        y = 350;
    }

    public Weapon(int x, int y) {
        width = 40;
        height = 30;
        ImageIcon ii = new ImageIcon(axe);
        image = ii.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        visible = true;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g, Viking viking, Weapon weapon){
        // creating image of a thrown axe on map
        Graphics2D g2d = (Graphics2D) g;
        g2d.setTransform(new AffineTransform());
        ArrayList axes = viking.getAxes();

        AffineTransform origAxe = g2d.getTransform();
        AffineTransform newAxe = (AffineTransform)(origAxe.clone());

        for (int i = 0; i < axes.size(); i++) {
            weapon = (Weapon) axes.get(i);
            newAxe.rotate(Math.toRadians(weapon.facing),weapon.getX()+weapon.width/2,weapon.getY()+weapon.height/2);
            g2d.setTransform(newAxe);
            g2d.drawImage(weapon.getImage(), weapon.getX(), weapon.getY(), null);
        }
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
        if (x > BOARD_WIDTH || x < 0 || y < 0 || y > new GameWindow().height){
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
