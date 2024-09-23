package com.example.MiApi.services;

import com.example.MiApi.entities.Domicilio;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService extends BaseService<Domicilio,Long>{

    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioService(BaseRepository<Domicilio, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Domicilio> listarLocalidad(Long localidadId) throws Exception {
        try{
            return domicilioRepository.findAllByLocalidadId(localidadId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
