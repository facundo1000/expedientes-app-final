package edu.unam.expedientesappfinal.repositorios.impl;

import edu.unam.expedientesappfinal.modelos.ConsejoDepartamental;
import edu.unam.expedientesappfinal.repositorios.Repositorio;
import java.util.List;

public class ConsejoRepositorioImpl implements Repositorio<ConsejoDepartamental> {
    @Override
    public List<ConsejoDepartamental> listar() {
    return null;
    }

    @Override
    public ConsejoDepartamental obtenerPorId(Long id) {
        return null;
    }

    @Override
    public void crear(ConsejoDepartamental persona) {

    }

    @Override
    public void actualizar(Long id, ConsejoDepartamental consejoDepartamental) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
