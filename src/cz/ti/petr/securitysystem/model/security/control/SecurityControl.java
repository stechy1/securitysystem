package cz.ti.petr.securitysystem.model.security.control;

import cz.ti.petr.securitysystem.model.IState;
import cz.ti.petr.securitysystem.model.IUpdatable;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Třída představující všechny bezpečnostní prvky
 */
public abstract class SecurityControl implements IUpdatable, IState {

    private static final String FXML_FILE = "resources/fxml/securityControl.fxml";

    private final Delta delta = new Delta();
    public final String name;

    protected final ObjectProperty<Boolean> state = new SimpleObjectProperty<>();

    @FXML
    private VBox container;
    @FXML
    private Button movementButton;
    @FXML
    private Button actionButton;

    public SecurityControl(String name) {
        this.name = name;

        try {
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(FXML_FILE));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        state.addListener((observable, oldValue, newValue) -> {
            final String style;
            if (newValue)
                style = "-fx-background-color: green;";
            else
                style = "-fx-background-color: red;";

            Platform.runLater(() -> container.setStyle(style));
        });

        actionButton.setText(name);
        setMovement();
    }

    private void setMovement() {
        movementButton.setOnMousePressed(event -> {
            delta.x = container.getLayoutX() - event.getSceneX();
            delta.y = container.getLayoutY() - event.getSceneY();
            movementButton.setCursor(Cursor.MOVE);
        });

        movementButton.setOnMouseReleased(event -> movementButton.setCursor(Cursor.HAND));

        movementButton.setOnMouseDragged(event -> {
            container.setLayoutX(event.getSceneX() + delta.x);
            container.setLayoutY(event.getSceneY() + delta.y);
        });

        movementButton.setOnMouseEntered(event -> movementButton.setCursor(Cursor.HAND));

        actionButton.setOnMouseClicked(event -> handleButton());
    }

    public abstract void handleButton();

    public Node getContainer() {
        return container;
    }

    private static class Delta{double x, y;}

    protected void addControl(Node node) {
        container.getChildren().add(node);
    }

    @Override
    public void setState(boolean state) {
        this.state.setValue(state);
    }

    @Override
    public boolean getState() {
        return state.get();
    }

    @Override
    public void update() {
    }
}
