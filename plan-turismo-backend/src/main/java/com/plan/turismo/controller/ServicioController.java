package com.plan.turismo.controller;


import com.plan.turismo.entity.Paquete;
import com.plan.turismo.entity.Servicio;
import com.plan.turismo.services.PaqueteService;
import com.plan.turismo.services.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/servicio")
@CrossOrigin("*")
public class ServicioController {

    @Autowired
    private ServiciosService ServicioService;

    @Autowired
    private PaqueteService paqueteService;

    @PostMapping("/")
    public ResponseEntity<Servicio> guardarServicio(@RequestBody Servicio servicio){
        return ResponseEntity.ok(ServicioService.agregarServicio(servicio));
    }

    @PutMapping("/")
    public ResponseEntity<Servicio> actualizarPregunta(@RequestBody Servicio pregunta){
        return ResponseEntity.ok(ServicioService.actualizarServicio(pregunta));
    }

    @GetMapping("/paquete/{paqueteId}")
    public ResponseEntity<?> listarServiciosDelPaquete(@PathVariable("paqueteId") Long paqueteId){
        Paquete paquete = paqueteService.obtenerPaquete(paqueteId);
        Set<Servicio> servicios = paquete.getServicios();

        List paquetes = new ArrayList<>(servicios);
        if(paquetes.size() > Integer.valueOf(4)) {
            paquetes = paquetes.subList(0,Integer.parseInt("4" + 1));
        }

        Collections.shuffle(paquetes);
        return ResponseEntity.ok(paquetes);
    }

    @GetMapping("/{servicioId}")
    public Servicio listarServicioPorId(@PathVariable("servicioId") Long servicioId){
        return ServicioService.obtenerServicios(servicioId);
    }

    @DeleteMapping("/{servicioId}")
    public void eliminarServicio(@PathVariable("servicioId") Long servicioId){
        ServicioService.eliminarServicio(servicioId);
    }

    @GetMapping("/paquete/todos/{paqueteId}")
    public ResponseEntity<?> listarServicioDelPaqueteComoAdministrador(@PathVariable("paqueteId") Long paqueteId){
        Paquete paquete = new Paquete();
        paquete.setIdPaquete(paqueteId);
        Set<Servicio> servicios = ServicioService.obtenerServiciosDelPaquete(paquete);
        return ResponseEntity.ok(servicios);
    }

    @PostMapping("/evaluar-paquete")
    public ResponseEntity<?> evaluarPaquete(@RequestBody List<Servicio> servicios){

        final Servicio bus = new Servicio();
        final Servicio avion = new Servicio();
        final List<Servicio> excursiones = new ArrayList<>();
        final List<Servicio> hoteles = new ArrayList<>();

        servicios.forEach(servicio -> {
            if(servicio.getNombreServicio() == "bus") {
                bus.clone(servicio);
            }
            if(servicio.getNombreServicio() == "avion") {
                avion.clone(servicio);
            }
            if(servicio.getNombreServicio() == "excursiones") {
                excursiones.add(servicio);
            }
            if(servicio.getNombreServicio() == "bus") {
                hoteles.add(servicio);
            }
        });

        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("bus",bus);
        respuestas.put("avion",avion);
        respuestas.put("excursiones",excursiones);
        respuestas.put("hotel",hoteles);
        return ResponseEntity.ok(respuestas);
    }
}
