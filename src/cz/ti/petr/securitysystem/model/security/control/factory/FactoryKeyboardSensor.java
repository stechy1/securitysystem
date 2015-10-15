package cz.ti.petr.securitysystem.model.security.control.factory;

import cz.ti.petr.securitysystem.model.security.control.KeyboardSensor;
import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import javafx.scene.image.Image;

/**
 * Továrna na výrobu klávesových senzorů
 */
public class FactoryKeyboardSensor extends FactorySecurityControl {

    private static final Image IMG = new Image(ClassLoader.getSystemResourceAsStream("resources/icon/48/keyboard.png"));
    private static final String NAME = "Klávesnice";

    /**
     * Konstruktor továrny na výrobu bezpečnostních prvků
     *
     */
    public FactoryKeyboardSensor() {
        super(IMG, NAME);
    }

    @Override
    public SecurityControl createControl() {
        return new KeyboardSensor();
    }
}
