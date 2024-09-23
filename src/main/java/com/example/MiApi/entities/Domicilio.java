package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "domicilios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "codigo_postal")
    private Integer cp;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

}
