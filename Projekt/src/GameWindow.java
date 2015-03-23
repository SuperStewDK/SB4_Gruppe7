import com.sun.prism.*;
import org.jbox2d.dynamics.World;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Steffen on 20-03-2015.
 */
public class GameWindow extends JFrame {

    int width = 1000;
    int height = 722;


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow gameWindow = new GameWindow();
                gameWindow.setVisible(true);
            }
        });

    }

    public GameWindow(){

        launch();

    }
    public void launch(){

        add(new Map());

        setSize(width, height);

        setTitle("Viking Dodgeball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
}
