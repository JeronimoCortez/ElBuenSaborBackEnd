package com.example.MiApi.services;

import com.example.MiApi.entities.Provincia;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.ProvinciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService extends BaseService<Provincia, Long>{
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public ProvinciaService(BaseRepository<Provincia, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Provincia> listarPais(Long paisId) throws Exception {
        try{
            return provinciaRepository.findAllByPaisId(paisId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
