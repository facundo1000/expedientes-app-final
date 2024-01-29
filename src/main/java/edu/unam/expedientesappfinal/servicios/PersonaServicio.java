package edu.unam.expedientesappfinal.servicios;

import edu.unam.expedientesappfinal.repositorios.impl.PersonasRepositorioImpl;

public class PersonaServicio {
    private PersonasRepositorioImpl repo;
    public PersonaServicio(PersonasRepositorioImpl repo) {
        this.repo = repo;
    }

    
}
