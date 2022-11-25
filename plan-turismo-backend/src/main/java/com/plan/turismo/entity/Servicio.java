package com.plan.turismo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preguntas")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicioId;

    private String nombreServicio;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;

    @ManyToOne(fetch = FetchType.EAGER)
    private Paquete paquete;

    public void clone(Servicio servicio) {

        this.setServicioId(servicio.getServicioId());
        this.setNombreServicio(servicio.getNombreServicio());
        this.setOpcion1(servicio.getOpcion1());
        this.setOpcion2(servicio.getOpcion2());
        this.setOpcion3(servicio.getOpcion3());
        this.setOpcion4(servicio.getOpcion4());
        this.setPaquete(servicio.getPaquete());
    }
}
