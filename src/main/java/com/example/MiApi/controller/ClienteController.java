package com.example.MiApi.controller;

import com.example.MiApi.entities.Cliente;
import com.example.MiApi.entities.Domicilio;
import com.example.MiApi.entities.Empleado;
import com.example.MiApi.repositories.ClienteRepository;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.ClienteService;
import com.example.MiApi.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController<Cliente, Long>{

    @Autowired
    private ClienteService clienteService;
    public ClienteController(BaseService<Cliente, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/domicilio/{id}")
    public List<Cliente> listarPorDomicilio(@PathVariable Long domicilioId) throws Exception {
        try{
            List<Cliente> domicilio = clienteService.listarPorDomicilio(domicilioId);
            return ResponseEntity.ok(domicilio).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }


}
