package com.example.MiApi.controller;

import com.example.MiApi.entities.Pais;
import com.example.MiApi.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController extends BaseController<Pais, Long>{
    public PaisController(BaseService<Pais, Long> baseService) {
        super(baseService);
    }
}
