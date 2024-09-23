package com.example.MiApi.repositories;

import com.example.MiApi.entities.Localidad;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{

    List<Localidad> findAllByProvinciaId(Long provinciaId);
}
