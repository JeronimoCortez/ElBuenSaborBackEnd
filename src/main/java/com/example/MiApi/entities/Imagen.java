package com.example.MiApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imagen")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imagen extends Base{

    @Column(name = "denominacion")
    private String denominacion;

}
