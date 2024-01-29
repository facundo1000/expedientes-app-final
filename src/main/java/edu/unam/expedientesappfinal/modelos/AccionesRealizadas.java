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

    private Boolean eliminado = Boolean.FALSE;

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

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccionesRealizadas{");
        sb.append("id=").append(id);
        sb.append(", accionRealizada='").append(accionRealizada).append('\'');
        sb.append(", fechaDeAccion=").append(fechaDeAccion);
        sb.append(", expediente=").append(expediente);
        sb.append(", eliminado=").append(eliminado);
        sb.append('}');
        return sb.toString();
    }

    @Serial
    private static final long serialVersionUID = 1285447166036239442L;
}
