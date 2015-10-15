package cz.ti.petr.securitysystem.model.security;

import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import org.apache.log4j.Logger;

/**
 * Třída představující správce bezpečnostních zařízení
 */
public class MySecurityManager {

    private static final Logger log = Logger.getLogger(MySecurityManager.class.getName());

    private final ObservableList<SecurityControl> controls = FXCollections.observableArrayList();

    /**
     * Připojí kontrolku do systému
     *
     * @param control Reference na kontrolku
     */
    public void addControl(SecurityControl control) {
        controls.add(control);

        log.debug("Pridavam kontrolku do spravy..." + controls.size());
    }

    /**
     * @return Vrátí referenci na list se všema kontrolkama
     */
    public ObservableList<SecurityControl> getControls() {
        return controls;
    }


}
