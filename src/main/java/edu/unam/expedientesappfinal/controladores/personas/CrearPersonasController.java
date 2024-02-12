package edu.unam.expedientesappfinal.controladores.personas;

import edu.unam.expedientesappfinal.config.ConexionDB;
import edu.unam.expedientesappfinal.models.Persona;
import edu.unam.expedientesappfinal.models.TipoDeDocumento;
import edu.unam.expedientesappfinal.service.impl.PersonasRepositorioImpl;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CrearPersonasController implements Initializable {

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<String> comboBoxTipoDoc;

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
    private CheckBox chkDirector;

    @FXML
    private CheckBox chkDocente;

    @FXML
    private CheckBox chkEstudiante;

    @FXML
    private CheckBox chkMiembro;

    @FXML
    private CheckBox chkNoDocente;

    @FXML
    private TextField inputTelefono;

    private PersonasRepositorioImpl repo;

    private EntityManager em;

    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public void addPersona() {
        if (comboBoxTipoDoc.getSelectionModel().getSelectedItem().isEmpty()
                || inputApellidos.getText().isEmpty()
                || inputCorreoElectronico.getText().isEmpty()
                || inputNombres.getText().isEmpty()
                || inputNroDoc.getText().isEmpty()) {

            alert.setContentText("Por favor complete los campos vacios");
        } else {
            em = ConexionDB.getEntityManager();
            repo = new PersonasRepositorioImpl(em);
            repo.crear(new Persona(inputNombres.getText(),inputApellidos.getText(),inputNroDoc.getText(),inputTelefono.getText(),inputCorreoElectronico.getText(),null,true));
        }
    }

    public void tipoDniList() {

        List<String> list = new ArrayList<>();

        for (TipoDeDocumento data : TipoDeDocumento.values()) {
            list.add(data.getNombre());
        }
        ObservableList<String> ls = FXCollections.observableArrayList(list);
        comboBoxTipoDoc.setItems(ls);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoDniList();
    }
}
