package cz.ti.petr.securitysystem.model.security.control;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Třída představující klávesnici
 */
public class KeyboardSensor extends SecurityControl {

    private static final String NAME = "Klávesnice_";
    private static int controlCounter = 0;

    private TextField codeField = new TextField();
    private Button codeButton = new Button("Zakodovat");
    private Button decodeButton = new Button("Odkodovat");
    private VBox keyContainer = new VBox(codeField, codeButton, decodeButton);

    private boolean keyboardVisible = false;

    public KeyboardSensor() {
        super(NAME + controlCounter++);

        addControl(keyContainer);
        keyContainer.setOpacity(0.0);
        setHandlers();
    }

    private void setHandlers() {
        codeButton.setOnAction(event -> {

        });

        decodeButton.setOnAction(event -> {

        });
    }


    @Override
    public void handleButton() {
        final DoubleProperty opacity = keyContainer.opacityProperty();
        Timeline fade;
        if (keyboardVisible) {
            fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(500), new KeyValue(opacity, 0.0))
            );
        } else {
            fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0))
                    );
        }

        fade.play();
        keyboardVisible = !keyboardVisible;

    }

    @Override
    public void update() {

    }
}
