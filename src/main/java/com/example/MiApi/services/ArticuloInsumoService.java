package com.example.MiApi.services;

import com.example.MiApi.entities.Articulo;
import com.example.MiApi.entities.ArticuloInsumo;
import com.example.MiApi.repositories.ArticuloInsumoRepository;
import com.example.MiApi.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoService(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Articulo> listarImagenes(Long idImagen) throws Exception {
        try{
            return articuloInsumoRepository.findAllByImagenId(idImagen);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Articulo> mostrarCategoria(Long idCategoria) throws Exception {
        try{
            return articuloInsumoRepository.findAllByCategoriaId(idCategoria);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
