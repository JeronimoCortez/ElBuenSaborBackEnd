package com.example.MiApi.controller;

import com.example.MiApi.entities.Empresa;
import com.example.MiApi.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController extends BaseController<Empresa, Long>{
    public EmpresaController(BaseService<Empresa, Long> baseService) {
        super(baseService);
    }
}
