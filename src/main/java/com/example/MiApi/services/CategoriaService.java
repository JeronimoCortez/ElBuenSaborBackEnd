package com.example.MiApi.services;

import com.example.MiApi.entities.Categoria;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService extends BaseService<Categoria, Long>{
    public CategoriaService(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria añadirSubcategoria(Long idCategoriaPadre,Categoria subcategoria) throws Exception {
        try {
            Categoria categoriaPadre = categoriaRepository.findById(idCategoriaPadre).orElse(null);

            if (categoriaPadre != null) {
                subcategoria.setCategoriaPadre(categoriaPadre);
                categoriaRepository.save(subcategoria);
                return subcategoria;
            }else {
                return null;
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarSubcategorias(Long idCategoriaPadre) throws Exception {
        try{
            return categoriaRepository.findAllByCategoriaPadre_Id(idCategoriaPadre);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Transactional
    public List<Categoria> listarPorSucursal(Long idSucursal) throws Exception {
        try{
            return categoriaRepository.findAllBySucursal_Id(idSucursal);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
