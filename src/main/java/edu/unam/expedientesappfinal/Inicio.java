package edu.unam.expedientesappfinal;

import static edu.unam.expedientesappfinal.config.DataSource.*;

import edu.unam.expedientesappfinal.config.ConexionDB;
import edu.unam.expedientesappfinal.models.*;
import edu.unam.expedientesappfinal.service.Repositorio;
import edu.unam.expedientesappfinal.service.impl.AccionesRepositorioImpl;
import edu.unam.expedientesappfinal.service.impl.ExpedienteRepositorioImpl;
import edu.unam.expedientesappfinal.service.impl.PersonasRepositorioImpl;
import jakarta.persistence.EntityManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Inicio extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inicio.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        EntityManager conn = ConexionDB.getEntityManager();
        Repositorio<Persona> repo = new PersonasRepositorioImpl(conn); // Repositorio-Personas
        ExpedienteRepositorioImpl expeRepo = new ExpedienteRepositorioImpl(conn); // Repositorio-Expedientes
        Repositorio<AccionesRealizadas> accRepo = new AccionesRepositorioImpl(conn); // Repositorio acciones

        var consejo = new ConsejoDepartamental();

        repo.crear(director); // Se crea un director
        repo.crear(iniciante); // Se crea un iniciante
        repo.crear(involucrado); // Se crea un involucrado

        consejo.addMiembro(director);
        expedienteRoberto.setIniciante(iniciante); // se coloca un iniciante del expediente
        expedienteRoberto.addInvolucrado(involucrado);
        expedienteRoberto.addAccion(accion_1);
        expedienteRoberto.addAccion(new AccionesRealizadas("nada nada menos nada", LocalDate.now()));
        expeRepo.crear(expedienteRoberto); // se crea un expediente


        // Visualizacion del servicio persona
        System.out.println("--------------------Lista de Personas---------------");
        repo.listar().forEach(System.out::println);
        System.out.println("-----------Persona Buscada--------------");
        System.out.println(repo.obtenerPorId(2L));
        System.out.println("---------------------Persona Actualizada de id N°2----------------");

        Persona update =
                new Persona(
                        "jorge",
                        "martinez",
                        "39639845",
                        "432053",
                        "email@hotmail.com",
                        List.of("MIEMBRO","INVOLUCRADO"),
                        false);
        System.out.println(update);
        System.out.println("-------------------------------------");
        repo.actualizar(2L, update); // se actualiza la persona con id 2

        repo.listar().forEach(System.out::println);
        System.out.println("-----------Eliminar Persona--------------");
        repo.eliminar(1L); // se elimina la persona con ID 1
        repo.listar().forEach(System.out::println);
        expeRepo.listar().forEach(System.out::println); // se listan todos los expedientes
        System.out.println();
        Expediente porId = expeRepo.obtenerPorId(1L);
        porId.setIniciante(null);
        porId.removeInvolucrados();

        // EXPEDIENTES ------------------------------------------------------------
        System.out.println("---------------Listado de Expedientes-------------------");
        expeRepo.listar().forEach(System.out::println); // se listan todos los expedientes
        System.out.println("-----------Expendiente Buscado--------------");
        System.out.println();
        System.out.println(expeRepo.obtenerPorId(2L));
        System.out.println("-----------Expendiente Actualizado--------------");
        System.out.println();
        expeRepo.actualizar(1L, new Expediente("actualizado", null, iniciante, Estado.ABIERTO));
        expeRepo.listar().forEach(System.out::println); // se listan todos los expedientes
        System.out.println("-----------Expendiente eliminado--------------");
        expeRepo.eliminar(2L);
        expeRepo.listar().forEach(System.out::println); // se listan todos los expedientes
        System.out.println();
        System.out.println();
        System.out.println("---------------Listado de Acciones_Realizadas-------------------");
        accRepo.listar().forEach(System.out::println);
        System.out.println("-----------Accion Buscada--------------");
        System.out.println();
        System.out.println(accRepo.obtenerPorId(1L));
        System.out.println("-----------Accion Actualizada--------------");
        System.out.println();
        accRepo.actualizar(1L, new AccionesRealizadas("actualizacion", LocalDate.now()));
        accRepo.listar().forEach(System.out::println);
        System.out.println("-----------Accion eliminada--------------");
        accRepo.eliminar(1L);
        accRepo.listar().forEach(System.out::println);
        expeRepo.listar().forEach(System.out::println); // se listan todos los expedientes

    }
}
