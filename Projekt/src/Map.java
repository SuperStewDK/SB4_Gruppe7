import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


/**
 * Created by Steffen on 20-03-2015.
 */
public class Map extends JPanel implements ActionListener {
    int width;
    int height;
    Image background;
    private Timer timer;
    private Viking viking;
    private Weapon w;

    public Map(){

        ImageIcon icon = new ImageIcon("/Users/Steffen/IdeaProjects/SB4_Gruppe7/Projekt/src/img/DodgeballMap.png");
        background = icon.getImage();

        width = background.getWidth(this);
        height = background.getHeight(this);
        setPreferredSize(new Dimension(width, height));

        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        viking = new Viking();

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        w = new Weapon();
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(background, 0, 0, null);
        g2d.drawImage(w.getImage(),w.getX(),w.getY(),this);

        // creating image of viking on map
        AffineTransform origForm = g2d.getTransform();
        AffineTransform newForm = (AffineTransform)(origForm.clone());

        newForm.rotate(Math.toRadians(viking.currentAngle),viking.getX()+viking.width/2,viking.getY()+viking.height/2);

        g2d.setTransform(newForm);
        g2d.drawImage(viking.getImage(), viking.getX(),viking.getY(), this);

        // creating image of a thrown axe on map
        g2d.setTransform(new AffineTransform());
        ArrayList axes = viking.getAxes();

        AffineTransform origAxe = g2d.getTransform();
        AffineTransform newAxe = (AffineTransform)(origAxe.clone());

        for (int i = 0; i < axes.size(); i++) {
            w = (Weapon) axes.get(i);
            newAxe.rotate(Math.toRadians(w.facing),w.getX()+w.width/2,w.getY()+w.height/2);
            g2d.setTransform(newAxe);
            g2d.drawImage(w.getImage(), w.getX(), w.getY(), this);
        }


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList axes = viking.getAxes();

        for (int i = 0; i < axes.size(); i++) {
            Weapon w = (Weapon) axes.get(i);
            if (w.isVisible()) {
                w.move(1);
            } else {
                axes.remove(i);
            }
        }

        viking.move();
        repaint();
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            viking.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            viking.keyPressed(e);
        }
    }

}
