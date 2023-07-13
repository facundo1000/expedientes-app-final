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

  @ManyToOne private Expediente expediente;

  public AccionesRealizadas() {}

  public AccionesRealizadas(
      String accionRealizada, LocalDate fechaDeAccion, Expediente expediente) {
    this.accionRealizada = accionRealizada;
    this.fechaDeAccion = fechaDeAccion;
    this.expediente = expediente;
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

  public Expediente getExpediente() {
    return expediente;
  }

  public void setExpediente(Expediente expediente) {
    this.expediente = expediente;
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
        + ", expediente="
        + expediente
        + '}';
  }
}
