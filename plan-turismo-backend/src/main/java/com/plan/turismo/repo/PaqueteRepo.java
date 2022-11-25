package com.plan.turismo.repo;

import com.plan.turismo.entity.Categoria;
import com.plan.turismo.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaqueteRepo extends JpaRepository<Paquete,Long> {

    List<Paquete> findByCategoria(Categoria categoria);

    List<Paquete> findByActivo(Boolean estado);

    List<Paquete> findByCategoriaAndActivo(Categoria categoria,Boolean estado);
}
