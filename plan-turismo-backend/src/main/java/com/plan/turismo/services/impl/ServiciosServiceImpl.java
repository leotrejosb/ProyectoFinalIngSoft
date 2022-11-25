package com.plan.turismo.services.impl;

import com.plan.turismo.entity.Paquete;
import com.plan.turismo.entity.Servicio;
import com.plan.turismo.repo.ServiciosRepo;
import com.plan.turismo.services.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class ServiciosServiceImpl implements ServiciosService {

    @Autowired
    private ServiciosRepo serviciosRepo;

    @Override
    public Servicio agregarServicio(Servicio pregunta) {

        return serviciosRepo.save(pregunta);
    }

    @Override
    public Servicio actualizarServicio(Servicio pregunta) {

        return serviciosRepo.save(pregunta);
    }

    @Override
    public Set<Servicio> obtenerServicios() {

        return (Set<Servicio>) serviciosRepo.findAll();
    }

    @Override
    public Servicio obtenerServicios(Long preguntaId) {

        return serviciosRepo.findById(preguntaId).get();
    }

    @Override
    public Set<Servicio> obtenerServiciosDelPaquete(Paquete paquete) {
        return serviciosRepo.findByExamen(paquete);
    }

    @Override
    public void eliminarServicio(Long servicioId) {
        Servicio servicio = new Servicio();
        servicio.setServicioId(servicioId);
        serviciosRepo.delete(servicio);
    }

    @Override
    public Servicio obtenerServicio(Long preguntaId) {

        return this.serviciosRepo.getOne(preguntaId);
    }
}
