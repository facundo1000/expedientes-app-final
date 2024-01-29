package edu.unam.expedientesappfinal.controladores.acciones;

import edu.unam.expedientesappfinal.modelos.AccionesRealizadas;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AccionesRealizadasController {
    @FXML
    private Button accButton;

    @FXML
    private DatePicker accDate;

    @FXML
    private TableView<AccionesRealizadas> accTable;

    @FXML
    private MenuButton accSelectExpedientes;

    @FXML
    private TextArea accTxtArea;

    @FXML
    private TextField accTxtFieldActionID;

    @FXML
    private void initialize() {
        // Aquí inicializas tu TableView y sus datos...
        // Asigna la celda personalizada a la columna de Acciones
        TableColumn<AccionesRealizadas, Void> accionesColumn = (TableColumn<AccionesRealizadas, Void>) accTable.getColumns().get(4); // Índice de la columna de Acciones
        accionesColumn.setCellFactory(AccionesTableCell.forTableColumn());
    }

}
