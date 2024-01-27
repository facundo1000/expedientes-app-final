package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expedientes")
public class Expediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto_nota")
    private String textNota;

    @Column(name = "fecha_ingreso_facultad")
    private LocalDate ingresoFacultad;

    @OneToOne
    private Persona iniciante;

    @Column(name = "estado_expediente")
    @Enumerated(EnumType.STRING)
    private Estado estadoDelExpediente;

    private Boolean eliminado = Boolean.FALSE;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_expedientes_involucrados",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "personas_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "personas_id"}))
    private List<Persona> involucrados;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "tbl_expedientes_accciones",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "acciones_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "acciones_id"}))
    private List<AccionesRealizadas> acciones;

    @ManyToMany(
            mappedBy = "expedientesAbiertos",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Reunion> reuniones;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tbl_expedientes_minutas",
            joinColumns = @JoinColumn(name = "expediente_id"),
            inverseJoinColumns = @JoinColumn(name = "minuta_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"expediente_id", "minuta_id"}))
    private List<OrdenDelDia> minuta;


    public Expediente() {
        this.involucrados = new ArrayList<>();
        this.acciones = new ArrayList<>();
    }

    public Expediente(
            String textNota, LocalDate ingresoFacultad, Persona iniciante, Estado estadoDelExpediente) {
        this();
        this.textNota = textNota;
        this.ingresoFacultad = ingresoFacultad;
        this.iniciante = iniciante;
        this.estadoDelExpediente = estadoDelExpediente;
    }

    public Expediente(String textNota) {
        this.textNota = textNota;
    }

    public void addInvolucrado(Persona persona) {
        this.involucrados.add(persona);
//        persona.getExpediente().add(this);
    }

    public void removeInvolucrado(Persona persona) {
        this.involucrados.remove(persona);
//        persona.getExpediente().remove(this);
    }

    public void removeInvolucrados() {
        for (Persona p : new ArrayList<>(involucrados)) {
            removeInvolucrado(p);
        }
    }

    public void addAccion(AccionesRealizadas accion) {
        this.acciones.add(accion);
//        accion.addExpediente(this);
    }

    public void removeAccion(AccionesRealizadas accion) {
        this.acciones.remove(accion);
//        accion.removeExpediente(this);
    }

    public void removeAcciones() {
        for (AccionesRealizadas a : acciones) {
            removeAccion(a);
        }
    }

    public void addMinuta(OrdenDelDia minuta) {
        this.minuta.add(minuta);
        minuta.setExpediente(this);
    }

    public void removeMinuta(OrdenDelDia minuta) {
        this.minuta.remove(minuta);
        minuta.setExpediente(null);
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

    public Estado getEstadoDelExpediente() {
        return estadoDelExpediente;
    }

    public void setEstadoDelExpediente(Estado estadoDelExpediente) {
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

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Serial
    private static final long serialVersionUID = 737959743550398308L;

    @Override
    public String toString() {
        return "Expediente{" +
                "id=" + id +
                ", textNota='" + textNota + '\'' +
                ", ingresoFacultad=" + ingresoFacultad +
                ", iniciante=" + iniciante +
                ", estadoDelExpediente=" + estadoDelExpediente +
                ", involucrados=" + involucrados +
                ", acciones=" + acciones +
                ", reuniones=" + reuniones +
                ", minuta=" + minuta +
                '}';
    }
}
