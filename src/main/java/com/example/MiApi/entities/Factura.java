package com.example.MiApi.entities;

import com.example.MiApi.entities.enums.FormaPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends Base {

    @Column(name = "fecha_facturacion")
    private LocalDate fechaFacturacion;
    @Column(name = "mp_payment_id")
    private int mpPaymentId;
    @Column(name = "mp_merchant_order_id")
    private int mpMerchantOrderId;
    @Column(name = "mp_preference_id")
    private String mpPreferenceId;
    @Column(name = "mp_payment_type")
    private String mpPaymentType;
    @Column(name = "forma_pago")
    private FormaPago formaPago;
    @Column(name = "total_venta")
    private Double totalVenta;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
