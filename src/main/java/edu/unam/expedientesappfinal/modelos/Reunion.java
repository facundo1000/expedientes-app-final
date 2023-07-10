package edu.unam.expedientesappfinal.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reunion {
  private Long id;
  private String ciudad;
  private String minuta; // en la vista como un textArea
  private LocalDateTime fechaReunion;
  private List<String> temasTratados;
  private List<Expediente> expedientesAbiertos;
  private Set<Persona> miembros;

  public Reunion() {
    this.temasTratados = new ArrayList<>();
    this.expedientesAbiertos = new ArrayList<>();
    this.miembros = new HashSet<>();
  }

  public Reunion(
      String ciudad,
      String minuta,
      LocalDateTime fechaReunion,
      List<String> temasTratados,
      List<Expediente> expedientesAbiertos,
      Set<Persona> miembros) {
    this.ciudad = ciudad;
    this.minuta = minuta;
    this.fechaReunion = fechaReunion;
    this.temasTratados = temasTratados;
    this.expedientesAbiertos = expedientesAbiertos;
    this.miembros = miembros;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getMinuta() {
    return minuta;
  }

  public void setMinuta(String minuta) {
    this.minuta = minuta;
  }

  public LocalDateTime getFechaReunion() {
    return fechaReunion;
  }

  public void setFechaReunion(LocalDateTime fechaReunion) {
    this.fechaReunion = fechaReunion;
  }

  public List<String> getTemasTratados() {
    return temasTratados;
  }

  public void setTemasTratados(List<String> temasTratados) {
    this.temasTratados = temasTratados;
  }

  public List<Expediente> getExpedientesAbiertos() {
    return expedientesAbiertos;
  }

  public void setExpedientesAbiertos(List<Expediente> expedientesAbiertos) {
    this.expedientesAbiertos = expedientesAbiertos;
  }

  public Set<Persona> getMiembros() {
    return miembros;
  }

  public void setMiembros(Set<Persona> miembros) {
    this.miembros = miembros;
  }

  @Override
  public String toString() {
    return "Reunion{"
        + "id="
        + id
        + ", ciudad='"
        + ciudad
        + '\''
        + ", minuta='"
        + minuta
        + '\''
        + ", fechaReunion="
        + fechaReunion
        + ", temasTratados="
        + temasTratados
        + ", expedientesAbiertos="
        + expedientesAbiertos
        + ", miembros="
        + miembros
        + '}';
  }
}
