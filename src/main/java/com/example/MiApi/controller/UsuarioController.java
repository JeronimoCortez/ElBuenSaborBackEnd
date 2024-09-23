package com.example.MiApi.controller;

import com.example.MiApi.entities.Usuario;
import com.example.MiApi.repositories.UsuarioRepository;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, Long>{
    public UsuarioController(BaseService<Usuario, Long> baseService) {
        super(baseService);
    }
}
