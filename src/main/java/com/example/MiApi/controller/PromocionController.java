package com.example.MiApi.controller;

import com.example.MiApi.entities.Promocion;
import com.example.MiApi.entities.Sucursal;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promociones")
public class PromocionController extends BaseController<Promocion, Long>{

    @Autowired
    private PromocionService promocionService;
    public PromocionController(BaseService<Promocion, Long> baseService) {
        super(baseService);
    }
    @GetMapping("/sucursal/{id}")
    public List<Promocion> listarPorSucursal(@PathVariable Long sucursalId) throws Exception {
        try{
            List<Promocion> sucursal = promocionService.listarPorSucursal(sucursalId);
            return ResponseEntity.ok(sucursal).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
