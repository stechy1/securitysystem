package cz.ti.petr.securitysystem;

import cz.ti.petr.securitysystem.model.service.Updater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.net.URL;

/**
 * Vrtupní třída aplikace
 */
public class App extends Application {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static final URL PATH_TO_LOG4J_PROPERTIES = ClassLoader.getSystemResource("resources/config/log4j.properties");


    public static void main(String[] args) {
        PropertyConfigurator.configure(PATH_TO_LOG4J_PROPERTIES);

        log.info("Spouštím grafického klienta bezpečnostního systému...");
        launch(args);
    }


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent p =  FXMLLoader.load(ClassLoader.getSystemResource("resources/fxml/main.fxml"));
        Scene scene = new Scene(p);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Bezpečnostní systém domu");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    /**
     * This method is called when the application should stop, and provides a
     * convenient place to prepare for application exit and destroy resources.
     * <p>
     * <p>
     * The implementation of this method provided by the Application class does nothing.
     * </p>
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     */
    @Override
    public void stop() throws Exception {
        Updater.stopAll();
        super.stop();
    }
}
