package edu.unam.expedientesappfinal.modelos;

import java.util.Set;

public class ConsejoDepartamental {
  private Long id;
  private Set<Persona> miembros;

  public ConsejoDepartamental() {}

  public ConsejoDepartamental(Set<Persona> miembros) {
    this.miembros = miembros;
  }

  public Set<Persona> getMiembros() {
    return miembros;
  }

  public void setMiembros(Set<Persona> miembros) {
    this.miembros = miembros;
  }

  @Override
  public String toString() {
    return "ConsejoDepartamental{" + "id=" + id + ", miembros=" + miembros + '}';
  }
}
