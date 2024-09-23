package com.example.MiApi.services;

import com.example.MiApi.entities.ArticuloManufacturado;
import com.example.MiApi.entities.ArticuloManufacturadoDetalle;
import com.example.MiApi.repositories.ArticuloManufacturadoDetalleRepository;
import com.example.MiApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoDetalleService extends BaseService<ArticuloManufacturadoDetalle,Long>{

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleService(ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository){
        super(articuloManufacturadoDetalleRepository);
    }


    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloInsumo(Long articuloInsumoId) throws Exception {
        try{
            return articuloManufacturadoDetalleRepository.findAllByArticuloInsumoId(articuloInsumoId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<ArticuloManufacturadoDetalle> listarPorArticuloManufacturado(Long articuloManufacturadoId) throws Exception {
        try{
            return articuloManufacturadoDetalleRepository.findAllByArticuloManufacturadoId(articuloManufacturadoId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
