package com.example.MiApi.repositories;

import com.example.MiApi.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends BaseRepository<Sucursal, Long>{

    List<Sucursal> findAllByEmpresaId(Long empresaId);

}
