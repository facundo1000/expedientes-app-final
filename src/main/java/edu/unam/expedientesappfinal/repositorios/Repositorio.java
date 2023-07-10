package edu.unam.expedientesappfinal.repositorios;

import edu.unam.expedientesappfinal.modelos.Persona;
import java.util.List;

public interface Repositorio<T> {
  List<T> listar();

  T obtenerPorId(Long id);

  T crear(Persona persona);

  T actualizar(Long id, T t);

  void eliminar(Long id);
}
