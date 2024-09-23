package com.example.MiApi.repositories;

import com.example.MiApi.entities.DetallePedido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long>{

    List<DetallePedido> findAllByPedidoId(Long idPedido);

}
