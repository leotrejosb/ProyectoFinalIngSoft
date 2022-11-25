package com.plan.turismo.controller;


import com.plan.turismo.entity.Categoria;
import com.plan.turismo.entity.Paquete;
import com.plan.turismo.services.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquete")
@CrossOrigin("*")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    @PostMapping("/")
    public ResponseEntity<Paquete> guardarPaquete(@RequestBody Paquete paquete){
        return ResponseEntity.ok(paqueteService.agregarPaquete(paquete));
    }

    @PutMapping("/")
    public ResponseEntity<Paquete> actualizarPaquete(@RequestBody Paquete paquete){
        return ResponseEntity.ok(paqueteService.actualizarPaquete(paquete));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarPaquetes(){

        return ResponseEntity.ok(paqueteService.obtenerPaquetes());
    }

    @GetMapping("/{paqueteId}")
    public Paquete obtenerPaquete(@PathVariable("paqueteId") Long paqueteId){
        return paqueteService.obtenerPaquete(paqueteId);
    }

    @DeleteMapping("/{paqueteId}")
    public void eliminarPaquete(@PathVariable("paqueteId") Long paqueteId){

        paqueteService.eliminarExamen(paqueteId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Paquete> listarExamenesDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return paqueteService.listarPaquetesDeUnaCategoria(categoria);
    }

    @GetMapping("/activo")
    public List<Paquete> listarExamenesActivos(){

        return paqueteService.obtenerPaquetesActivos();
    }

    @GetMapping("/categoria/activo/{categoriaId}")
    public List<Paquete> listarPaquetesActivosDeUnaCategoria(@PathVariable("categoriaId") Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return paqueteService.obtenerPaquetesActivosDeUnaCategoria(categoria);
    }
}
