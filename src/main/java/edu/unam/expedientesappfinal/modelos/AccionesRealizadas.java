package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "acciones_realizadas")
public class AccionesRealizadas implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "accion_realizada")
  private String accionRealizada;

  @Column(name = "fecha_accion")
  private LocalDate fechaDeAccion;

  @ManyToOne
  @JoinColumn(name = "expediente_id")
  private Expediente expediente;

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
        + '}';
  }

  @Serial private static final long serialVersionUID = 1285447166036239442L;
}
