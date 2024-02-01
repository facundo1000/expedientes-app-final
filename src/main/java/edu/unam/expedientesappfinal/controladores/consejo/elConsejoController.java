package edu.unam.expedientesappfinal.controladores.consejo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;

public class elConsejoController {

    @FXML
    private ListView<?> ListaMiembrosActuales;

    @FXML
    private ScrollBar barraLateralDesplazamiento;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnMenuConsejo;

    @FXML
    private Button btnMenuExpedientes;

    @FXML
    private Button btnMenuMinutas;

    @FXML
    private Button btnMenuPersonas;

    @FXML
    private Button btnMenuReuniones;

    @FXML
    private ComboBox<?> desplegableMiembrosCandidatos;

}
