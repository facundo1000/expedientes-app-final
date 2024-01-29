package edu.unam.expedientesappfinal.repositorios.impl;

import edu.unam.expedientesappfinal.modelos.Persona;
import edu.unam.expedientesappfinal.repositorios.Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class PersonasRepositorioImpl implements Repositorio<Persona> {
  private EntityManager em;

  public PersonasRepositorioImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<Persona> listar() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Persona> consulta = cb.createQuery(Persona.class);
      Root<Persona> origen = consulta.from(Persona.class);

      return em.createQuery(consulta.select(origen)).getResultList();
    } catch (Exception e) {
      throw new RuntimeException("Error al obtener la lista de personas: " + e.getMessage(), e);
    }
  }

  @Override
  public Persona obtenerPorId(Long id) {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
      Root<Persona> from = query.from(Persona.class);

      ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");

      query.select(from).where(cb.equal(from.get("id"), idParam));

      return em.createQuery(query).setParameter("id", id).getSingleResult();
    } catch (Exception e) {
      throw new RuntimeException(
          "Error al obtener la persona con id " + id + ": " + e.getMessage(), e);
    }
  }

  @Override
  public void crear(Persona persona) {
    EntityTransaction transaction = null;
    try {
      transaction = em.getTransaction();
      transaction.begin();
      em.persist(persona);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException("Error al crear la persona: " + e.getMessage(), e);
    }
  }

  @Override
  public void actualizar(Long id, Persona persona) {
    Persona update;
    EntityTransaction transaction = null;
    if (id != null) {
      try {
        transaction = em.getTransaction();
        transaction.begin(); // Inicio de la transaccion
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");
        query.select(root).where(cb.equal(root.get("id"), idParam));

        // Se busca por id a la persona a modificar
        update = em.createQuery(query).setParameter("id", id).getSingleResult();

        if (update != null) {
          update.setNombre(persona.getNombre().isBlank() ? update.getNombre() : persona.getNombre());
          update.setApellido((persona.getApellido().isBlank()) ? update.getApellido() : persona.getApellido());
          update.setDni((persona.getDni().isBlank()) ? update.getDni() : persona.getDni());
          update.setTelefono((persona.getTelefono().isBlank()) ? update.getTelefono() : persona.getTelefono());
          update.setEmail((persona.getEmail().isBlank()) ? update.getEmail() : persona.getEmail());
          update.setTipoDePersona((persona.getTipoDePersona() == null) ? update.getTipoDePersona() : persona.getTipoDePersona());
          em.merge(update);
          transaction.commit();
        }

      } catch (Exception e) {
        if (transaction != null && transaction.isActive()) {
          transaction.rollback();
        }
        throw new RuntimeException("Error al actualizar la persona: " + e.getMessage(), e);
      }
    }
  }

  @Override
  public void eliminar(Long id) {
    Persona persona;
    EntityTransaction transaction = null;
    try {
      if (id != 0) {
        transaction = em.getTransaction();
        transaction.begin();
        persona = em.find(Persona.class, id);

        if (persona != null) {
          persona.setEliminado(true);
          System.out.println("Persona N° " + id + " eliminada");
        }
        transaction.commit();
      }
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException(
          "Error al eliminar la persona con id " + id + ": " + e.getMessage(), e);
    }
  }
}
