package com.plan.turismo.services.impl;

import com.plan.turismo.entity.Categoria;
import com.plan.turismo.entity.Paquete;
import com.plan.turismo.repo.PaqueteRepo;
import com.plan.turismo.services.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Service
public class PaqueteServiceImpl implements PaqueteService {

    @Autowired
    private PaqueteRepo paqueteRepo;

    @Override
    public Paquete agregarPaquete(Paquete paquete) {
        return paqueteRepo.save(paquete);
    }

    @Override
    public Paquete actualizarPaquete(Paquete paquete) {
        return paqueteRepo.save(paquete);
    }

    @Override
    public Set<Paquete> obtenerPaquetes() {
        return new LinkedHashSet<>(paqueteRepo.findAll());
    }

    @Override
    public Paquete obtenerPaquete(Long paqueteId) {
        return paqueteRepo.findById(paqueteId).get();
    }

    @Override
    public void eliminarExamen(Long paqueteId) {
        Paquete paquete = new Paquete();
        paquete.setIdPaquete(paqueteId);
        paqueteRepo.delete(paquete);
    }

    @Override
    public List<Paquete> listarPaquetesDeUnaCategoria(Categoria categoria) {
        return this.paqueteRepo.findByCategoria(categoria);
    }

    @Override
    public List<Paquete> obtenerPaquetesActivos() {
        return paqueteRepo.findByActivo(true);
    }

    @Override
    public List<Paquete> obtenerPaquetesActivosDeUnaCategoria(Categoria categoria) {
        return this.paqueteRepo.findByCategoriaAndActivo(categoria,true);
    }
}

