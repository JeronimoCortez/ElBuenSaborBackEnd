package com.example.MiApi.entities;

import com.example.MiApi.entities.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends Persona implements Serializable {

    @Column(name = "rol")
    private Rol rol;

    //@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    //@Builder.Default
    //private ArrayList<Pedido> pedidos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cliente_domicilio",
    joinColumns = @JoinColumn(name = "cliente_id"),
    inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

}
