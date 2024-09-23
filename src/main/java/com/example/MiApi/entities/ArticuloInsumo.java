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
@Table(name = "articulos_insumo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ArticuloInsumo extends Articulo{

    @Column(name = "precio_compra")
    private Double precioCompra;
    @Column(name = "stock_actual")
    private int stockActual;
    @Column(name = "stock_maximo")
    private int stockMaximo;
    @Column(name = "para_elaborar")
    private boolean esParaElaborar;

}
