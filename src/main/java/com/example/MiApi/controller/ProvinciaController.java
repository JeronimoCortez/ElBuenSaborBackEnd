package com.example.MiApi.controller;

import com.example.MiApi.entities.Provincia;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController extends BaseController<Provincia, Long>{

    @Autowired
    private ProvinciaService provinciaService;

    public ProvinciaController(BaseService<Provincia, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/pais/{id}")
    public List<Provincia> listarPaises(@PathVariable Long idPais) throws Exception {
        try{
            List<Provincia> pais = provinciaService.listarPais(idPais);
            return ResponseEntity.ok(pais).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
