package cz.ti.petr.securitysystem.model.security.control;


/**
 * Třída představující čidlo na okně
 */
public class WindowSensor extends SecurityControl {

    private static final String NAME = "WindowSensor_";
    private static int counter = 0;

    /**
     * Vytvoří novou instanci snímače na okno/dveře
     */
    public WindowSensor() {
        super(NAME + counter++);
    }


    @Override
    public void handleButton() {

    }
}
