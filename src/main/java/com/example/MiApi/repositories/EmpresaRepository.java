package com.example.MiApi.repositories;

import com.example.MiApi.entities.Empresa;
import org.springframework.stereotype.Controller;

@Controller
public interface EmpresaRepository extends BaseRepository<Empresa, Long>{
}
