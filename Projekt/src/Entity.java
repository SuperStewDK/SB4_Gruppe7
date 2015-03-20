/**
 * Created by Steffen on 20-03-2015.
 */
public interface Entity {
    double speed = 0;
    double xPosition = 0;
    double yPosition = 0;
    boolean canAttack = false;
    double facing = 0;

    public void onHit();

    public void update(double deltaT);

    public void move(double deltaT);

}
