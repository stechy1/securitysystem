package cz.ti.petr.securitysystem.model.security;

import cz.ti.petr.securitysystem.model.IUpdatable;
import cz.ti.petr.securitysystem.model.security.control.SecurityControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import org.apache.log4j.Logger;

import java.util.stream.Collectors;

/**
 * Třída představující správce bezpečnostních zařízení
 */
public class MySecurityManager implements IUpdatable{

    private static final Logger log = Logger.getLogger(MySecurityManager.class.getName());

    private final ObservableList<SecurityControl> controls = FXCollections.observableArrayList();

    private boolean armed = false;

    /**
     * Připojí kontrolku do systému
     *
     * @param control Reference na kontrolku
     */
    public void addControl(SecurityControl control) {
        controls.add(control);

        log.debug("Pridavam kontrolku do spravy...");
    }

    /**
     * @return Vrátí referenci na list se všema kontrolkama
     */
    public ObservableList<Node> getControls() {
        ObservableList<Node> nodes = FXCollections.observableArrayList();
        controls.stream().forEach(control -> nodes.add(control.getContainer()));

        return nodes;
    }

    /**
     * Metoda aktualizující stavy v jednotlivých komponentách
     */
    @Override
    public void update() {

        controls.forEach(SecurityControl::update);
    }
}
