package edu.unam.expedientesappfinal.controladores.personas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EditarPersonasController {

    @FXML
    private Button btnLimpiarCampos;

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
    private Button btnRegistrar;

    @FXML
    private ComboBox<?> comboBoxTipoDoc;

    @FXML
    private DatePicker datepickerFechaNac;

    @FXML
    private TextField inputApellidos;

    @FXML
    private TextField inputCorreoElectronico;

    @FXML
    private TextField inputNombres;

    @FXML
    private TextField inputNroDoc;

    @FXML
    private RadioButton radioDirector;

    @FXML
    private RadioButton radioDocente;

    @FXML
    private RadioButton radioEstudiante;

    @FXML
    private RadioButton radioMiembro;

    @FXML
    private RadioButton radioNoDocente;

}
