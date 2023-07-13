package edu.unam.expedientesappfinal.servicios;

import static edu.unam.expedientesappfinal.config.DataSource.iniciante;
import static edu.unam.expedientesappfinal.config.DataSource.involucrado;

import edu.unam.expedientesappfinal.config.ConexionDB;
import edu.unam.expedientesappfinal.modelos.Persona;
import edu.unam.expedientesappfinal.repositorios.PersonasRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class PersonaServicio implements PersonasRepositorio {

  public PersonaServicio() {}

  private final EntityManager em = ConexionDB.getEntityManager();

  @Override
  public List<Persona> listar() {

    em.getTransaction().begin();

    Persona per = em.merge(iniciante);
    Persona per2 = em.merge(involucrado);

    em.persist(per);
    em.persist(per2);

    em.getTransaction().commit();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Persona> consulta = cb.createQuery(Persona.class);
    Root<Persona> origen = consulta.from(Persona.class);

    return em.createQuery(consulta.select(origen)).getResultList();
  }

  @Override
  public Persona obtenerPorId(Long id) {
    return null;
  }

  @Override
  public Persona crear(Persona persona) {
    return null;
  }

  @Override
  public Persona actualizar(Long id, Persona persona) {
    return null;
  }

  @Override
  public void eliminar(Long id) {}
}
