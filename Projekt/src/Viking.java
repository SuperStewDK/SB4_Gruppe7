import java.util.Objects;

/**
 * Created by Steffen on 20-03-2015.
 */
public class Viking implements IEntity {
    private int healthPool;
    private double speed;
    private double xPosition;
    private double yPosition;
    private boolean canAttack;
    private double facing;

    public void pickUp(Object obj) {

    }

    public void move(double deltaT) {

    }

    public void throwAxe() {

    }

    public void update(double deltaT) {

    }

    public void onHit() {

    }

    private boolean checkHealth(int health) {
        return false;
    }

}
