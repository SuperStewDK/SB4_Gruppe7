import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


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

    // int cx = getSize().width / 2;
    //int cy = getSize().height / 2;


    // This refers to the actionListener.
    Timer timer = new Timer(5, this);

    // KeyListener.
    KeyListener listener;



    public GameWindow () {

        super();
        //image = Toolkit.getDefaultToolkit().getImage("/images/TestIcon.ico");

         // KeyListener.
        listener = new KeyListener() {

            // Adding movement to the rectangle with key pressed.
            public void keyPressed(KeyEvent e) {

                int k = e.getKeyCode();

                if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT) {
                    velX = -2;
                    velY = 0;
                }
                if (k == KeyEvent.VK_W || k == KeyEvent.VK_UP) {
                    velX = 0;
                    velY = -2;
                }
                if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT) {
                    velX = 2;
                    velY = 0;
                }
                if (k == KeyEvent.VK_S || k == KeyEvent.VK_DOWN) {
                    velX = 0;
                    velY = 2;
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



        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, width, height);


        // Create Rectangle + Color
        g.setColor(Color.RED);
        g.fillRect(rectX, rectY, vikingW, vikingH);

        // Load image for viking + drawing it at x & y pos
        Image vikingImage = new ImageIcon("Images/minion.png").getImage();
        g.drawImage(vikingImage, rectX +20, rectY+20, this);
        Image bgImage = new ImageIcon("Images/PequeoPlayground-TopDownView.jpg").getImage();
        g.drawImage(bgImage, 0, 0, this);
        repaint();
        //rotate about 0, 0
        //Graphics2D graphics2D = (Graphics2D)g.create();
        //Graphics2D graphics2D = (Graphics2D)g;
        //graphics2D.rotate(Math.toRadians(45));
        //graphics2D.setColor(Color.red);
        //graphics2D.translate(170, 0);
        //graphics2D.rotate(1);
        //graphics2D.fillRect(rectX, rectY, vikingW, vikingH);

        //graphics2D.drawImage(this.image, 50, 50, 200, 200, this);

        //g.drawImage(image, -cx / 2, -cy / 2, this);
        //rotate about 100, 100
        //graphics2D = (Graphics2D)g.create();
        //graphics2D.rotate(Math.toRadians(45), 100, 100);
        //graphics2D.setColor(Color.blue);
       // graphics2D.fillRect(rectX, rectY, vikingW, vikingH);


        //dispose Graphics2D object
        //graphics2D.dispose();

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
