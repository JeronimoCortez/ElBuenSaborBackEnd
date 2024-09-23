package com.example.MiApi.services;

import com.example.MiApi.entities.Sucursal;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService extends BaseService<Sucursal, Long>{

    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalService(BaseRepository<Sucursal, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Sucursal> listarPorEmpresa(Long empresaId) throws Exception {
        try{
            return sucursalRepository.findAllByEmpresaId(empresaId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
