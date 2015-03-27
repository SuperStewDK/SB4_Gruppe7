import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * Created by Steffen on 20-03-2015.
 */
public class Viking extends JComponent {
    private int healthPool;
    private double speed = 3;
    int width;
    int height;
    private String viking = "/Users/Steffen/IdeaProjects/SB4_Gruppe7/Projekt/src/img/helmet.gif";
    private int x;
    private int y;
    private Image image;
    double currentAngle;
    boolean up = false, down= false, left= false, right= false;
    boolean canThrow;

    //Weapon
    private ArrayList axes;
    private final int VIKING_SIZE = 20;

    public Viking() {
        ImageIcon ii = new ImageIcon(viking);
        image = ii.getImage().getScaledInstance(37,77,Image.SCALE_SMOOTH);
        width = 37;
        height = 77;
        axes = new ArrayList();
        canThrow = false;
        x = 40;
        y = 60;

    }

    public void draw(Graphics g){
        // creating image of viking on map
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform origForm = g2d.getTransform();
        AffineTransform newForm = (AffineTransform)(origForm.clone());

        newForm.rotate(Math.toRadians(currentAngle),getX()+width/2,getY()+height/2);

        g2d.setTransform(newForm);
        g2d.drawImage(getImage(), getX(),getY(), this);
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

    public void move(){
        if(left && !right){
            currentAngle -= 5;
        }
        if(right && !left){
            currentAngle += 5;
        }
        if(up && !down){
            double angle = Math.toRadians( currentAngle );
            x += (int) Math.round( Math.cos(angle) * speed);
            y += (int) Math.round( Math.sin(angle) * speed);
        }

        if(down && !up){
            double angle = Math.toRadians( currentAngle );
            x -= (int) Math.round( Math.cos(angle) * speed);
            y -= (int) Math.round( Math.sin(angle) * speed);
        }

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            throwAxe();
        }

        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }

        if (key == KeyEvent.VK_UP) {
            up = true;
        }

        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }

        if (key == KeyEvent.VK_UP) {
            up = false;
        }

        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
    }
    public void pickUp(Object obj) {

    }

    public void throwAxe() {
        Weapon weapon = new Weapon(x + VIKING_SIZE, y + VIKING_SIZE/2);
        weapon.setFacing(currentAngle);
        axes.add(weapon);
    }

    public ArrayList getAxes() {
        return axes;
    }

    public void update(double deltaT) {

    }

    public boolean onHit() {
        return true;
    }

    private boolean checkHealth(int health) {

        if (health == 0) {
            return false;
        }
        return true;
    }

}
