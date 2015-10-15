package cz.ti.petr.securitysystem.model.security.control.factory;

import cz.ti.petr.securitysystem.model.security.control.MotionSensor;
import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import javafx.scene.image.Image;

/**
 * Třída představující továrnu na výrobu detektorů pohybu
 */
public class FactoryMotionSensor extends FactorySecurityControl {

    private static final Image IMG = new Image(ClassLoader.getSystemResourceAsStream("resources/icon/48/motion_sensor.png"));
    private static final String NAME = "Pohybový senzor";

    /**
     * Konstruktor továrny na výrobu bezpečnostních prvků
     *
     */
    public FactoryMotionSensor() {
        super(IMG, NAME);
    }

    @Override
    public SecurityControl createControl() {
        return new MotionSensor();
    }
}
