package com.example.MiApi.controller;

import com.example.MiApi.entities.Empleado;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController extends BaseController<Empleado, Long>{

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(BaseService<Empleado, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/sucursal/{id}")
    public ResponseEntity<List<Empleado>> listarPorSucursal(@PathVariable Long idSucursal) throws Exception {
        try{
            List<Empleado> empleados = empleadoService.listarPorSucursal(idSucursal);
            return ResponseEntity.ok(empleados);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
}
