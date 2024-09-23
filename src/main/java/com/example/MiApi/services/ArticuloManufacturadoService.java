package com.example.MiApi.services;

import com.example.MiApi.entities.Articulo;
import com.example.MiApi.entities.ArticuloManufacturado;
import com.example.MiApi.repositories.ArticuloManufacturadoRepository;
import com.example.MiApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoService extends BaseService<ArticuloManufacturado,Long>{
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    public ArticuloManufacturadoService(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Articulo> listarImagenes(Long idImagen) throws Exception {
        try{
            return articuloManufacturadoRepository.findAllByImagenId(idImagen);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Articulo> mostrarCategoria(Long idCategoria) throws Exception {
        try{
            return articuloManufacturadoRepository.findAllByCategoriaId(idCategoria);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
