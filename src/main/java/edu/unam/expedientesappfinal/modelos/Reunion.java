package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "reuniones")
public class Reunion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 30)
  private String ciudad;

  @Column(name = "fecha_reunion")
  private LocalDateTime fechaReunion;

  @Column(name = "temas_tratados", length = 50)
  private String temasTratados;

  @ManyToMany(
      cascade = {CascadeType.PERSIST, CascadeType.MERGE},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "tbl_reunion_expedientes",
      joinColumns = @JoinColumn(name = "reunion_id"),
      inverseJoinColumns = @JoinColumn(name = "expediente_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"reunion_id", "expediente_id"}))
  private List<Expediente> expedientesAbiertos;

  @ManyToMany(
      cascade = {CascadeType.MERGE, CascadeType.PERSIST},
      fetch = FetchType.LAZY)
  @JoinTable(
      name = "tbl_reunion_personas",
      joinColumns = @JoinColumn(name = "reunion_id"),
      inverseJoinColumns = @JoinColumn(name = "persona_id"),
      uniqueConstraints = @UniqueConstraint(columnNames = {"reunion_id", "persona_id"}))
  private Set<Persona> miembros;

  @OneToOne(mappedBy = "reunion")
  private Minuta minuta;

  public Reunion() {
    this.expedientesAbiertos = new ArrayList<>();
    this.miembros = new HashSet<>();
  }

  public Reunion(
      String ciudad,
      Minuta minuta,
      LocalDateTime fechaReunion,
      String temasTratados,
      List<Expediente> expedientesAbiertos,
      Set<Persona> miembros) {
    this.ciudad = ciudad;
    this.minuta = minuta;
    this.fechaReunion = fechaReunion;
    this.temasTratados = temasTratados;
    this.expedientesAbiertos = expedientesAbiertos;
    this.miembros = miembros;
  }

  public void addExpediente(Expediente expediente) {
    this.expedientesAbiertos.add(expediente);
    expediente.getReuniones().add(this);
  }

  public void removeExpediente(Expediente expediente) {
    this.expedientesAbiertos.remove(expediente);
    expediente.getReuniones().remove(this);
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public LocalDateTime getFechaReunion() {
    return fechaReunion;
  }

  public void setFechaReunion(LocalDateTime fechaReunion) {
    this.fechaReunion = fechaReunion;
  }

  public String getTemasTratados() {
    return temasTratados;
  }

  public void setTemasTratados(String temasTratados) {
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
}
