package edu.unam.expedientesappfinal.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20)
  private String nombre;

  @Column(length = 20)
  private String apellido;

  @Column(length = 20)
  private String dni;

  @Column(length = 30)
  private String telefono;

  @Column(length = 50)
  private String email;

  @Column(name = "tipo_persona")
  private String tipoDePersona;

  public Persona() {}

  public Persona(
      Long id,
      String nombre,
      String apellido,
      String dni,
      String telefono,
      String email,
      String tipoDePersona) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.telefono = telefono;
    this.email = email;
    this.tipoDePersona = tipoDePersona;
  }

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

  public String getTipoDePersona() {
    return tipoDePersona;
  }

  public void setTipoDePersona(String tipoDePersona) {
    this.tipoDePersona = tipoDePersona;
  }

  @Override
  public String toString() {
    return "Persona{"
        + "id="
        + id
        + ", nombre='"
        + nombre
        + '\''
        + ", apellido='"
        + apellido
        + '\''
        + ", dni='"
        + dni
        + '\''
        + ", telefono='"
        + telefono
        + '\''
        + ", email='"
        + email
        + '\''
        + ", tipoDePersona='"
        + tipoDePersona
        + '\''
        + '}';
  }
}
