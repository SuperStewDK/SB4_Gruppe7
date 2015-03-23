import javax.swing.JFrame;
import java.awt.*;

/**
 * Created by Steffen on 20-03-2015.
 */
public class GameWindow extends JFrame{

    int width = 806;
    int height = 628;

    public GameWindow(){
        add(new Map());

        setSize(width, height);
        setTitle("Viking DodgeBall: Fighting for Valhalla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow ex = new GameWindow();
                ex.setVisible(true);
            }
        });
    }
}
