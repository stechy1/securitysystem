package cz.ti.petr.securitysystem.model.security.control;

import javafx.scene.canvas.GraphicsContext;

/**
 * Třída představující klávesnici
 */
public class KeyboardSensor extends SecurityControl {

    private static final String NAME = "Klávesnice_";
    private static int counter = 0;

    public KeyboardSensor() {
        super(NAME + counter++);
    }


    @Override
    public void handleButton() {

    }
}
