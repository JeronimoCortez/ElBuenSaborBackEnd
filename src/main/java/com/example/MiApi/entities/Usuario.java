package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends Base{

    @Column(name = "auth0Id")
    private String auth0Id;
    @Column(name = "nombre_usuario")
    private String userName;
}
