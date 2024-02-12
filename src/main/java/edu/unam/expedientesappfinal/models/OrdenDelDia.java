package edu.unam.expedientesappfinal.models;

import jakarta.persistence.*;

@Entity
@Table(name = "minutas")
public class OrdenDelDia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100)
  private String minuta;

  @ManyToOne private Expediente expediente;
  @OneToOne private Reunion reunion;

  public String getMinuta() {
    return minuta;
  }

  public void setMinuta(String minuta) {
    this.minuta = minuta;
  }

  public Expediente getExpediente() {
    return expediente;
  }

  public void setExpediente(Expediente expediente) {
    this.expediente = expediente;
  }

  public Reunion getReunion() {
    return reunion;
  }

  public void setReunion(Reunion reunion) {
    this.reunion = reunion;
  }
}
