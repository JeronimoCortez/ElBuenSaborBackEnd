package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "detalles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends Base{
    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "articulo_id")
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
