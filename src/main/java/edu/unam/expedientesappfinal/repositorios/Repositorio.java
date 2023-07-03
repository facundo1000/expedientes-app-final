package edu.unam.expedientesappfinal.repositorios;

import java.util.List;

public interface Repositorio<T> {
  List<T> listar();
  T obtenerPorId(Long id);
  T crear(T t);
  T actualizar(Long id, T t);
  void eliminar(Long id);
}
