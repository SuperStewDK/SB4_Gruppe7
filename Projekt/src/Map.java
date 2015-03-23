import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Steffen on 20-03-2015.
 */
public class Map extends JPanel implements ActionListener {
    int width;
    int height;
    private Image background;
    private Viking viking;
    private Timer timer;
    Graphics2D g2d;

    public Map() {

        initMap();

        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);

        timer = new Timer(5, this);
        timer.start();

        viking = new Viking();
    }

    public void initMap() {

        loadImage();

        width = background.getWidth(this);
        height = background.getHeight(this);
        setPreferredSize(new Dimension(width, height));

    }

    private void loadImage() {

        ImageIcon imageIcon = new ImageIcon("/Users/benjaminmlynek/Coding/IdeaProjects/SB4_Gruppe7/Projekt/src/img/DodgeballMap.png");
        background = imageIcon.getImage();

    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(background, 0, 0, null);

    }

    public void paint(Graphics g) {
        super.paint(g);

        g2d = (Graphics2D) g;

        g2d.drawImage(viking.getImage(), viking.getX(), viking.getY(), this);

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
            }else {
                axes.remove(i);
            }
        }

        viking.move(10);
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
