package com.example.MiApi.services;

import com.example.MiApi.entities.Cliente;
import com.example.MiApi.entities.Empleado;
import com.example.MiApi.repositories.BaseRepository;
import com.example.MiApi.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService extends BaseService<Cliente, Long>{
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteService(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }
    @Transactional
    public List<Cliente> listarPorDomicilio(Long domicilioId) throws Exception {
        try{
            return clienteRepository.findAllByDomicilioId(domicilioId);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
