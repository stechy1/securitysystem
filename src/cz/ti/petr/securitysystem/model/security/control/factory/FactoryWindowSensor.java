package cz.ti.petr.securitysystem.model.security.control.factory;

import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import cz.ti.petr.securitysystem.model.security.control.WindowSensor;
import javafx.scene.image.Image;

/**
 * Třída představující továrnu na čidla
 */
public class FactoryWindowSensor extends FactorySecurityControl {

    private static final Image IMG = new Image(ClassLoader.getSystemResourceAsStream("resources/icon/window_sensor.jpg"));
    private static final String NAME = "Čidlo na okno/dveře";

    /**
     * Konstruktor továrny na výrobu bezpečnostních prvků
     */
    public FactoryWindowSensor() {
        super(IMG, NAME);
    }

    @Override
    public SecurityControl createControl() {
        return new WindowSensor();
    }
}
