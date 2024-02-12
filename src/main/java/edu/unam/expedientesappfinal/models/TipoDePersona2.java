package edu.unam.expedientesappfinal.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_de_persona")
public class TipoDePersona2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public TipoDePersona2() {
    }

    public TipoDePersona2(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
