package edu.unam.expedientesappfinal.repositorios;

import edu.unam.expedientesappfinal.modelos.Persona;
import java.util.List;

public interface Repositorio<T> {
  List<T> listar();

  T obtenerPorId(Long id);

  void crear(T persona);

  void actualizar(Long id, T t);

  void eliminar(Long id);
}
