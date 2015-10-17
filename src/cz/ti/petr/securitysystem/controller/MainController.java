package cz.ti.petr.securitysystem.controller;

import cz.ti.petr.securitysystem.model.control.ListCellFactorySecurityControl;
import cz.ti.petr.securitysystem.model.security.MySecurityManager;
import cz.ti.petr.securitysystem.model.security.control.factory.FactoryKeyboardSensor;
import cz.ti.petr.securitysystem.model.security.control.factory.FactoryMotionSensor;
import cz.ti.petr.securitysystem.model.security.control.factory.FactorySecurityControl;
import cz.ti.petr.securitysystem.model.security.control.factory.FactoryMagnetSensor;
import cz.ti.petr.securitysystem.model.service.Updater;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Kontroler hlavního view
 */
public class MainController implements Initializable {

    private static final Logger log = Logger.getLogger(MainController.class.getName());

    @FXML
    private ListView<FactorySecurityControl> listViewControls;

    @FXML
    private Pane paneContainer;

    private MySecurityManager sm = new MySecurityManager();
    private final Updater updater = new Updater(sm);

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listViewControls.setCellFactory(param -> new ListCellFactorySecurityControl());
        listViewControls.setItems(getViewControls());
        listViewControls.setOnMouseClicked(click -> {
            if (click.getClickCount() == 2) {
                FactorySecurityControl factory = listViewControls.getSelectionModel().getSelectedItem();
                if (factory == null)
                    return;

                sm.addControl(factory.createControl());
                paneContainer.getChildren().setAll(sm.getControls());
            }
        });

        updater.start();
    }

    private ObservableList<FactorySecurityControl> getViewControls() {
        ObservableList<FactorySecurityControl> controls = FXCollections.observableArrayList();

        controls.add(new FactoryKeyboardSensor());
        controls.add(new FactoryMotionSensor());
        controls.add(new FactoryMagnetSensor());


        return controls;
    }
}
