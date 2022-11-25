package com.plan.turismo.repo;

import com.plan.turismo.entity.Examen;
import com.plan.turismo.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepo extends JpaRepository<Pregunta,Long> {

    Set<Pregunta> findByExamen(Examen examen);

}
