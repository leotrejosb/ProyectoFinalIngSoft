package com.plan.turismo.services;

import com.plan.turismo.entity.Categoria;
import com.plan.turismo.entity.Paquete;


import java.util.List;
import java.util.Set;

public interface PaqueteService {

    Paquete agregarPaquete(Paquete examen);

    Paquete actualizarPaquete(Paquete examen);

    Set<Paquete> obtenerPaquetes();

    Paquete obtenerPaquete(Long examenId);

    void eliminarExamen(Long examenId);

    List<Paquete> listarPaquetesDeUnaCategoria(Categoria categoria);

    List<Paquete> obtenerPaquetesActivos();

    List<Paquete> obtenerPaquetesActivosDeUnaCategoria(Categoria categoria);

}
