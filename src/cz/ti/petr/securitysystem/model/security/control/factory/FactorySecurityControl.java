package cz.ti.petr.securitysystem.model.security.control.factory;

import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import javafx.scene.image.Image;

/**
 * Abstraktní třída pro továrny bezpečnostních kontrolek
 */
public abstract class FactorySecurityControl {

    public final Image img;
    public final String name;

    /**
     * Konstruktor továrny na výrobu bezpečnostních prvků
     *
     * @param img Reference na obrázek
     * @param name Název továrny
     */
    public FactorySecurityControl(Image img, String name) {
        this.img = img;
        this.name = name;
    }

    public abstract SecurityControl createControl();
}
