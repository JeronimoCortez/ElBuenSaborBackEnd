package com.example.MiApi.controller;

import com.example.MiApi.entities.UnidadMedida;
import com.example.MiApi.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidadesmedidas")
public class UnidadMedidaController extends BaseController<UnidadMedida, Long>{
    public UnidadMedidaController(BaseService<UnidadMedida, Long> baseService) {
        super(baseService);
    }
}
