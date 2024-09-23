package com.example.MiApi.controller;

import com.example.MiApi.entities.Categoria;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<Categoria, Long>{
    public CategoriaController(BaseService<Categoria, Long> baseService) {
        super(baseService);
    }

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/subcategorias/{id_CP}")
    public Optional<Categoria> añadirSubcategoria(@PathVariable Long id_CP, @RequestBody Categoria subcategoria) throws Exception {
        Categoria categoriaPadre = categoriaService.añadirSubcategoria(id_CP, subcategoria);
        return Optional.ofNullable(categoriaPadre);
    }

    @GetMapping("/categoriaPadre/{id}")
    public ResponseEntity<List<Categoria>> listarPorCategoriaPadre(@PathVariable Long id) throws Exception {
        List<Categoria> subcategorias =  categoriaService.listarSubcategorias(id);
        return ResponseEntity.ok(subcategorias);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Categoria>> listarPorSucursal(@PathVariable Long id) throws Exception {
        try{
            List<Categoria> categorias = categoriaService.listarPorSucursal(id);
            return ResponseEntity.ok(categorias);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
}
