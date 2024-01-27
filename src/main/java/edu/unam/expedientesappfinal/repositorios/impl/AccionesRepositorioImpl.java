package edu.unam.expedientesappfinal.repositorios.impl;

import edu.unam.expedientesappfinal.modelos.AccionesRealizadas;
import edu.unam.expedientesappfinal.repositorios.Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class AccionesRepositorioImpl implements Repositorio<AccionesRealizadas> {

  private EntityManager em;

  public AccionesRepositorioImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<AccionesRealizadas> listar() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<AccionesRealizadas> consulta = cb.createQuery(AccionesRealizadas.class);
      Root<AccionesRealizadas> origen = consulta.from(AccionesRealizadas.class);

      return em.createQuery(consulta.select(origen)).getResultList();
    } catch (Exception e) {
      throw new RuntimeException(
          "Error al obtener la lista de acciones realizadas: " + e.getMessage(), e);
    }
  }

  @Override
  public AccionesRealizadas obtenerPorId(Long id) {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<AccionesRealizadas> query = cb.createQuery(AccionesRealizadas.class);
      Root<AccionesRealizadas> from = query.from(AccionesRealizadas.class);

      ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");

      query.select(from).where(cb.equal(from.get("id"), idParam));

      return em.createQuery(query).setParameter("id", id).getSingleResult();
    } catch (Exception e) {
      throw new RuntimeException(
          "Error al obtener la accion realizada con id " + id + ": " + e.getMessage(), e);
    }
  }

  @Override
  public void crear(AccionesRealizadas accion) {
    EntityTransaction transaction = null;
    try {
      transaction = em.getTransaction();
      transaction.begin();
      em.persist(accion);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException("Error al crear la accion: " + e.getMessage(), e);
    }
  }

  @Override
  public void actualizar(Long id, AccionesRealizadas accion) {
    AccionesRealizadas update;
    EntityTransaction transaction = null;
    if (id != null) {
      try {
        transaction = em.getTransaction();
        transaction.begin(); // Inicio de la transaccion
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AccionesRealizadas> query = cb.createQuery(AccionesRealizadas.class);
        Root<AccionesRealizadas> root = query.from(AccionesRealizadas.class);

        ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");
        query.select(root).where(cb.equal(root.get("id"), idParam));

        // Se busca por id a la persona a modificar
        update = em.createQuery(query).setParameter("id", id).getSingleResult();

        if (update != null) {
          update.setAccionRealizada(
              accion.getAccionRealizada().isBlank()
                  ? update.getAccionRealizada()
                  : accion.getAccionRealizada());
          update.setFechaDeAccion(
              (accion.getFechaDeAccion() == null)
                  ? update.getFechaDeAccion()
                  : accion.getFechaDeAccion());

          update.setExpediente((accion.getExpediente() == null) ? update.getExpediente() : accion.getExpediente());
          em.merge(update);
          transaction.commit();
        }

      } catch (Exception e) {
        if (transaction != null && transaction.isActive()) {
          transaction.rollback();
        }
        throw new RuntimeException("Error al actualizar la accion: " + e.getMessage(), e);
      }
    }
  }

  @Override
  public void eliminar(Long id) {
    AccionesRealizadas accion;
    EntityTransaction transaction = null;
    try {
      if (id != 0) {
        transaction = em.getTransaction();
        transaction.begin();
        accion = em.find(AccionesRealizadas.class, id);

        if (accion != null) {
          em.remove(accion);
          System.out.println("Accion N° " + id + " eliminada");
        }
        transaction.commit();
      }
    } catch (Exception e) {
      if (transaction != null && transaction.isActive()) {
        transaction.rollback();
      }
      throw new RuntimeException(
          "Error al eliminar la accion con id " + id + ": " + e.getMessage(), e);
    }
  }
}
