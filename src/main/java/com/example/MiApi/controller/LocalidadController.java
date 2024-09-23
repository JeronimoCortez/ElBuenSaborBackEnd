package com.example.MiApi.controller;

import com.example.MiApi.entities.Localidad;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController extends BaseController<Localidad, Long>{

    @Autowired
    private LocalidadService localidadService;

    public LocalidadController(BaseService<Localidad, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/provincia/{id}")
    public List<Localidad> listarProvincia(Long provinciaId) throws Exception {
        try{
            List<Localidad> provincias = localidadService.listarProvincia(provinciaId);
            return ResponseEntity.ok(provincias).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
