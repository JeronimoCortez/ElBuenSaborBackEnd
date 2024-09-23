package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articulos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED) //Es una clase padre pero al necesitar su tabla en la BD necesitamos esta anotacion
public abstract class Articulo extends Base{

    @Column(name = "denominacion")
    protected String denominacion;

    @Column(name = "precio_venta")
    protected Double precioVenta;

    @OneToMany
    @Builder.Default
    private Set<Imagen> imagenesArticulos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


}
