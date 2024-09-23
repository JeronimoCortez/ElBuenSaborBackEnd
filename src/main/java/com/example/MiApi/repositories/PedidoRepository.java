package com.example.MiApi.repositories;

import com.example.MiApi.entities.Pedido;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    List<Pedido> findAllByClienteId(Long clienteId);

    List<Pedido> findAllByEmpleadoId(Long empleadoId);

    List<Pedido> findAllBySucursalId(Long sucursalId);
}
