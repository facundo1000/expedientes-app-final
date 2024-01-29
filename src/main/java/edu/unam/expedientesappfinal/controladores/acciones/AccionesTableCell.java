package edu.unam.expedientesappfinal.controladores.acciones;

import edu.unam.expedientesappfinal.modelos.AccionesRealizadas;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class AccionesTableCell extends TableCell<AccionesRealizadas, Void> {

    private final Button accionButton;
    private final Button deleteButton;

    public AccionesTableCell() {
        this.accionButton = new Button("Editar");
        this.accionButton.setOnAction(event -> {
            // Lógica para realizar la acción deseada para esta fila
            // Puedes acceder a los datos de la fila con getTableView().getItems().get(getIndex())
        });
        this.deleteButton = new Button("Eliminar");
        this.deleteButton.setOnAction(actionEvent -> {
            // Lógica para realizar la acción deseada para esta fila
            // Puedes acceder a los datos de la fila con getTableView().getItems().get(getIndex())
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(accionButton);
            setGraphic(deleteButton);
        }
    }

    public static <T> Callback<TableColumn<T, Void>, TableCell<T, Void>> forTableColumn() {
        return param -> (TableCell<T, Void>) new AccionesTableCell();
    }
}
