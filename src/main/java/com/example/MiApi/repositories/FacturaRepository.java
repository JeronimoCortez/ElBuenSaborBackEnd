package com.example.MiApi.repositories;

import com.example.MiApi.entities.Factura;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long>{

    List<Factura> findAllByPedidoId(Long idPedido);

}
