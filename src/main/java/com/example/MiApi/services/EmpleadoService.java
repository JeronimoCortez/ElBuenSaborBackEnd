package com.example.MiApi.services;

import com.example.MiApi.entities.Empleado;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService extends BaseService<Empleado, Long> {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(BaseRepository<Empleado, Long> baseRepository) {
        super(baseRepository);
    }

    @Transactional
    public List<Empleado> listarPorSucursal(Long idSucursal) throws Exception {
        try{
            return empleadoRepository.findAllBySucursalId(idSucursal);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

}
