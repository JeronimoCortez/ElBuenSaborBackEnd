package com.example.MiApi.controller;

import com.example.MiApi.entities.Domicilio;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController extends BaseController<Domicilio, Long>{

    @Autowired
    private DomicilioService domicilioService;

    public DomicilioController(BaseService<Domicilio, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/localidades/{id}")
    public List<Domicilio> listarLocalidad(@PathVariable Long localidadId) throws Exception {
        try{
            List<Domicilio> localidades = domicilioService.listarLocalidad(localidadId);
            return ResponseEntity.ok(localidades).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
