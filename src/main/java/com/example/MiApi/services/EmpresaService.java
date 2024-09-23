package com.example.MiApi.services;

import com.example.MiApi.entities.Empresa;
import com.example.MiApi.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends BaseService<Empresa, Long>{
    public EmpresaService(BaseRepository<Empresa, Long> baseRepository) {
        super(baseRepository);
    }
}
