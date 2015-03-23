/**
 * Created by Steffen on 20-03-2015.
 */
public class Viking extends Entity {

    private int healthPool;
    private double speed;
    private  double xPosition;
    private double yPosition;
    private boolean canAttack;
    private double facing;


    public void pickUp(Object obj){

    }

    public void move(double obj){

    }

    public void throwAxe(){

    }

    public void update(double deltaT){

    }

    public void onHit(){

    }

    private boolean CheckHealth(int health){
        // Hvad skal health == ?
        if (health == 1) {
            return true;
        }
        return false;

    }

}
