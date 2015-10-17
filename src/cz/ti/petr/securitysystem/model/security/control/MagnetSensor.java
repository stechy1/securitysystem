package cz.ti.petr.securitysystem.model.security.control;


/**
 * Třída představující čidlo na okně
 */
public class MagnetSensor extends SecurityControl {

    private static final String NAME = "Magnetický senzor_";
    private static int controlCounter = 0;

    /**
     * Vytvoří novou instanci snímače na okno/dveře
     */
    public MagnetSensor() {
        super(NAME + controlCounter++);
        this.setState(true);
    }


    @Override
    public void handleButton() {
        if (state.getValue()) {
            setState(false);
        } else {
            setState(true);
        }
    }

}
