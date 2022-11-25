package com.plan.turismo.services.impl;

import com.plan.turismo.entity.Categoria;
import com.plan.turismo.repo.CategoriaRepo;
import com.plan.turismo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Override
    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<>(categoriaRepo.findAll());
    }

    @Override
    public Categoria obtenerCategoria(Long categoriaId) {
        return categoriaRepo.findById(categoriaId).get();
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        categoriaRepo.delete(categoria);
    }
}
