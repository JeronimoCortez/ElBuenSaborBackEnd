package com.example.MiApi.services;

import com.example.MiApi.entities.DetallePedido;
import com.example.MiApi.entities.Pedido;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService extends BaseService<Pedido, Long> {
    public PedidoService(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
    }

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Transactional
    public Pedido calcularTotal(Pedido pedido) throws Exception {
        try{
            List<DetallePedido> detallePedidos = detallePedidoService.listarPorPedido(pedido.getId());
            Double total = 0.0;

            if(detallePedidos != null && !detallePedidos.isEmpty()){
                total = detallePedidos.stream()
                        .mapToDouble(detalle -> detalle.getSubtotal())
                        .sum();
            }

            pedido.setTotal(total);
            return pedidoRepository.save(pedido);

        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido update(Pedido pedido) throws Exception {
        try{
            calcularTotal(pedido);
            return pedidoRepository.save(pedido);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorCliente(Long clienteId) throws Exception {
        try{
            return pedidoRepository.findAllByClienteId(clienteId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorEmpleado(Long empleadoId) throws Exception {
        try{
            return pedidoRepository.findAllByEmpleadoId(empleadoId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Pedido> listarPorSucursal(Long sucursalId) throws Exception {
        try{
            return pedidoRepository.findAllBySucursalId(sucursalId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }



















}
