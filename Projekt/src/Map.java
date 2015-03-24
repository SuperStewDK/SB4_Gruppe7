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
    int w;
    int h;
    Image background;
    private Timer timer;
    private Viking viking;

    public Map(){

        ImageIcon icon = new ImageIcon("/Users/Mikkel/IdeaProjects/Project2/SB4_Gruppe7/Projekt/src/img/DodgeballMap.png");
        background = icon.getImage();

        w = background.getWidth(this);
        h = background.getHeight(this);
        setPreferredSize(new Dimension(w, h));

        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        viking = new Viking();

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(background, 0, 0, null);

        AffineTransform origForm = g2d.getTransform();
        AffineTransform newForm = (AffineTransform)(origForm.clone());

        newForm.rotate(Math.toRadians(viking.currentAngle),viking.getX()+viking.width/2,viking.getY()+viking.height/2);

        g2d.setTransform(newForm);
        g2d.drawImage(viking.getImage(), viking.getX(),viking.getY(), this);

        g2d.setTransform(new AffineTransform());
        ArrayList axes = viking.getAxes();

        for (int i = 0; i < axes.size(); i++) {
            Weapon w = (Weapon) axes.get(i);
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
