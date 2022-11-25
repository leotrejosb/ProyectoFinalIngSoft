package com.plan.turismo.services.impl;

import com.plan.turismo.entity.Examen;
import com.plan.turismo.entity.Pregunta;
import com.plan.turismo.repo.PreguntaRepo;
import com.plan.turismo.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepo preguntaRepo;

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
        return preguntaRepo.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepo.save(pregunta);
    }

    @Override
    public Set<Pregunta> obtenerPregunta() {
        return (Set<Pregunta>) preguntaRepo.findAll();
    }

    @Override
    public Pregunta obtenerPregunta(Long preguntaId) {
        return preguntaRepo.findById(preguntaId).get();
    }

    @Override
    public Set<Pregunta> obtenerPreguntasDelExamen(Examen examen) {
        return preguntaRepo.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long preguntaId) {
        Pregunta pregunta = new Pregunta();
        pregunta.setPreguntaId(preguntaId);
        preguntaRepo.delete(pregunta);
    }
    @Override
    public Pregunta listarPregunta(Long preguntaId) {
        return this.preguntaRepo.getOne(preguntaId);
    }
}
