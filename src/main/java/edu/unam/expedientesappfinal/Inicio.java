package edu.unam.expedientesappfinal;

import edu.unam.expedientesappfinal.config.ConexionDB;
import edu.unam.expedientesappfinal.modelos.Persona;
import edu.unam.expedientesappfinal.modelos.TipoDePersona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Inicio extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Inicio.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();

    Persona iniciante = // Persona
            new Persona(
                    1L,
                    "roberto",
                    "lopez",
                    "45963123",
                    "2954789963",
                    "algunemail@hotmail.com",
                    TipoDePersona.INICIANTE.getValor());

    Persona involucrado = // Persona
            new Persona(
                    2L,
                    "martin",
                    "melo",
                    "50123654",
                    "2958456987",
                    "superman@yahoo.com.ar",
                    TipoDePersona.INVOLUCRADO.getValor());

    EntityManager em = ConexionDB.getEntityManager();

    em.getTransaction().begin();

    var per = em.merge(iniciante);
    var per2 = em.merge(involucrado);

    em.persist(per);
    em.persist(per2);

    em.getTransaction().commit();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Persona> consulta = cb.createQuery(Persona.class);
    Root<Persona> origen = consulta.from(Persona.class);
    List<Persona> personas = em.createQuery(consulta.select(origen)).getResultList();
    personas.forEach(System.out::println);
  }
}
