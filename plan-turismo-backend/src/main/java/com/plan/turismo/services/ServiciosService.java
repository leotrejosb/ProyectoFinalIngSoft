package com.plan.turismo.services;

import com.plan.turismo.entity.Paquete;
import com.plan.turismo.entity.Servicio;

import java.util.Set;

public interface ServiciosService {

    Servicio agregarServicio(Servicio servicio);

    Servicio actualizarServicio(Servicio servicio);

    Set<Servicio> obtenerServicios();

    Servicio obtenerServicios(Long preguntaId);

    Set<Servicio> obtenerServiciosDelPaquete(Paquete paquete);

    void eliminarServicio(Long servicioId);

    Servicio obtenerServicio(Long servicioId);
}
