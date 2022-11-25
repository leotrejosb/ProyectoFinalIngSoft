package com.plan.turismo.repo;

import com.plan.turismo.entity.Paquete;
import com.plan.turismo.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ServiciosRepo extends JpaRepository<Servicio,Long> {

    Set<Servicio> findByPaquete(Paquete paquete);

}
