package com.example.MiApi.services;

import com.example.MiApi.entities.Factura;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService extends BaseService<Factura, Long>{

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaService(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Factura> listarPedido(Long idPedido) throws Exception{
        try{
            return facturaRepository.findAllByPedidoId(idPedido);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
