package cz.ti.petr.securitysystem.model.security.control;


/**
 * Třída představující pohybové čislo
 */
public class MotionSensor extends SecurityControl {

    private static final String NAME = "MotionSensor_";
    private static int controlCounter = 0;
    private static final int DELAY = 5;

    private int counter = 0;
    private boolean detected = false;

    /**
     * Vytvoří novou instanci pohybového sensoru
     */
    public MotionSensor() {
        super(NAME + controlCounter++);
        this.setState(true);
    }

    @Override
    public void handleButton() {
        detected = !detected;
    }


    @Override
    public void update() {

        if (detected) {

            System.out.println("POHYB na pohybovém senzoru: " + name + ", po dobu: " + counter);

            if (counter == DELAY) {
                setState(false);
            }

            counter++;
        } else {
            counter = 0;

            setState(true);
        }
    }
}
