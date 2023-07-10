package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expediente")
public class Expediente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "texto_nota")
  private String textNota;

  @Column(name = "fecha_ingreso_facultad")
  private LocalDate ingresoFacultad;

  @OneToOne private Persona iniciante;

  @Column(name = "estado_expediente")
  private String estadoDelExpediente;

  @ManyToMany private List<Persona> involucrados;

  @OneToMany private List<AccionesRealizadas> acciones;

  public Expediente() {
    this.involucrados = new ArrayList<>();
    this.acciones = new ArrayList<>();
  }

  public Expediente(
      String textNota,
      LocalDate ingresoFacultad,
      Persona iniciante,
      String estadoDelExpediente,
      List<Persona> involucrados,
      List<AccionesRealizadas> acciones) {
    this.textNota = textNota;
    this.ingresoFacultad = ingresoFacultad;
    this.iniciante = iniciante;
    this.estadoDelExpediente = estadoDelExpediente;
    this.involucrados = involucrados;
    this.acciones = acciones;
  }

  public String getTextNota() {
    return textNota;
  }

  public void setTextNota(String textNota) {
    this.textNota = textNota;
  }

  public LocalDate getIngresoFacultad() {
    return ingresoFacultad;
  }

  public void setIngresoFacultad(LocalDate ingresoFacultad) {
    this.ingresoFacultad = ingresoFacultad;
  }

  public Persona getIniciante() {
    return iniciante;
  }

  public void setIniciante(Persona iniciante) {
    this.iniciante = iniciante;
  }

  public String getEstadoDelExpediente() {
    return estadoDelExpediente;
  }

  public void setEstadoDelExpediente(String estadoDelExpediente) {
    this.estadoDelExpediente = estadoDelExpediente;
  }

  public List<Persona> getInvolucrados() {
    return involucrados;
  }

  public void setInvolucrados(List<Persona> involucrados) {
    this.involucrados = involucrados;
  }

  public List<AccionesRealizadas> getAcciones() {
    return acciones;
  }

  public void setAcciones(List<AccionesRealizadas> acciones) {
    this.acciones = acciones;
  }

  @Override
  public String toString() {
    return "Expediente{"
        + "id="
        + id
        + ", textNota='"
        + textNota
        + '\''
        + ", ingresoFacultad="
        + ingresoFacultad
        + ", iniciante="
        + iniciante
        + ", estadoDelExpediente='"
        + estadoDelExpediente
        + '\''
        + ", involucrados="
        + involucrados
        + ", acciones="
        + acciones
        + '}';
  }
}
