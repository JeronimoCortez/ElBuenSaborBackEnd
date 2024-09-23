package com.example.MiApi.repositories;

import com.example.MiApi.entities.Domicilio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long> {

    List<Domicilio> findAllByLocalidadId(Long localidadId);

}
