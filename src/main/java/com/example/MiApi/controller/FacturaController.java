package com.example.MiApi.controller;

import com.example.MiApi.entities.Factura;
import com.example.MiApi.services.BaseService;
import com.example.MiApi.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController extends BaseController<Factura, Long>{

    @Autowired
    private FacturaService facturaService;

    public FacturaController(BaseService<Factura, Long> baseService) {
        super(baseService);
    }

    @GetMapping("/pedido/{id}")
    public List<Factura> listarPedido(Long idPedido) throws Exception {
        try{
            List<Factura> pedidos = facturaService.listarPedido(idPedido);
            return ResponseEntity.ok(pedidos).getBody();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
