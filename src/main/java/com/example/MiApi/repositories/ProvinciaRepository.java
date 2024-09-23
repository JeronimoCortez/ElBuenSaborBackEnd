package com.example.MiApi.repositories;

import com.example.MiApi.entities.Provincia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinciaRepository extends BaseRepository<Provincia, Long>{

    List<Provincia> findAllByPaisId(Long paisId);

}
