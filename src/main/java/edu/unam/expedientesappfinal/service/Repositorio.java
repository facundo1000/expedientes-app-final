package edu.unam.expedientesappfinal.service;

import java.util.List;

public interface Repositorio<T> {
  List<T> listar();

  T obtenerPorId(Long id);

  void crear(T t);

  void actualizar(Long id, T t);

  void eliminar(Long id);
}
