package edu.unam.expedientesappfinal.config;

import edu.unam.expedientesappfinal.modelos.Persona;
import edu.unam.expedientesappfinal.modelos.TipoDePersona;

public class DataSource {
  public static Persona iniciante = // Persona
      new Persona(
          1L,
          "roberto",
          "lopez",
          "45963123",
          "2954789963",
          "algunemail@hotmail.com",
          TipoDePersona.INICIANTE.getValor());

  public static Persona involucrado = // Persona
      new Persona(
          2L,
          "martin",
          "melo",
          "50123654",
          "2958456987",
          "superman@yahoo.com.ar",
          TipoDePersona.INVOLUCRADO.getValor());
}
