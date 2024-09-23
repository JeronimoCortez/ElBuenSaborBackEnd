package com.example.MiApi.services;

import com.example.MiApi.entities.DetallePedido;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.DetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService extends BaseService<DetallePedido, Long>{
    public DetallePedidoService(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional
    public List<DetallePedido> listarPorPedido(Long idPedido) throws Exception {
        try{
            return detallePedidoRepository.findAllByPedidoId(idPedido);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
