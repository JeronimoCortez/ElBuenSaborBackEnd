package com.example.MiApi.controller;

import com.example.MiApi.entities.Sucursal;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sucursales")
public class SucursalController extends BaseController<Sucursal, Long>{

    @Autowired
    private SucursalService sucursalService;

    public SucursalController(BaseService<Sucursal, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/empresa/{id}")
    public List<Sucursal> listarPorEmpresa(@PathVariable Long empresaId) throws Exception {
        try {
            List<Sucursal> empresa = sucursalService.listarPorEmpresa(empresaId);
            return ResponseEntity.ok(empresa).getBody();
        }catch (Exception ex){
             throw new Exception(ex.getMessage());
        }
    }

}
