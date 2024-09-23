package com.example.MiApi.repositories;

import com.example.MiApi.entities.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    List<Empleado> findAllBySucursalId(Long idSucursal);

}
