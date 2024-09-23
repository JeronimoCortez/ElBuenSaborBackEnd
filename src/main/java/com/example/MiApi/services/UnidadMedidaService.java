package com.example.MiApi.services;

import com.example.MiApi.entities.UnidadMedida;
import com.example.MiApi.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaService extends BaseService<UnidadMedida, Long>{
    public UnidadMedidaService(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);
    }
}
