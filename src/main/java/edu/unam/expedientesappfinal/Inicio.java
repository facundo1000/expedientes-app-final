package edu.unam.expedientesappfinal;

import edu.unam.expedientesappfinal.servicios.PersonaServicio;
import java.io.IOException;
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
    //    launch();

    PersonaServicio servicio = new PersonaServicio();
    System.out.println();

    servicio.listar().forEach(System.out::println);
  }
}
