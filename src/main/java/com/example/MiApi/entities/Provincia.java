package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "provincias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provincia extends Base{

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
}
