package com.example.MiApi.controller;

import com.example.MiApi.entities.DetallePedido;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalles_pedidos")
public class DetallePedidoController extends BaseController<DetallePedido, Long>{
    public DetallePedidoController(BaseService<DetallePedido, Long> baseService) {
        super(baseService);
    }

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/pedido/{id}")
    private List<DetallePedido> listarPedido(@PathVariable Long id) throws Exception {
        try{
            List<DetallePedido> detallePedidos = detallePedidoService.listarPorPedido(id);
            return ResponseEntity.ok(detallePedidos).getBody();
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
}
