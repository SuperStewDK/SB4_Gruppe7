import javafx.scene.control.Hyperlink;
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


public class GameWindow extends JPanel implements  ActionListener {

    // Size of Window.
    private int width = 1200;
    private int height = 800;

    // Size of Viking (rectangle).
    private int vikingW = 55;
    private int vikingH = 35;

    // Location of Viking.
    private int rectX = 100;
    private int rectY = 100;

    // Viking Movement Speed.
    private int velX = 0;
    private int velY = 0;


    // This refers to the actionListener.
    Timer timer = new Timer(5, this);

    // KeyListener.
    KeyListener listener;


    public GameWindow () {

         // KeyListener.
        listener = new KeyListener() {

            // Adding movement to the rectangle with key pressed.

            public void keyPressed(KeyEvent e) {

                int k = e.getKeyCode();

                if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) {
                    velX = -2;
                    velY = 0;
                // System.out.println("Does the LEFT key work?");
                }
                if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
                    velX = 0;
                    velY = -2;
                   //System.out.println("Does the UP key work?");
                }
                if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {
                    velX = 2;
                    velY = 0;
                   // System.out.println("Does the RIGHT key work?");
                }
                if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
                    velX = 0;
                    velY = 2;
                    //System.out.println("Does the DOWN key work?");
                }
            }


            public void keyTyped(KeyEvent e) {

            }

            // If key is released, the rect has to stop.
            public void keyReleased(KeyEvent e) {
                velX = 0;
                velY = 0;
                //System.out.println("Does it work?");
            }
        };
        timer.start();

        // Enable the keylistener.
        setFocusable(true);
        // Disabling the SHIFT and TAB Keys.
        setFocusTraversalKeysEnabled(true);


        //setRequestFocusEnabled(true);

        // This is for the KeyListener.

    }

    // PaintComponent used to make the animation.
    public void paintComponent(Graphics g){
        super.paintComponents(g);


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.RED);
        g.fillRect(rectX, rectY, vikingW, vikingH);

    }




    // Adding movement to the rectangle.
    public void actionPerformed(ActionEvent e){
        if (rectX < 0){
            velX = 0;
            rectX = 0;
        }
        if (rectX > (width - vikingW)){
            velX = 0;
            rectX = (width - vikingW);
        }
        if (rectY < 0){
            velY = 0;
            rectY = 0;
        }
        if (rectY > (height - vikingH  * 2 - 5)){
            velY = 0;
            rectY = (height - vikingH  * 2 - 5);
        }
       rectX = rectX + velX;
       rectY = rectY + velY;
        repaint();
    }



    public static void createWindow() {

        GameWindow gW = new GameWindow();
        // Craete the JFrame
        JFrame dodgeBallFrame = new JFrame("Viking Dodgeball");
        // Window size & size the frame.
        dodgeBallFrame.setPreferredSize(new Dimension(1200, 800));
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
        // KeyListener.
        dodgeBallFrame.addKeyListener(gW.listener);
        }

    public static void main(String [] args) {
        createWindow();


    }

}
