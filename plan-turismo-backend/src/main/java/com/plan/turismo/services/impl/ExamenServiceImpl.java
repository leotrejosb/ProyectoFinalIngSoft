package com.plan.turismo.services.impl;

import com.plan.turismo.entity.Categoria;
import com.plan.turismo.entity.Examen;
import com.plan.turismo.repo.ExamenRepo;
import com.plan.turismo.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepo examenRepo;

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepo.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return examenRepo.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepo.findAll());
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return examenRepo.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        examenRepo.delete(examen);
    }

    @Override
    public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
        return this.examenRepo.findByCategoria(categoria);
    }

    @Override
    public List<Examen> obtenerExamenesActivos() {
        return examenRepo.findByActivo(true);
    }

    @Override
    public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
        return this.examenRepo.findByCategoriaAndActivo(categoria,true);
    }
}

