/**
 * Created by Steffen on 20-03-2015.
 */
public class Entity {
    public double speed;
    public double xPosition;
    public double yPosition;
    public boolean canAttack;
    public double facing;


    public double getxPosition() {
        return xPosition;
    }


    public void update(double deltaT){
        yPosition = yPosition + speed * deltaT;

    }

    public double getyPosition() {
        return yPosition;
    }
}
