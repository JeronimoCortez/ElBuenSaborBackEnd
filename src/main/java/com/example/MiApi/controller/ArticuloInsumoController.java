package com.example.MiApi.controller;

import com.example.MiApi.entities.Articulo;
import com.example.MiApi.entities.ArticuloInsumo;
import com.example.MiApi.services.ArticuloInsumoService;
import com.example.MiApi.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulosInsumos")
public class ArticuloInsumoController extends BaseController<ArticuloInsumo, Long>{
    private ArticuloInsumoService articuloInsumoService;
    public ArticuloInsumoController(BaseService<ArticuloInsumo, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/imagenes/{id}")
    public List<Articulo> listarImagenes(@PathVariable Long idImagen) throws Exception {
        try{
            List<Articulo> imagenes = articuloInsumoService.listarImagenes(idImagen);
            return ResponseEntity.ok(imagenes).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/categoria/{id}")
    public List<Articulo> mostrarCategorias(@PathVariable Long idCategoria) throws Exception {
        try{
            List<Articulo> categoria = articuloInsumoService.mostrarCategoria(idCategoria);
            return ResponseEntity.ok(categoria).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
