package com.example.MiApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa extends Base{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "cuil")
    private Integer cuil;


}
