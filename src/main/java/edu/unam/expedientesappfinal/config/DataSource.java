package edu.unam.expedientesappfinal.config;

import edu.unam.expedientesappfinal.models.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DataSource {

  /**
   * Funcion para retornar el valor del tipo de persona
   *
   * @param name
   * @return String
   */
  public static TipoDePersona getByName(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }

    return TipoDePersona.valueOf(name.toUpperCase());
  }

  /**
   * Funcion para retornar un estado de un expediente
   *
   * @param name
   * @return String
   */
  public static Estado porNombre(String name) {
    if (name == null || name.isEmpty()) {
      return null;
    }
    return Estado.valueOf(name.toUpperCase());
  }

  public static Persona iniciante = // Persona
      new Persona(
          "roberto",
          "lopez",
          "45963123",
          "2954789963",
          "algunemail@hotmail.com",
              List.of("INICIANTE"),
          true);

  public static Persona involucrado =
      new Persona(
          "juan",
          "perez",
          "21456987",
          "3755987456",
          "hola@aou.com.ar",
          List.of("INVOLUCRADO"),
          false);

  public static Persona director =
      new Persona(
          "fernando",
          "ortiz",
          "36321654",
          "432059",
          "oti@yahoo.com.ar",
          List.of("DIRECTOR"),
          true);

  public static Expediente expedienteRoberto =
      new Expediente("empezo la fiesta", LocalDate.now(), null, porNombre("abierto"));

  public static AccionesRealizadas accion_1 =
      new AccionesRealizadas("se rompio todo", LocalDate.of(2023, Month.AUGUST, 23));

}
