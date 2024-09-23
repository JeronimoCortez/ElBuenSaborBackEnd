package com.example.MiApi.repositories;

import com.example.MiApi.entities.Promocion;
import com.example.MiApi.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionRepository extends BaseRepository<Promocion, Long>{

    @Query("SELECT p FROM Promocion p JOIN p.sucursales s WHERE s.id = :sucursalId")
    List<Promocion> findAllBySucursalId(@Param("sucursalId") Long sucursalId);

}
