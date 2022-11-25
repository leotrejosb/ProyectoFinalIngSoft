package com.plan.turismo.repo;

import com.plan.turismo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
