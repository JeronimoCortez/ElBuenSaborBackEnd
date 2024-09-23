package com.example.MiApi.repositories;

import com.example.MiApi.entities.ArticuloManufacturadoDetalle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoDetalleRepository extends BaseRepository<ArticuloManufacturadoDetalle,Long>{

    List<ArticuloManufacturadoDetalle> findAllByArticuloInsumoId(Long articuloInsumoId);

    List<ArticuloManufacturadoDetalle> findAllByArticuloManufacturadoId(Long articuloManufacturadoId);


}
