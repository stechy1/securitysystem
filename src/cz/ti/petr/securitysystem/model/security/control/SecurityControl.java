package cz.ti.petr.securitysystem.model.security.control;

import cz.ti.petr.securitysystem.model.IRenderable;
import cz.ti.petr.securitysystem.model.IUpdatable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Třída představující všechny bezpečnostní prvky
 */
public abstract class SecurityControl extends Button {

    private final Delta delta = new Delta();
    public final String name;

    public SecurityControl(String name) {
        this.name = name;

        setText(name);
        setMovement();
    }

    private void setMovement() {
        setOnMousePressed(event -> {
            delta.x = getLayoutX() - event.getSceneX();
            delta.y = getLayoutY() - event.getSceneY();
            setCursor(Cursor.MOVE);
        });

        setOnMouseReleased(event -> setCursor(Cursor.HAND));

        setOnMouseDragged(event -> {
            setLayoutX(event.getSceneX() + delta.x);
            setLayoutY(event.getSceneY() + delta.y);
        });

        setOnMouseEntered(event -> setCursor(Cursor.HAND));

        setOnMouseClicked(event -> handleButton());
    }

    public abstract void handleButton();

    private static class Delta{double x, y;}
}
