package com.example.MiApi.entities;

import com.example.MiApi.entities.enums.TipoPromocion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promociones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocion extends Base{
    @Column(name = "denominacion")
    private String denominacion;
    @Column(name = "desde")
    private LocalDate fechaDesde;
    @Column(name = "hasta")
    private LocalDate fechaHasta;
    @Column(name = "descripcion_descuento")
    private String descripcionDescuento;
    @Column(name = "precio_promocional")
    private double precioPromocional;
    @Column(name = "tipo_promocion")
    private TipoPromocion tipoPromocion;

    @OneToMany
    @JoinColumn(name = "imagenes_promocion_id")
    @Builder.Default
    private Set<Imagen> imagenesPromocion = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "promocion_detalle_id")
    @Builder.Default
    private Set<PromocionDetalle> promocionDetalles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "promocion_sucursal", joinColumns = @JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id"))
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

}
