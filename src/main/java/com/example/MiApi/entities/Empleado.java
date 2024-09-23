package com.example.MiApi.entities;

import com.example.MiApi.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "empleados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado extends Persona implements Serializable {
    @Column(name = "tipo_empleado")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;


}
