package cz.ti.petr.securitysystem.model.security.control;


/**
 * Třída představující pohybové čislo
 */
public class MotionSensor extends SecurityControl {

    private static final String NAME = "MotionSensor_";
    private static int counter = 0;

    /**
     * Vytvoří novou instanci pohybového sensoru
     */
    public MotionSensor() {
        super(NAME + counter++);
    }

    @Override
    public void handleButton() {

    }
}
