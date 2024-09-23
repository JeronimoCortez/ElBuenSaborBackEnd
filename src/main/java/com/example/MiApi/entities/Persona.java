package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Persona extends Base implements Serializable {

    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String email;
    protected String fechaNacimiento;


    @OneToOne
    protected Imagen imagenPersona;

    @OneToOne
    protected Usuario usuario;
}
