import javafx.scene.shape.Rectangle;
import sun.applet.Main;

import java.awt.*;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Created by Steffen on 20-03-2015.
 */
public class GameWindow extends JPanel implements ActionListener, KeyListener {

    // Størrelse på Window.
    private int width = 800;
    private int height = 600;

    // Størrelse på Viking (rectangle).
    private int vikingBred = 65;
    private int vikingHøj = 35;

    // Placering af Viking.
    private int rectX = 100;
    private int rectY = 100;

    // Viking Movement Speed.
    private int velX = 0;
    private int velY = 0;

    // This refers to the actionListener.
    Timer timer = new Timer(1, this);

    public GameWindow () {

        timer.start();
        // This is for the KeyListener.
        addKeyListener(this);
        // Enable the keylistener.
        setFocusable(true);
        // Disabling the SHIFT and TAB Keys.
        setFocusTraversalKeysEnabled(false);
    }

    // PaintComponent kan bruges til animation.
    public void paintComponent(Graphics g){
        super.paintComponents(g);

        g.setColor(Color.BLUE);
        g.fillRect(rectX, rectY, vikingBred, vikingHøj);

    }

    // Adding movement to the rectangle with key pressed.
    public void keyPressed(KeyEvent e){

        int k = e.getKeyCode();

        if (k == KeyEvent.VK_DOWN) {
            velX = 5;
            velY = 0;
        }

        if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT){
            velX = -1;
            velY = 0;
        }

        if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP){
            velX = 0;
            velY = -1;
        }

        if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT){
            velX = 1;
            velY = 0;
        }
        //

        if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN){
            velX = 0;
            velY = 1;
        }
    }

    // Adding movement to the rectangle.
    public void actionPerformed(ActionEvent e){
        if (rectX < 0){
            velX = 0;
            rectX = 0;
        }

        if (rectX > (width - vikingBred)){
            velX = 0;
            rectX = (width - vikingBred);
        }

        if (rectY < 0){
            velY = 0;
            rectY = 0;
        }

        if (rectY > (height - vikingHøj)){
            velY = 0;
            rectY = (height - vikingHøj);
        }


       rectX = rectX + velX;
       rectY = rectY + velY;
        repaint();

    }


    public void keyTyped(KeyEvent e){

    }


    // If key is released, the rect has to stop.
    public void keyReleased(KeyEvent e){
        velX = 0;
        velY = 0;
    }

    public static void createWindow() {

        GameWindow gW = new GameWindow();
        // Craete the JFrame
        JFrame dodgeBallFrame = new JFrame("Viking Dodgeball");
        // Window size & size the frame.
        dodgeBallFrame.setPreferredSize(new Dimension(800, 600));
        dodgeBallFrame.pack();
        // Background Color.
        //dodgeBallFrame.getContentPane().setBackground(Color.GRAY);
        //gW.setBackground(Color.GRAY);

        // Windows location to center of monitor.
        dodgeBallFrame.setLocationRelativeTo(null);
        // /Viewable window.
        dodgeBallFrame.setVisible(true);
        // Non-Resizable window.
        dodgeBallFrame.setResizable(false);
        // Make sure window will close on 'X'.
        dodgeBallFrame.setDefaultCloseOperation(dodgeBallFrame.EXIT_ON_CLOSE);
        dodgeBallFrame.add(gW);

        //JPanel dodgeBallPanel = new JPanel();
        //JLabel dodgeBallLabel = new JLabel();
        //dodgeBallLabel.setText("Dodgeball");
       //dodgeBallLabel.setToolTipText("The Viking will be floating here!");

       //dodgeBallPanel.add(dodgeBallLabel);
       //dodgeBallFrame.add(dodgeBallPanel);




    }

   // private static void launch(){
//
  //      gameWindow();
    //});



    public static void main(String [] args) {
        createWindow();
    }

}
