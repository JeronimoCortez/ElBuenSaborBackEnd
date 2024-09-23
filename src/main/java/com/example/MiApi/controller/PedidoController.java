package com.example.MiApi.controller;

import com.example.MiApi.entities.Pedido;
import com.example.MiApi.repositories.PedidoRepository;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseController<Pedido, Long>{

    @Autowired
    private PedidoService pedidoService;

    public PedidoController(BaseService<Pedido, Long> baseService) {
        super(baseService);
    }

    @PutMapping("/total")
    public Optional<Pedido> calcularTotal(@RequestBody Pedido pedido) throws Exception {
        Pedido pedido_aux = pedidoService.calcularTotal(pedido);
        return Optional.ofNullable(pedido_aux);
    }

    @GetMapping("/clientes/{id}")
    public List<Pedido> listarPorCliente(@PathVariable Long clienteId) throws Exception {
        try{
            List<Pedido> clientes = pedidoService.listarPorCliente(clienteId);
            return ResponseEntity.ok(clientes).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/empleados/{id}")
    public List<Pedido> listarPorEmpleado(@PathVariable Long empleadoId) throws Exception {
        try{
            List<Pedido> empleado = pedidoService.listarPorEmpleado(empleadoId);
            return ResponseEntity.ok(empleado).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/sucursal/{id}")
    public List<Pedido> listarPorSucursal(@PathVariable Long sucursalId) throws Exception {
        try {
            List<Pedido> sucursal = pedidoService.listarPorSucursal(sucursalId);
            return ResponseEntity.ok(sucursal).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }



}
