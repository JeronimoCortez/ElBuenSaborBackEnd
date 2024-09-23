package com.example.MiApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "articulos_manufacturado")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloManufacturado extends Articulo{
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tiempo_estimado")
    private int tiempoEstimadoMinutos;

    @Column(name = "preparacion")
    private String preparacion;


}
