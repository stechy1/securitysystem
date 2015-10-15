package cz.ti.petr.securitysystem.model.control;

import cz.ti.petr.securitysystem.model.security.control.factory.FactorySecurityControl;
import javafx.scene.Cursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

/**
 * Třída představující jednu buňku v listView
 */
public class ListCellFactorySecurityControl extends ListCell<FactorySecurityControl> {

    private static final Logger log = Logger.getLogger(ListCellFactorySecurityControl.class.getName());

    private HBox container;

    public ListCellFactorySecurityControl() {

        /*// Cursor Display for Drag&Drop
        setOnMouseEntered(e -> setCursor(Cursor.OPEN_HAND));
        setOnMousePressed(e -> setCursor(Cursor.CLOSED_HAND));
        setOnMouseReleased(e -> setCursor(Cursor.DEFAULT));

        // Manage drag
        setOnDragDetected(event -> {
            *//* drag was detected, start a drag-and-drop gesture*//*
            Dragboard db = startDragAndDrop(TransferMode.MOVE);

            // Visual during drag
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            snapshotParameters.setFill(Color.TRANSPARENT);
            db.setDragView(snapshot(snapshotParameters, null));

            *//* Put a string on a dragboard *//*
            ClipboardContent content = new ClipboardContent();
            content.putString(getItem().name);
            db.setContent(content);

            event.consume();
        });*/


        /*setOnDragDetected(event -> {
            if (getItem() == null)
                return;

            Dragboard dragboard = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(getItem().name);
            dragboard.setContent(content);

            log.debug("OnDragDetected");
            event.consume();
        });

        setOnMousePressed(event -> {
            if (container == null) {
                event.consume();
                return;
            }

            setCursor(Cursor.CLOSED_HAND);
            container.setMouseTransparent(true);
            setMouseTransparent(true);

            log.debug("OnMousePressed");
        });

        setOnMouseEntered(event -> {

            setCursor(Cursor.HAND);

            log.debug("OnMouseEntered");
        });

        setOnMouseReleased(event -> {
            if (container == null) {
                event.consume();
                return;
            }

            setCursor(Cursor.DEFAULT);
            container.setMouseTransparent(false);
            setMouseTransparent(false);

            log.debug("OnMouseReleased");
        });*/

        /*setOnDragDetected(event -> {
            if (getItem() == null)
                return;

            Dragboard dragboard = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(getItem().name);
            dragboard.setContent(content);

            log.debug("OnDragDetected");
            event.consume();
        });

        setOnDragOver(event -> {
            if (event.getGestureSource() != this &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }

            log.debug("OnDragOver");
            event.consume();
        });

        setOnDragEntered(event -> {
            if (event.getGestureSource() != this &&
                    event.getDragboard().hasString()) {
                setOpacity(0.3);
            }

            log.debug("OnDragEntered");
        });

        setOnDragExited(event -> {
            if (event.getGestureSource() != this &&
                    event.getDragboard().hasString()) {
                setOpacity(1);
            }

            log.debug("OnDragExited");
            event.consume();
        });

        setOnDragDropped(DragEvent::consume);
        setOnDragDone(DragEvent::consume);*/
    }

    private void createContainer(FactorySecurityControl item) {
        ImageView img = new ImageView(item.img);
        Label label = new Label(item.name);

        container = new HBox(10.0, img, label);
    }

    /**
     * The updateItem method should not be called by developers, but it is the
     * best method for developers to override to allow for them to customise the
     * visuals of the cell. To clarify, developers should never call this method
     * in their code (they should leave it up to the UI control, such as the
     * {@link ListView} control) to call this method. However,
     * the purpose of having the updateItem method is so that developers, when
     * specifying custom cell factories (again, like the ListView
     * {@link ListView#cellFactoryProperty() cell factory}),
     * the updateItem method can be overridden to allow for complete customisation
     * of the cell.
     * <p>
     * <p>It is <strong>very important</strong> that subclasses
     * of Cell override the updateItem method properly, as failure to do so will
     * lead to issues such as blank cells or cells with unexpected content
     * appearing within them. Here is an example of how to properly override the
     * updateItem method:
     * <p>
     * <pre>
     * protected void updateItem(T item, boolean empty) {
     *     super.updateItem(item, empty);
     *
     *     if (empty || item == null) {
     *         setText(null);
     *         setGraphic(null);
     *     } else {
     *         setText(item.toString());
     *     }
     * }
     * </pre>
     * <p>
     * <p>Note in this code sample two important points:
     * <ol>
     * <li>We call the super.updateItem(T, boolean) method. If this is not
     * done, the item and empty properties are not correctly set, and you are
     * likely to end up with graphical issues.</li>
     * <li>We test for the <code>empty</code> condition, and if true, we
     * set the text and graphic properties to null. If we do not do this,
     * it is almost guaranteed that end users will see graphical artifacts
     * in cells unexpectedly.</li>
     * </ol>
     *
     * @param item  The new item for the cell.
     * @param empty whether or not this cell represents data from the list. If it
     *              is empty, then it does not represent any domain data, but is a cell
     *              being used to render an "empty" row.
     * @expert
     */
    @Override
    protected void updateItem(FactorySecurityControl item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty)
            setGraphic(null);
        else {
            if (container == null) createContainer(item);
            setGraphic(container);
        }
    }
}
