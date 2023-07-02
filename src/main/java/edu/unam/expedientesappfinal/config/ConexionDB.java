package edu.unam.expedientesappfinal.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConexionDB {
  private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

  private static EntityManagerFactory buildEntityManagerFactory() {
    return Persistence.createEntityManagerFactory("expedientes");
  }

  private ConexionDB() {}

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
}
