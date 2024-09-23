package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidades_medida")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadMedida extends Base {
    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
}

