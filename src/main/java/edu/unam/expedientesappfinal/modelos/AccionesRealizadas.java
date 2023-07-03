package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "acciones_realizadas")
public class AccionesRealizadas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "accion_realizada")
  private String accionRealizada;

  @Column(name = "fecha_accion")
  private LocalDate fechaDeAccion;

  public AccionesRealizadas() {}

  public AccionesRealizadas(String accionRealizada, LocalDate fechaDeAccion) {
    this.accionRealizada = accionRealizada;
    this.fechaDeAccion = fechaDeAccion;
  }

  public String getAccionRealizada() {
    return accionRealizada;
  }

  public void setAccionRealizada(String accionRealizada) {
    this.accionRealizada = accionRealizada;
  }

  public LocalDate getFechaDeAccion() {
    return fechaDeAccion;
  }

  public void setFechaDeAccion(LocalDate fechaDeAccion) {
    this.fechaDeAccion = fechaDeAccion;
  }

  @Override
  public String toString() {
    return "AccionesRealizadas{"
        + "id="
        + id
        + ", accionRealizada='"
        + accionRealizada
        + '\''
        + ", fechaDeAccion="
        + fechaDeAccion
        + '}';
  }
}
