package com.plan.turismo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PAQUETES")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaquete;

    private String ciudadIntermedia;
    private String ciudadFinal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    private boolean activo = false;

    @OneToMany(mappedBy = "paquete",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Servicio> servicios = new HashSet<>();
}
