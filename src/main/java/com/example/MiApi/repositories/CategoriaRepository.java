package com.example.MiApi.repositories;

import com.example.MiApi.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{
    List<Categoria> findAllByCategoriaPadre_Id(Long idCategoriaPadre);

    @Query("SELECT c FROM Categoria c JOIN c.sucursales s WHERE s.id = :idSucursal")
    List<Categoria> findAllBySucursal_Id(@Param("idSucursal") Long idSucursal);
}
