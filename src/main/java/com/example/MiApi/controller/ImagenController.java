package com.example.MiApi.controller;

import com.example.MiApi.entities.Imagen;
import com.example.MiApi.repositories.ImagenRepository;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.ImagenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen, Long>{

    public ImagenController(BaseService<Imagen, Long> baseService) {
        super(baseService);
    }
}
