package com.example.MiApi.repositories;

import com.example.MiApi.entities.Articulo;
import com.example.MiApi.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long>{
    @Query("SELECT a FROM Articulo a JOIN a.imagenesArticulos i WHERE i.id = :idImagen")
    List<Articulo> findAllByImagenId(@Param("idImagen")Long idImagen);

    List<Articulo> findAllByCategoriaId(Long idCategoria);
}
