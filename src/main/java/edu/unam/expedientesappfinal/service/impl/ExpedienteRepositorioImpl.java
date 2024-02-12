package edu.unam.expedientesappfinal.service.impl;

import edu.unam.expedientesappfinal.models.Expediente;
import edu.unam.expedientesappfinal.service.Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ExpedienteRepositorioImpl implements Repositorio<Expediente> {
    private EntityManager em;

    public ExpedienteRepositorioImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Expediente> listar() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Expediente> consulta = cb.createQuery(Expediente.class);
        Root<Expediente> origen = consulta.from(Expediente.class);
        return em.createQuery(consulta.select(origen)).getResultList();
    }

    @Override
    public Expediente obtenerPorId(Long id) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Expediente> query = cb.createQuery(Expediente.class);
            Root<Expediente> from = query.from(Expediente.class);

            ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");

            query.select(from).where(cb.equal(from.get("id"), idParam));

            return em.createQuery(query).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener el expediente con id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void crear(Expediente expediente) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(expediente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al crear el expediente: " + e.getMessage(), e);
        }
    }

    @Override
    public void actualizar(Long id, Expediente expediente) {
        Expediente update;
        EntityTransaction transaction = null;
        if (id != null) {
            try {
                transaction = em.getTransaction();
                transaction.begin(); // Inicio de la Transaccion
                CriteriaBuilder cb = em.getCriteriaBuilder();
                CriteriaQuery<Expediente> query = cb.createQuery(Expediente.class);
                Root<Expediente> root = query.from(Expediente.class);

                ParameterExpression<Long> idParam = cb.parameter(Long.class, "id");
                query.select(root).where(cb.equal(root.get("id"), idParam));

                // Se busca por id a la persona a modificar
                update = em.createQuery(query).setParameter("id", id).getSingleResult();

                if (update != null) {
                    update.setTextNota((expediente.getTextNota().isBlank() || expediente.getTextNota() == null) ? update.getTextNota() : expediente.getTextNota());
                    update.setIniciante((expediente.getIniciante() == null ? update.getIniciante() : expediente.getIniciante()));
                    update.setEstadoDelExpediente((expediente.getEstadoDelExpediente() == null) ? update.getEstadoDelExpediente() : expediente.getEstadoDelExpediente());
                    update.setIngresoFacultad((expediente.getIngresoFacultad() == null) ? update.getIngresoFacultad() : expediente.getIngresoFacultad());
                    update.setEliminado((expediente.getEliminado() == null) ? update.getEliminado() : expediente.getEliminado());
                    update.setIniciante((expediente.getIniciante() == null) ? update.getIniciante() : expediente.getIniciante());
                    update.setEstadoDelExpediente((expediente.getEstadoDelExpediente() == null) ? update.getEstadoDelExpediente() : expediente.getEstadoDelExpediente());
                    update.setAcciones((expediente.getAcciones() == null) ? update.getAcciones() : expediente.getAcciones());
                    update.setInvolucrados((expediente.getInvolucrados() == null) ? update.getInvolucrados() : expediente.getInvolucrados());
                    em.merge(update);
                    transaction.commit();
                }

            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                throw new RuntimeException("Error al actualizar el expediente: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        Expediente expediente;
        EntityTransaction transaction = null;
        try {
            if (id != 0) {
                transaction = em.getTransaction();
                transaction.begin();
                expediente = em.find(Expediente.class, id);

                if (expediente != null) {
                    expediente.setEliminado(Boolean.TRUE);
                }
                transaction.commit();
            }
            System.out.println("Expediente N° " + id + " eliminado");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Error al eliminar el expediente con id " + id + ": " + e.getMessage(), e);
        }
    }
}
