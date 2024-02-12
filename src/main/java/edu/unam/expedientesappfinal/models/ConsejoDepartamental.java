package edu.unam.expedientesappfinal.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// ESTA CLASE NO ME QUEDA CLARA

// @Entity
// @Table(name = "consejo_departamental")
public class ConsejoDepartamental implements Serializable {
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  //  @JoinTable(
  //      name = "tbl_consejo_personas",
  //      joinColumns = @JoinColumn(name = "consejo_id"),
  //      inverseJoinColumns = @JoinColumn(name = "personas_id"),
  //      uniqueConstraints = @UniqueConstraint(columnNames = {"consejo_id", "personas_id"}))
  private Set<Persona> miembros;

  public ConsejoDepartamental() {
    this.miembros = new HashSet<>();
  }

  public ConsejoDepartamental(Long id, Set<Persona> miembros) {
    this();
    this.id = id;
    this.miembros = miembros;
  }

  public void addMiembro(Persona miembro) {
    this.miembros.add(miembro);
  }

  public void removeMiembro(Persona miembro) {
    this.miembros.remove(miembro);
  }

  public ConsejoDepartamental(Set<Persona> miembros) {
    this.miembros = miembros;
  }

  public Set<Persona> getMiembros() {
    return miembros;
  }

  public void setMiembros(Set<Persona> miembros) {
    this.miembros = miembros;
  }

  @Override
  public String toString() {
    return "ConsejoDepartamental{" + "id=" + id + ", miembros=" + miembros + '}';
  }

  @Serial private static final long serialVersionUID = -7696437687356945770L;
}
