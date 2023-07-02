package edu.unam.expedientesappfinal.modelos;

public enum TipoDePersona {
  INICIANTE("iniciante"),
  INVOLUCRADO("involucrado"),
  MIEMBRO("miembro"),
  DIRECTOR("director");

  private String val;

  TipoDePersona(String val) {
    this.val = val;
  }

  public String getValor() {
    return val;
  }
}
