package edu.unam.expedientesappfinal.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;

    @Column(length = 20)
    private String apellido;

    @Column(length = 20)
    private String dni;

    @Column(length = 30, unique = true)
    private String telefono;

    @Column(length = 50, unique = true)
    private String email;

    @Column(name = "tipo_persona")
    @ElementCollection
    private List<String> tipoDePersona;

    @Column(name = "tipo_doc")
    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipoDoc;

//    @ManyToMany(
//            mappedBy = "involucrados",
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private List<Expediente> expediente;

    @Column(name = "fecha_nac")
    private LocalDate bday;

    private Boolean asistencia;

    private Boolean eliminado;


    @PrePersist
    public void setAsistenciaFalse() {
        asistencia = Boolean.FALSE;
        this.eliminado = Boolean.FALSE;
    }

    public Persona() {
        tipoDePersona = new ArrayList<>();
    }

    public Persona(String nombre,
                   String apellido,
                   String dni,
                   String telefono,
                   String email,
                   List<String> tipoDePersona,
                   Boolean asistencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.tipoDePersona = tipoDePersona;
        this.asistencia = asistencia;
    }


    //    public void addExpediente(Expediente expediente) {
//        this.expediente.add(expediente);
//        expediente.getInvolucrados().add(this);
//    }
//
//    public void removeExpediente(Expediente expediente) {
//        this.expediente.remove(expediente);
//        expediente.getInvolucrados().remove(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


//    public List<Expediente> getExpediente() {
//        return expediente;
//    }
//
//    public void setExpediente(List<Expediente> expediente) {
//        this.expediente = expediente;
//    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public TipoDeDocumento getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDeDocumento tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public List<String> getTipoDePersona() {
        return tipoDePersona;
    }

    public void setTipoDePersona(List<String> tipoDePersona) {
        this.tipoDePersona = tipoDePersona;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", tipoDePersona=" + tipoDePersona +
                ", tipoDoc=" + tipoDoc +
                ", bday=" + bday +
                ", asistencia=" + asistencia +
                ", eliminado=" + eliminado +
                '}';
    }

    @Serial
    private static final long serialVersionUID = 2836725016219005304L;
}
