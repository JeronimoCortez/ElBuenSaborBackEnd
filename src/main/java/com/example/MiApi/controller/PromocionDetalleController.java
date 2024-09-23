package com.example.MiApi.controller;

import com.example.MiApi.entities.PromocionDetalle;
import com.example.MiApi.services.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promocionesdetalles")
public class PromocionDetalleController extends BaseController<PromocionDetalle, Long>{
    public PromocionDetalleController(BaseService<PromocionDetalle, Long> baseService) {
        super(baseService);
    }
}
