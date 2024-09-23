package com.example.MiApi.services;

import com.example.MiApi.entities.Promocion;
import com.example.MiApi.entities.Sucursal;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.PromocionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionService extends BaseService<Promocion, Long>{

    @Autowired
    private PromocionRepository promocionRepository;
    public PromocionService(BaseRepository<Promocion, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Promocion> listarPorSucursal(Long sucursalId) throws Exception {
        try {
            return promocionRepository.findAllBySucursalId(sucursalId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
