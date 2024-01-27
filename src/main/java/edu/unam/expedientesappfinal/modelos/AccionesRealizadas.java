package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "acciones")
//    @JoinColumn(name = "expediente_id")
    private List<Expediente> expediente;

    private Boolean eliminado;

    @PrePersist
    public void prePersist() {
        this.eliminado = Boolean.FALSE;
    }

    public AccionesRealizadas() {
        this.expediente = new ArrayList<>();
    }

    public AccionesRealizadas(String accionRealizada, LocalDate fechaDeAccion) {
        this.accionRealizada = accionRealizada;
        this.fechaDeAccion = fechaDeAccion;

    }

    public void addExpediente(Expediente expediente) {
        this.expediente.add(expediente);
    }

    public void removeExpediente(Expediente expediente) {
        this.expediente.remove(expediente);
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

    public List<Expediente> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Expediente> expediente) {
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

    @Serial
    private static final long serialVersionUID = 1285447166036239442L;
}
