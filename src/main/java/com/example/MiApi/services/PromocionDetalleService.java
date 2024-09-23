package com.example.MiApi.services;

import com.example.MiApi.entities.PromocionDetalle;
import com.example.MiApi.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PromocionDetalleService extends BaseService<PromocionDetalle, Long>{
    public PromocionDetalleService(BaseRepository<PromocionDetalle, Long> baseRepository) {
        super(baseRepository);
    }
}
