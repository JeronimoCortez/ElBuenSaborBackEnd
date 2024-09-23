package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "promocion_detalles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromocionDetalle extends Base {
    @Column
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;
}
