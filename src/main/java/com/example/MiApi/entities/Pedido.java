package com.example.MiApi.entities;

import com.example.MiApi.entities.enums.Estado;
import com.example.MiApi.entities.enums.FormaPago;
import com.example.MiApi.entities.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends Base{
    @Column(name = "hora_estimada_finalizacion")
    private LocalTime horaEstimadaFinalizacion;
    @Column(name = "total")
    private Double total = 0.0;
    @Column(name = "total_costo")
    private Double totalCosto;
    @Column(name = "estado")
    private Estado estado;
    @Column(name = "tipo_envio")
    private TipoEnvio tipoEnvio;
    @Column(name = "forma_pago")
    private FormaPago formaPago;
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    //@OneToMany
    //@JoinColumn(name = "detalles_pedido")
    //@Builder.Default
    //private ArrayList<DetallePedido> detalles = new ArrayList<>();

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}

