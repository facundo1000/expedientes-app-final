package edu.unam.expedientesappfinal.controladores;

import edu.unam.expedientesappfinal.config.ConexionDB;
import edu.unam.expedientesappfinal.models.Persona;
import edu.unam.expedientesappfinal.service.impl.PersonasRepositorioImpl;
import jakarta.persistence.EntityManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private Button addPersonaBtnAgregar;

    @FXML
    private Button addPersonaBtnUpdate;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaApellido;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaAsistencia;

    @FXML
    private Button addPersonaColPersonaDelete;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaDni;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaEmail;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaId;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaNombre;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTelefono;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTipo;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTipoDni;

    @FXML
    private AnchorPane addPersonasForm;

    @FXML
    private TableView<Persona> addPersonasTableView;

    @FXML
    private Button btnAddAccion;

    @FXML
    private Button btnAddExpediente;

    @FXML
    private Button btnAddOrdenDelDia;

    @FXML
    private Button btnAddPersona;

    @FXML
    private Button btnAddReunion;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMiembros;

    @FXML
    private AnchorPane greetUser;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaBday;

    private PersonasRepositorioImpl repo;

    private EntityManager connection;

    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    public ObservableList<Persona> addPersonaGetData() {
        ObservableList<Persona> listData = FXCollections.observableArrayList();

        try {
            connection = ConexionDB.getEntityManager();
            repo = new PersonasRepositorioImpl(connection);
            List<Persona> personas = repo.listar();
            listData.addAll(personas);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null && connection.isOpen()) {
                connection.close();
            }
        }
        return listData;
    }

    private ObservableList<Persona> addPersonaListData;

    public void addStudentDisplayData() {
        addPersonaListData = addPersonaGetData();
        addPersonaColPersonaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        addPersonaColPersonaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        addPersonaColPersonaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        addPersonaColPersonaTipoDni.setCellValueFactory(new PropertyValueFactory<>("tipoDoc"));
        addPersonaColPersonaDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        addPersonaColPersonaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        addPersonaColPersonaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        addPersonaColPersonaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoDePersona"));
        addPersonaColPersonaBday.setCellValueFactory(new PropertyValueFactory<>("bday"));


        addPersonasTableView.setItems(addPersonaListData);
    }

    public void addPersonaBtn() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CrearPersonas.fxml")));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addStudentDisplayData();
    }
}
