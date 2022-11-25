package com.plan.turismo.repo;

import com.plan.turismo.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria,Long> {

}
