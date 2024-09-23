package com.example.MiApi.services;

import com.example.MiApi.entities.Pais;
import com.example.MiApi.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends BaseService<Pais, Long> {
    public PaisService(BaseRepository<Pais, Long> baseRepository) {
        super(baseRepository);
    }
}
