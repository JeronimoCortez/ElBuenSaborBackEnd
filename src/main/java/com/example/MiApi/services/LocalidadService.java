package com.example.MiApi.services;

import com.example.MiApi.entities.Localidad;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService extends BaseService<Localidad, Long>{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadService(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Localidad> listarProvincia(Long provinciaId) throws Exception {
        try{
            return localidadRepository.findAllByProvinciaId(provinciaId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
